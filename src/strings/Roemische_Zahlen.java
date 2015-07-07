package strings;

import java.util.Scanner;

/**
 * Created by Lars on 07.02.2015.
 */
public class Roemische_Zahlen {

    private static int wert(char c){

        switch (c){
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            case 'a':
                return 900; // CM
            case 'b':
                return 400; // CD
            case 'c':
                return 90; // XC
            case 'd':
                return 40; // XL
            case 'e':
                return 9; // IX
            case 'f':
                return 4; // IV
            default:
                return 0;
        }
    }

    public static String eingabe(String s){
        String eingabe = s.toUpperCase();
        eingabe = eingabe.replaceAll("CM", "a");
        eingabe = eingabe.replaceAll("CD", "b");
        eingabe = eingabe.replaceAll("XC", "c");
        eingabe = eingabe.replaceAll("XL", "d");
        eingabe = eingabe.replaceAll("IX", "e");
        eingabe = eingabe.replaceAll("IV", "f");
        return eingabe;
    }

    public static int inDezimal(String s){
        int wert = 0;
        for (int i = 0; i < s.length(); i++){
            wert += wert(s.charAt(i));
        }
        return wert;
    }

    public static void umrechnen(String s){
        System.out.println(inDezimal(eingabe(s)));
    }

    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        System.out.println("Zahl eingeben:");
        String s = scan.next();
        umrechnen(s);
    }
}
