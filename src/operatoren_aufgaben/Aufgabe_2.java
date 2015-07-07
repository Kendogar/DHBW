package operatoren_aufgaben;

import java.util.Scanner;

/**
 * Created by Lars on 16.01.2015.
 */
public class Aufgabe_2 {
    public static void main (String[] args){
        int a, b, c, k, p, q, M, N, d, e, Ostern;
        int Jahr = 0;
        boolean test = true;
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.println("Jahr eingeben: ");
        while (test){
            if (scan.hasNextInt()){
                Jahr = scan.nextInt();
                test = false;
            } else {
                System.out.println("NOPE");
                scan.next();
                System.out.println("Jahr eingeben: ");
            }
        }


        a = Jahr % 19;
        b = Jahr % 4;
        c = Jahr % 7;
        k = Jahr / 100;
        p = (8*k + 13)/25;
        q = k / 4;
        M = ( 15 + k - p - q) % 30;
        N = (4 + k - q) % 7;
        d = (19 * a + M) % 30;
        e = (2 * b + 4 * c + 6 * d + N) % 7;

        Ostern = ( 22 + d + e);

        if (Ostern > 31) {
            Ostern -= 31;
            System.out.println("Ostern ist der " + Ostern + "te April" );
        } else {
            System.out.println("Ostern ist der " + Ostern + "te März");
        }
    }
}
