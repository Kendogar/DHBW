package arrays_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Lars on 29.01.2015.
 */
public class A4_Skalarprodukt {
    public static void main(String[] args) {
        int komponenten;
        int skalar = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Wieviele Komponenten?");
        komponenten = scan.nextInt();
        int vektor_1 [] = new int[komponenten];
        int vektor_2 [] = new int[komponenten];

        for (int i = 0; i < vektor_1.length; i++){
            System.out.println("Komponente Y" + (i+1) + " eingeben:");
            vektor_1[i] = scan.nextInt();
        }
        for (int i = 0; i < vektor_2.length; i++){
            System.out.println("Komponente X" + (i+1) + " eingeben:");
            vektor_2[i] = scan.nextInt();
        }

        for (int i = 0; i < vektor_1.length; i++){
            skalar += (vektor_1[i] * vektor_2[i]);
        }
        System.out.println("Skalarprodukt = " + skalar);
    }
}
