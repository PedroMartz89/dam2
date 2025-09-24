//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        RMatriz3();
    }

    public static void RMatriz3() {

        int[][][] numeros = {{{1,2,3},{4,5,6},{7,8,9}},
        {{10,11,12},{13,14,15},{16,17,18}},
        {{19,20,21},{22,23,24},{25,26,27}}};
        System.out.println("for\n");
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                for (int k = 0; k < numeros[i][j].length; k++) {

                    System.out.print(numeros[i][j][k] + " ");

                }
                System.out.println();
            }
        }
        System.out.println("\nfor each\n");
        for (int[][] numero : numeros) {
            for (int[] ints : numero) {
                for (int anInt : ints) {

                    System.out.print(anInt + " ");

                }
                System.out.println();
            }
        }
    }
}