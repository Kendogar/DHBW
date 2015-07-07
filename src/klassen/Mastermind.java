package klassen;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Lars on 06.02.2015.
 */
public class Mastermind {
    int richtigerBuchstabe, richtigePosition, zuege;
    char codeComputer[] = new char[5];
    char codeSpieler[][] = new char[20][5];
    String pool = "ABCDEF";

    public Mastermind(){
        Random rnd = new Random();
        for (int i = 0; i <= 4; i++){
            codeComputer[i] = pool.charAt(rnd.nextInt(6));
        }
        zuege = 0;
    }

    public void spielstart() {
        while (true){
            this.tipp();
            this.vergleich();
            System.out.println("Bisherige Versuche: " + zuege);
            if (richtigePosition == 5){
                System.out.println("Gewonnen mit "+zuege+" Spielzügen!");
                break;
            }
            for (int i = 0; i < zuege; i++){
                System.out.println(this.toString(i));
            }
            System.out.println(String.valueOf(codeComputer));
        }

    }

    public void tipp(){
        System.out.println("Bitte Tipp abgeben:");
        Scanner scan = new Scanner(System.in);
        String temp = scan.nextLine().toUpperCase();
        if (temp.length() > 5){
            temp = temp.substring(0, 5);
        }
        codeSpieler[zuege] = temp.toCharArray();
    }

    public void vergleich(){
        int iA = 0;
        int iB = 0;
        int iC = 0;
        int iD = 0;
        int iE = 0;
        int iF = 0;
        richtigePosition = 0;
        richtigerBuchstabe = 0;
        for (int i = 0; i < 5; i++) {
            if (codeComputer[i] == codeSpieler[zuege][i]) {
                richtigePosition++;
            }
        }
        for (int i = 0; i < codeComputer.length; i++) {
            char test = codeSpieler[zuege][i];
            switch(test){
                case 'A':
                    for (int a = iA; a < (codeComputer.length); a++){
                        if (codeComputer[a] == 'A'){
                            richtigerBuchstabe++;
                            iA = a+1;
                            break;
                        }
                    } break;
                case 'B':
                    for (int b = iB; b < (codeComputer.length); b++){
                        if (codeComputer[b] == 'B'){
                            richtigerBuchstabe++;
                            iB = b+1;
                            break;
                        }
                    } break;
                case 'C':
                    for (int c = iC; c < (codeComputer.length); c++){
                        if (codeComputer[c] == 'C'){
                            richtigerBuchstabe++;
                            iC = c+1;
                            break;
                        }
                    } break;
                case 'D':
                    for (int d = iD; d < (codeComputer.length); d++){
                        if (codeComputer[d] == 'D'){
                            richtigerBuchstabe++;
                            iD = d+1;
                            break;
                        }
                    } break;
                case 'E':
                    for (int e = iE; e < (codeComputer.length); e++){
                        if (codeComputer[e] == 'E'){
                            richtigerBuchstabe++;
                            iE = e+1;
                            break;
                        }
                    } break;
                case 'F':
                    for (int f = iF; f < (codeComputer.length); f++){
                        if (codeComputer[f] == 'F'){
                            richtigerBuchstabe++;
                            iF = f+1;
                            break;
                        }
                    }break;
                default:
                    break;
            }
        }
        zuege++;
    }

    public String toString(int i){
        return String.format("%s %d %d" ,String.valueOf(codeSpieler[i]), richtigerBuchstabe, richtigePosition);
    }

    public static void main(String[] args) {
        Mastermind masta = new Mastermind();
        masta.spielstart();
    }
}
