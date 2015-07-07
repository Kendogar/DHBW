package arrays_2;

import java.util.Arrays;

/**
 * Created by Lars on 30.01.2015.
 */
public class A7_Matrizendifferenz {
    public static void main(String[] args) {
        int array_1[][] = new int[4][4];
        int array_2[][] = new int[4][4];
        int array_erg[][] = new int[4][4];
        int mult1 = 3;
        int mult2 = 1;

        // Array_1 befüllen:
        for (int i = 0; i < array_1.length; i++){
            for (int j = 0; j < array_1.length; j++){
                array_1[i][j] = mult1 * (j+1);
            }
        }
        // Array_2 befüllen
        for (int i = 0; i < array_2.length; i++){
            for (int j = 0; j < array_2.length; j++){
                array_2[i][j] = mult2;
            }
            mult2++;
        }

        // Array_erg berechnen
        for (int i = 0; i < array_erg.length; i++){
            for (int j = 0; j < array_erg.length; j++){
                array_erg[i][j] = array_1[i][j] - array_2[i][j];
            }
        }

        // Array_erg ausgeben
        for (int i = 0; i < array_erg.length; i++) {
            for (int j = 0; j < array_erg.length; j++) {
                System.out.print(array_erg[i][j] + " ");
            }
            System.out.print("\n");
        }

    }
}
