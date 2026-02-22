package com.example.appincidencias.worker;

import android.content.Context;
import android.util.Log;

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
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailWorker extends Worker {

    private static final String TAG = "EmailWorker";

    public EmailWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        AppPreferences prefs = new AppPreferences(getApplicationContext());

        if (!prefs.isEnvioActivo()) {
            Log.d(TAG, "Envío desactivado en preferencias.");
            return Result.success();
        }

        String emailDestino = prefs.getEmail();
        if (emailDestino == null || emailDestino.isEmpty()) {
            Log.e(TAG, "No hay email configurado para el envío.");
            return Result.failure();
        }

        List<Incidencia> pendientes = AppDatabase.getInstance(getApplicationContext())
                .incidenciaDao().getPendientes();

        if (pendientes.isEmpty()) {
            Log.d(TAG, "No hay incidencias pendientes para resumir.");
            return Result.success();
        }

        String prompt = "Actúa como un gestor de IT experto. Genera un resumen ejecutivo profesional para un correo electrónico. " +
                "Agrupa las incidencias por ubicación y tipo de dispositivo. " +
                "Destaca claramente aquellas con prioridad ALTA. " +
                "Utiliza un tono formal y estructurado. " +
                "Datos de incidencias pendientes:\n" + formatIncidencias(pendientes);

        try {
            String resumenIA = generarResumenConGemini(prompt);
            enviarEmail(emailDestino, resumenIA);
            Log.d(TAG, "Email enviado correctamente a " + emailDestino);
            return Result.success();
        } catch (Exception e) {
            Log.e(TAG, "Error en el trabajador de correo: " + e.getMessage());
            return Result.retry();
        }
    }

    private String generarResumenConGemini(String prompt) throws ExecutionException, InterruptedException {
        // NOTA: En un entorno real, la API KEY debería obtenerse de forma segura (BuildConfig o similar)
        GenerativeModel gm = new GenerativeModel("gemini-1.5-flash", "NO_TENGO_API_KEY");
        GenerativeModelFutures model = GenerativeModelFutures.from(gm);

        Content content = new Content.Builder().addText(prompt).build();
        ListenableFuture<GenerateContentResponse> response = model.generateContent(content);

        return response.get().getText();
    }

    private String formatIncidencias(List<Incidencia> lista) {
        StringBuilder sb = new StringBuilder();
        for (Incidencia i : lista) {
            sb.append(String.format("- [%s] %s en %s (%s). Identificación: %s. Descripción: %s\n",
                    i.prioridad, i.tipoDispositivo, i.ubicacion, i.estado, i.identificacion, i.descripcion));
        }
        return sb.toString();
    }

    private void enviarEmail(String destino, String cuerpo) throws MessagingException {
        // Datos del servidor SMTP (Configuración segura requerida en producción)
        final String usuario = "tu-correo@gmail.com";
        final String password = "tu-app-password"; 

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

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(usuario));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destino));
        message.setSubject("Resumen de Incidencias Pendientes - Sistema FIAG");
        message.setText(cuerpo);

        Transport.send(message);
    }
}