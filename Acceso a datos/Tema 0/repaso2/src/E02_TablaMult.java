import java.util.Scanner;

public class E02_TablaMult {
    public static void tablasMultiplicar() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número: ");

        int num = sc.nextInt();

        for (int i = 0; i <= 30000; i++) {
            System.out.println(num + " x " + i + " = " + num*i);
        }
    }
}
