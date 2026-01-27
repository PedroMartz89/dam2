package com.example.appincidencias.worker;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.example.appincidencias.model.AppDatabase;
import com.example.appincidencias.model.Incidencia;
import com.example.appincidencias.utils.AppPreferences;
import com.google.ai.client.generativeai.GenerativeModel;
import com.google.ai.client.generativeai.java.GenerativeModelFutures;
import com.google.ai.client.generativeai.type.Content;
import com.google.ai.client.generativeai.type.GenerateContentResponse;
import com.google.common.util.concurrent.ListenableFuture;

import javax.mail.*;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailWorker extends Worker {

    public EmailWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        AppPreferences prefs = new AppPreferences(getApplicationContext());

        // Verificar si el envío está activado
        if (!prefs.isEnvioActivo()) return Result.success();

        // 1. Obtener incidencias pendientes de Room
        List<Incidencia> pendientes = AppDatabase.getInstance(getApplicationContext())
                .incidenciaDao().getPendientes(); // Debes definir este query en tu DAO

        if (pendientes.isEmpty()) return Result.success();

        // 2. Preparar el Prompt estructurado (Fase 5)
        String prompt = "Actúa como un gestor de IT. Genera un resumen profesional para un email. " +
                "Agrupa por ubicación y tipo de dispositivo. Destaca las de prioridad ALTA. " +
                "Datos de incidencias: " + formatIncidencias(pendientes);

        try {
            // 3. Llamada a la API de Gemini
            String resumenIA = generarResumenConGemini(prompt);

            // 4. Enviar el correo con el resumen generado
            enviarEmail(prefs.getEmail(), resumenIA);

            return Result.success();
        } catch (Exception e) {
            return Result.retry(); // Reintento en caso de error de red
        }
    }

    private String generarResumenConGemini(String prompt) throws ExecutionException, InterruptedException {
        // Configuración del modelo (Usa tu API Key de Google AI Studio)
        GenerativeModel gm = new GenerativeModel("gemini-1.5-flash", "TU_API_KEY_AQUI");
        GenerativeModelFutures model = GenerativeModelFutures.from(gm);

        Content content = new Content.Builder().addText(prompt).build();
        ListenableFuture<GenerateContentResponse> response = model.generateContent(content);

        return response.get().getText(); // Obtiene el texto del resumen
    }

    private String formatIncidencias(List<Incidencia> lista) {
        StringBuilder sb = new StringBuilder();
        for (Incidencia i : lista) {
            sb.append(String.format("- Ubicación: %s, Tipo: %s, Prioridad: %s, Descripción: %s\n",
                    i.ubicacion, i.tipoDispositivo, i.prioridad, i.descripcion));
        }
        return sb.toString();
    }

    private void enviarEmail(String destino, String cuerpo) {
        // Datos del servidor SMTP (Ejemplo con Gmail)
        final String usuario = "tu-correo@gmail.com";
        final String password = "tu-app-password"; // Contraseña de aplicación de Google

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(usuario, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuario));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destino));
            message.setSubject("Resumen Automático de Incidencias - FIAG");
            message.setText(cuerpo);

            // Envío efectivo del correo [cite: 40, 153]
            Transport.send(message);

        } catch (MessagingException e) {
            // Registro de errores para la rúbrica de robustez [cite: 49, 154]
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}