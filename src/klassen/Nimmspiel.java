package klassen;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Lars on 06.02.2015.
 */
public class Nimmspiel {
    private String aktueller_spieler;
    private String[] spieler = new String[2];
    int kugeln_1, kugeln_2, kugeln_1_total, kugeln_2_total, spielerindex;


    public Nimmspiel(String erster, String zweiter){

        this.spieler[0] = erster;
        this.spieler[1] = zweiter;
        Random rnd = new Random();
        this.spielerindex = rnd.nextInt(2);
        this.aktueller_spieler = spieler[spielerindex];
        this.kugeln_1 = rnd.nextInt(10) + 4;
        this.kugeln_2 = rnd.nextInt(10) + 4;
        this.kugeln_1_total = this.kugeln_1;
        this.kugeln_2_total = this.kugeln_2;

    }

    public void spielstart(){
        while (this.kugeln_1 > 0 || this.kugeln_2 > 0){
            System.out.println(this.toString());
            this.spielzug();
            System.out.println(this.siegbedingung());
            this.naechsterspieler();


        }
    }

    public void spielzug(){
        int haufen, kugeln, test;
        boolean check = true;
        Scanner zugeingabe = new Scanner(System.in);
        while (check){
            System.out.println("Von welchem Haufen willst du wegnehmen?");
            haufen = zugeingabe.nextInt();
            if (haufen == 1 && this.kugeln_1 > 0 || haufen == 2 && this.kugeln_2 > 0){
                while(check){
                    System.out.println("Wieviele Kugeln?");
                    kugeln = zugeingabe.nextInt();
                    if (haufen == 1){
                        if (kugeln > 0 && kugeln < this.kugeln_1_total){
                            this.kugeln_1 -= kugeln;
                            check = false;
                        }
                        else {
                            System.out.println("Ungültige Eingabe.\n");
                        }
                    }
                    else {
                        if (kugeln > 0 && kugeln < this.kugeln_2_total){
                            this.kugeln_2 -= kugeln;
                            check = false;
                        }
                        else {
                            System.out.println("Ungültige Eingabe.\n");
                        }
                    }
                }
            }
            else {
                System.out.println("Ungültige Eingabe, versuch's nochmal.\n");
            }
        }
    }


    public String siegbedingung(){
        if (this.kugeln_1 == 0 && this.kugeln_2 == 0){
            return String.format("%s hat gewonnen!", this.aktueller_spieler);
        }
        else{
            return "Nächste Runde!";
        }
    }

    public void naechsterspieler(){
        if (this.spielerindex == 1){
            this.spielerindex -= 1;
        }
        else {
            this.spielerindex += 1;
        }
        this.aktueller_spieler = this.spieler[this.spielerindex];
    }

    public String toString(){
        return String.format("Haufen 1: %d Kugeln\t | Haufen 2: %d Kugeln\t | Aktueller Spieler: %s", this.kugeln_1, this.kugeln_2, this.aktueller_spieler);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Spieler 1:");
        String s1 = scan.next();
        System.out.println("Spieler 2:");
        String s2 = scan.next();
        Nimmspiel spiel = new Nimmspiel(s1, s2);


        System.out.println("Spiel starten?");
        int answer = scan.nextInt();
        if (answer == 1){
            spiel.spielstart();
        }
        else {
            System.out.println("Goodbye.");
        }
    }
}
