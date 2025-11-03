import javax.tools.OptionChecker;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Ejecutor gestorTareas = new Ejecutor();
        Scanner sc = new Scanner(System.in);
        gestorTareas.leerConfig("psptab.txt");


    }

    public void menu(Scanner sc, Ejecutor gestorTareas) {

        while (true) {
            System.out.println("Por favor, indica lo que quieres hacer: tareas, finalizar xx o salir.");
            System.out.print("\n>");
            String opcion = sc.nextLine();
            if (!opcion.equals("tareas") && !opcion.equals("finalizar") && !opcion.equals("salir")) {
                System.out.println("Introduce una opción válida.");
            } else {

                switch (opcion) {

                    case "tareas" : {gestorTareas.listarTareas(); break;}
                    case "finalizar": {

                        System.out.println("Introduce el ID: ");
                        sc.nextLine();
                        int id = sc.nextInt();

                        gestorTareas.cancelarTarea(id);
                        break;
                    }
                    case "salir": break;
                }
                break;
            }

        }




    }
}
