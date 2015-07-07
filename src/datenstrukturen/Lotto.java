package datenstrukturen;

import java.util.*;

/**
 * Created by Lars on 02.06.2015.
 */
public class Lotto {
    Set<Integer> lottozahlen = new LinkedHashSet<Integer>();
    String ausgabe = "";

    public Lotto(){

    }

    public void ziehung(){
        do {
            int zufallszahl = (int) (Math.random()*49);
            if (!lottozahlen.contains(zufallszahl)){
                lottozahlen.add(zufallszahl);
            }
        } while (lottozahlen.size()<7);
        int count = 0;
        for (Integer i : lottozahlen){
            if (count == 6){
                ausgabe = ausgabe.concat("Zusatzzahl: " + i.toString());
            }
            else {
                ausgabe = ausgabe.concat(i.toString() + " ");
                count++;
            }
        }
        lottozahlen.clear();
        System.out.println(ausgabe);
        ausgabe = "";
    }

    public static void main(String[] args) {
        Lotto lolotto = new Lotto();
        lolotto.ziehung();
        lolotto.ziehung();
        lolotto.ziehung();
        lolotto.ziehung();
    }
}
