import FTP.GestorFTP;
import Telnet.GestorTelnet;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static GestorFTP gFtp = new GestorFTP();
    private static GestorTelnet gTelnet = new GestorTelnet();

    public static void main(String[] args) {
        int opcion = 0;
        do {
            imprimirMenu();
            try {
                opcion = Integer.parseInt(sc.nextLine());
                procesarOpcion(opcion);
            } catch (Exception e) {
                System.out.println("Error: Entrada no válida o fallo en operación.");
            }
        } while (opcion != 6);
    }

    private static void imprimirMenu() {
        System.out.println("\n1. Conectar FTP\n2. Listar\n3. Cambiar Dir\n4. Descargar\n5. Telnet\n6. Salir");
        System.out.print("Opción: ");
    }

    private static void procesarOpcion(int op) throws Exception {
        switch (op) {
            case 1:
                System.out.print("IP: ");
                String ip = sc.nextLine();
                System.out.print("User: ");
                String u = sc.nextLine();
                System.out.print("Pass: ");
                String p = sc.nextLine();
                if (gFtp.conectar(ip, u, p)) System.out.println("Conectado.");
                break;
            case 2: if(gFtp.estaConectado()) gFtp.listar(); break;
            case 3: 
                System.out.print("Ruta: "); 
                gFtp.cambiarDirectorio(sc.nextLine()); 
                break;
            case 4:
                System.out.print("Archivo: ");
                gFtp.descargar(sc.nextLine());
                break;
            case 5:
                System.out.print("IP Telnet: ");
                String ipT = sc.nextLine();
                System.out.print("Comando: ");
                String cmd = sc.nextLine();
                gTelnet.ejecutarComando(ipT, cmd);
                break;
            case 6: gFtp.cerrar(); break;
        }
    }
}