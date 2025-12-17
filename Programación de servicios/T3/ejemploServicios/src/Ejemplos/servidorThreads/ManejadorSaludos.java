package Ejemplos.servidorThreads;

import javax.swing.table.TableRowSorter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ManejadorSaludos implements Runnable {
    private Socket socket;

    public ManejadorSaludos(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)) {
            Thread.sleep(3000);
            salida.println("Hola, soy el hilo " + Thread.currentThread().getName() + " y  te saludo!");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
