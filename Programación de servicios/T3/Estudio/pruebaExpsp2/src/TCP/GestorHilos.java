package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.Provider;
import java.util.List;

public class GestorHilos extends Thread {
    private String nick;
    private String sala;
    private Socket socketCliente;

    private PrintWriter out;
    private BufferedReader in;
    public GestorHilos(Socket socketCliente) {
        this.nick = null;
        this.sala = null;
        this.socketCliente = socketCliente;
    }

    @Override
    public void run() {
        try {
            this.out = new PrintWriter(socketCliente.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            out.println("Bienvenido al Servidor de Chat. Usa HELP para ver comandos.");

            String linea;
            while ((linea = in.readLine()) != null) {
                if (linea.equalsIgnoreCase("EXIT")) {
                    break;
                } else {
                    procesarComando(linea);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            cerrarConexion();
        }
    }

    private void procesarComando(String linea) {
        // Formato esperado: "COMANDO ARGUMENTO"
        String[] partes = linea.trim().split(" ", 2);
        String comando = partes[0].trim().toUpperCase();
        String argumento = (partes.length > 1) ? partes[1] : null;
        switch (comando) {
            case "CREATE":
                if (!Server.salas.containsKey(argumento)){
                    Server.salas.put(argumento, new Sala(argumento));
                    out.println("Sala " + argumento + " creada.");
                } else {
                    out.println("No se puede crear la sala, ya existe.");
                }
                break;
            case "JOIN":
                if (this.nick == null) {
                    out.println("No puedes entrar a una sala sin un nick asignado.");
                } else if (Server.salas.containsKey(argumento)) {
                    this.sala = argumento;
                    out.println("Has entrado a la sala " + " correctamente.");
                } else {
                    out.println("La sala no existe.");
                }
                break;
            case "NICK":
                this.nick = argumento;
                out.println("Nick " + argumento + " asignado.");
                break;
            case "MSG":
                if (this.sala == null || this.nick == null) {
                    out.println("Debes tener un nick y pertenecer a una sala primero.");
                } else if (argumento.length() > 140) {
                    out.println("No se pueden enviar mensajes de mas de 140 caracteres.");
                } else if (argumento.isEmpty()) {
                    out.println("El mensaje no puede estar vacío.");
                } else {
                    Sala s = Server.salas.get(this.sala);
                    s.publicarMensaje(this.nick, argumento);
                    out.println("Mensaje publicado correctamente.");
                }
                break;
            case "LIST":
                out.println("Salas: " + Server.salas.keySet());
                break;
            case "SHOW":
                if (this.sala == null) {
                    out.println("Debes estar primero en una sala.");
                } else {
                    Sala s = Server.salas.get(sala);
                    List<String> msgLista = s.getMensajes();
                    synchronized (msgLista) {
                        for (String msg : msgLista) {
                            out.println(msg);
                        }
                    }
                    break;
                }

                break;
            case "WHERE":
                out.println(this.sala == null ? "Sin sala" : "En: " + this.sala);
                break;
            case "HELP":
                out.println("COMANDOS: \n" +
                        "\n" +
                        "    CREATE sala1 → Crea una sala llamada \"sala1\".\n" +
                        "\n" +
                        "    JOIN sala1 → Se une a la sala \"sala1\".\n" +
                        "\n" +
                        "    NICK usuario123 → Asigna el nombre de usuario \"usuario123\".\n" +
                        "\n" +
                        "    MSG Hola a todos en esta sala! → Publica un mensaje en la sala actual.\n" +
                        "\n" +
                        "    LIST → Muestra la lista de salas disponibles.\n" +
                        "\n" +
                        "    SHOW → Muestra todos los mensajes de la sala actual.\n" +
                        "\n" +
                        "    WHERE → Muestra el nombre de la sala en la que está actualmente el cliente\n");
                break;
            case null, default:
                out.println("El comando no existe.");
                break;
        }
    }

    private void cerrarConexion() {
        try {
            if (socketCliente != null) socketCliente.close();
            System.out.println("Conexión con el cliente " + nick + " cerrada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
