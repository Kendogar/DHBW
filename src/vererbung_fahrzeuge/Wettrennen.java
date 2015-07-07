package vererbung_fahrzeuge;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Lars on 20.02.2015.
 */
public class Wettrennen {
    Fahrzeug[] fz;

    public Wettrennen(){
        fz = new Fahrzeug[4];
        fz[0] = new Fahrrad();
        fz[0].setGeschwindigkeit(20);
        fz[1] = new Auto();
        fz[1].setGeschwindigkeit(150);
        fz[2] = new Rennwagen();
        fz[2].setGeschwindigkeit(200);
        fz[3] = new Krankenwagen();
        fz[3].setGeschwindigkeit(80);
    }


    public static void main(String[] args) {
        Wettrennen wett = new Wettrennen();
        // 4 Stunden Vorsprung für das Fahrrad
        wett.fz[0].bewege(240);
        // Dann alle eine Stunde fahren!
        for(int i=0;i<wett.fz.length;i++)
            wett.fz[i].bewege(60);
        // Stand ausgeben:
        for(int i=0;i<wett.fz.length;i++)
            System.out.println(wett.fz[i]);


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(wett);
        System.out.println(json);
    }
}
