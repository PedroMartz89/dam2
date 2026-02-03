package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Map;

public class GestorSubasta extends Thread {

    private String nick;
    private String subasta;
    private int pujaActual;
    private PrintWriter out;
    private BufferedReader in;
    private Socket socketCliente;

    public GestorSubasta(Socket socketCliente) {
        this.socketCliente = socketCliente;
        this.nick = null;
        this.subasta = null;
        this.pujaActual = 0;
    }

    @Override
    public void run() {
        try {
            this.out = new PrintWriter(socketCliente.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            out.println("Bienvenido al Servidor de Subastas. Usa HELP para ver comandos.");

            String linea;
            while ((linea = in.readLine()) != null) {
                if (linea.equalsIgnoreCase("SALIR")) {
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

    private void cerrarConexion() {
        try {
            if (socketCliente != null) socketCliente.close();
            System.out.println("Conexión con el cliente " + nick + " cerrada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void procesarComando(String linea) {
        String[] partes = linea.trim().split(" ");
        System.out.println(partes.length);
        String comando = partes[0].trim().toUpperCase();
        String argumento = (partes.length > 1) ? partes[1] : null;
        String item = (partes.length > 2) ? partes[2] : null;
        String pujaInicial = (partes.length > 3) ? partes[3] : null;

        switch (comando) {
            case "NICK":
                this.nick = argumento;
                out.println("Nick " + argumento + " asignado.");
                break;
            case "CREATE":
                if (nick == null) {
                    out.println("Primero asigna un nick.");
                }
                else if (!ServerTCP.subastas.containsKey(argumento)){
                    ServerTCP.subastas.put(argumento, new Subasta(argumento,item, pujaInicial, nick));
                    out.println("Subasta " + argumento + " creada.");
                } else {
                    out.println("No se puede crear la subasta, ya existe.");
                }
                break;
            case "LISTA":
                out.println("Subastas: " + ServerTCP.subastas.keySet());
                break;
            case "UNIR":
                if (this.nick == null) {
                    out.println("No puedes entrar a una sala sin un nick asignado.");
                } else if (ServerTCP.subastas.containsKey(argumento)) {
                    this.subasta = argumento;
                    out.println("Has entrado a la subasta " + " correctamente.");
                } else {
                    out.println("La subasta no existe.");
                }
                break;

            case "PUJA":
                out.println(subasta + " " + nick);
                if (this.subasta == null || this.nick == null) {
                    out.println("Debes tener un nick y pertenecer a una subasta primero.");
                } else {
                    Subasta s = ServerTCP.subastas.get(subasta);
                    assert argumento != null;
                    if (s.getPujaActual() > Integer.parseInt(argumento)) {
                        out.println("La puja debe ser mayor a la actual (" + s.getPujaActual() + ").");
                    }
                    out.println(s.pujar(Integer.parseInt(argumento), nick));
                }
                break;
            case "ESTADO":
                Subasta subasta1 = ServerTCP.subastas.get(this.subasta);
                out.println("Usuario ganador actual: " + subasta1.getUsuario() + " con puja " + subasta1.getPujaActual());
                break;

            case "HISTORIAL":
                if (this.subasta == null) {
                    out.println("Debes estar primero en una subasta.");
                } else {
                    Subasta subasta2 = ServerTCP.subastas.get(subasta);
                    List<String> pujas = subasta2.getPujas();
                    for (String puja : pujas) {
                        out.println(puja);
                    }
                    break;
                }

            case "HELP":
                out.println("COMANDOS: NICK, CREATE, LISTA, UNIR, PUJA, ESTADO, HISTORIAL, SALIR");
                break;
            default:
                out.println("El comando no existe.");
                break;
        }
    }
}
