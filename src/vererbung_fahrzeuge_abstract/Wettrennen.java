package vererbung_fahrzeuge_abstract;

/**
 * Created by Lars on 20.02.2015.
 */
public class Wettrennen {

    public static void main(String[] args) {
        Fahrzeug[] fz = new Fahrzeug[4];
        fz[0] = new Fahrrad();
        fz[0].setGeschwindigkeit(20);
        fz[1] = new Auto();
        fz[1].setGeschwindigkeit(150);
        fz[2] = new Rennwagen();
        fz[2].setGeschwindigkeit(200);
        fz[3] = new Krankenwagen();
        fz[3].setGeschwindigkeit(80);
        // 4 Stunden Vorsprung für das Fahrrad
        fz[0].bewege(240);
        // Dann alle eine Stunde fahren!
        for(int i=0;i<fz.length;i++)
            fz[i].bewege(60);
        // Stand ausgeben:
        for(int i=0;i<fz.length;i++){
            fz[i].info();
        }

    }
}
