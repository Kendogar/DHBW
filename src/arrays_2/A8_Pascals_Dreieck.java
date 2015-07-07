package arrays_2;

import java.util.Scanner;

/**
 * Created by Lars on 30.01.2015.
 */
public class A8_Pascals_Dreieck {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Größe des Dreiecks eingeben: ");
        int size = scan.nextInt();

        int pascal[][] = new int[size][];
        for (int i = 0; i < pascal.length; i++){
            pascal[i] = new int[i+1];
        }

        pascal[0][0] = 1;
        for (int i = 1; i < pascal.length; i++){
            for (int j = 0; j < pascal[i].length; j++){
                if (j == (pascal[i].length - 1) || j == 0){
                    pascal[i][j] = 1;
                }
                else {
                    pascal[i][j] = pascal[i-1][j-1] + pascal[i - 1][j];
                }
            }

        }

        for (int i = 0; i < pascal.length; i++) {
            for (int j = 0; j < pascal[i].length; j++) {
                System.out.print(pascal[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
