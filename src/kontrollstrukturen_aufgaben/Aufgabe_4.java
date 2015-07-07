package kontrollstrukturen_aufgaben;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 * Created by Lars on 23.01.2015.
 */
public class Aufgabe_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String spieler;
        String topSpieler = "Niemand";
        int randomZahl, zahl, versuche;
        int topVersuche = Integer.MAX_VALUE;
        boolean running = true;

        while(running){
            System.out.println("Spielername eingeben: ");
            spieler = scan.next();
            randomZahl = (int)(Math.random()*100 + 1);
            versuche = 0;

            do {
                System.out.println("Gib eine Zahl 1-100 ein:");
                zahl = scan.nextInt();
                versuche++;
                if ( zahl == randomZahl){
                    System.out.println("Zahl erraten! Toll!\n");
                    System.out.println("Du hast " + versuche + " Versuche gebraucht, meh...\n");
                    if (versuche < topVersuche){
                        topSpieler = spieler;
                        topVersuche = versuche;
                    }
                    System.out.println("Bester Spieler bisher ist " + topSpieler + " mit " + topVersuche + " Versuchen.\n");
                }
                else if (zahl < randomZahl){
                    System.out.println("Zahl ist kleiner als Zufallszahl");
                }
                else {
                    System.out.println("Zahl ist größer als zufallszahl");
                }
            }while(zahl != randomZahl);
            System.out.println("Nochmal spielen?");
            if (scan.nextInt()==0){
                running = false;
            }
        }
        System.out.println("Bye.");
    }
}
