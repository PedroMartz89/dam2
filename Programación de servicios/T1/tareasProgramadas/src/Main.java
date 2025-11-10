import javax.tools.OptionChecker;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Ejecutor gestorTareas = new Ejecutor();
        Scanner sc = new Scanner(System.in);
        gestorTareas.leerConfig("src/psptab.txt");
        menu(sc, gestorTareas);


    }

    public static void menu(Scanner sc, Ejecutor gestorTareas) {

        while (true) {
            System.out.println("Por favor, indica lo que quieres hacer: tareas, finalizar xx o salir.");
            System.out.print("\n>");
            String opcion = sc.nextLine();
            if (!opcion.equals("tareas") && !opcion.equals("finalizar") && !opcion.equals("salir")) {
                System.out.println("Introduce una opción válida.");
            } else {

                switch (opcion) {

                    case "tareas" : {
                        gestorTareas.listarTareas();
                        System.out.println("Pulsa enter para continuar...");
                        sc.nextLine();
                        break;
                    }
                    case "finalizar": {

                        System.out.println("Introduce el ID: ");
                        int id = sc.nextInt();

                        gestorTareas.cancelarTarea(id);
                        break;
                    }
                    case "salir": {

                        System.out.println("Finalizando el programa...");
                        System.exit(0);
                    }

                }

                ;
            }

        }

    }
}
