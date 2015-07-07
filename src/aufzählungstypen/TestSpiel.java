package aufzählungstypen;

/**
 * Created by Lars on 09.06.2015.
 */
public class TestSpiel {

    public static void main(String[] args) {
        Spielkarte harz7 = new Spielkarte("HERZ", "SIEBEN");
        Kartenspiel datSpiel = new Kartenspiel();
        datSpiel.shuffle();
        for (int i = 0; i< 10; i++){
            Spielkarte temp = datSpiel.get();
            System.out.println(i + 1 + "te Karte: " + temp.toString());
            if (temp.compareTo(harz7) == -1){
                System.out.println(" - Karte ist kleiner als Herz 7");
            }
            else {
                System.out.println(" - Karte ist größer als Herz 7");
            }
        }
        datSpiel.sort();
        System.out.println("\n");
        datSpiel.ausgabe();
    }
}
