package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import java.util.List;

public class ManejadorCliente extends Thread {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    private String nick = null;
    private String sala = null;

    public ManejadorCliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Configurar canales de comunicación
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("Bienvenido al Servidor de Chat. Usa HELP para ver comandos.");

            String linea;
            while ((linea = in.readLine()) != null) {
                procesarComando(linea);
            }
        } catch (IOException e) {
            System.out.println("Cliente desconectado.");
        } finally {
            cerrarConexion();
        }
    }

    private void procesarComando(String linea) {
        String[] partes = linea.trim().split("\\s+", 2);
        String comando = partes[0].toUpperCase();
        String argumento = (partes.length > 1) ? partes[1] : "";

        switch (comando) {
            case "CREATE":
                if (ServidorTCP.mapaSalas.containsKey(argumento)) {
                    out.println("La sala ya existe.");
                } else {
                    ServidorTCP.mapaSalas.put(argumento, new Sala(argumento));
                    out.println("Sala creada correctamente.");
                }
                break;
            case "JOIN":
                if (nick == null) {
                    out.println("Primero asigna un nick.");
                } else if (ServidorTCP.mapaSalas.containsKey(argumento)) {
                    this.sala = argumento;
                    out.println("Te has unido a la sala " + argumento);
                } else {
                    out.println("La sala no existe.");
                }
                break;
            case "NICK":
                this.nick = argumento;
                out.println("Nick asignado.");
                break;
            case "MSG":
                if (this.nick == null || this.sala == null) {
                    out.println("Debes estar en una sala y tener un nick asignado para comentar.");
                } else if (argumento.length() > 140) {
                    out.println("El mensaje es demasiado largo (140 max).");
                } else {
                    Sala s = ServidorTCP.mapaSalas.get(sala);
                    s.nuevoMensaje(this.nick, argumento);
                    out.println("Mensaje publicado");
                }
            case "SHOW":
                 if (this.sala == null) {
                     out.println("Primero únete a una sala.");
                 } else {
                     Sala s = ServidorTCP.mapaSalas.get(sala);
                     List<String> mensajes = s.getMensajes();

                     synchronized (mensajes) {
                         for (String m : mensajes) out.println(m);
                     }
                 }
                 break;
            case "LIST":
                out.println("Salas: " + ServidorTCP.mapaSalas.keySet());
                break;

            case "WHERE":
                out.println(sala == null ? "Sin sala" : "En: " + sala);
                break;
            case null, default:
                out.println("Comandos: CREATE, JOIN, NICK, MSG, LIST, SHOW, WHERE");
            }

    }

    private void cerrarConexion() {
        try {
            if (socket != null) socket.close();
        } catch (IOException e) { e.printStackTrace(); }
    }
}
