package arrays_1;

import java.util.Scanner;

/**
 * Created by Lars on 29.01.2015.
 */
public class A5_Betrag {
    public static void main(String[] args) {
        int komponenten;
        int bla = 0;
        double betrag = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Wieviele Komponenten?");
        komponenten = scan.nextInt();
        int vektor_1 [] = new int[komponenten];

        for (int i = 0; i < vektor_1.length; i++){
            System.out.println("Komponente Y" + (i+1) + " eingeben:");
            vektor_1[i] = scan.nextInt();
        }

        for (int i = 0; i < vektor_1.length; i++){
            bla += (vektor_1[i] * vektor_1[i]);
        }
        betrag = Math.sqrt(bla);
        System.out.println("Betrag = " + betrag);
    }
}
