package arrays_1;

import java.util.Random;

/**
 * Created by Lars on 29.01.2015.
 */
public class A1_Mittelwert_und_Standardabweichung {
    public static void main(String[] args) {
        double mittelwert, standardabweichung;
        double summe = 0;
        double varianz = 0;
        Random rnd = new Random();
        double v [] = new double[100];

        for (int i=0; i < (v.length-1); i++){
            v[i] = rnd.nextDouble()*10;
            summe += v[i];
        }
        mittelwert = summe / v.length;

        for (int i=0; i < (v.length-1); i++){
            varianz += Math.pow((v[i]-mittelwert), 2.0);
        }
        standardabweichung = Math.sqrt(varianz/(v.length-1));

        System.out.println("Summe = " + summe);
        System.out.println("Mittelwert = "+ mittelwert);
        //System.out.println(varianz);
        System.out.println("Standardabweichung = "+ standardabweichung);
    }
}
