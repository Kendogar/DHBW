package aufzählungstypen;

public class Spielkarte implements Comparable<Spielkarte> {
    public String kartenfarbe;
    public String kartenwert;
    public int vergleichswert;

    public Spielkarte(String farbe, String wert){
        this.kartenfarbe = farbe;
        this.kartenwert = wert;
        vergleichswert = (Farbe.valueOf(kartenfarbe.toUpperCase()).ordinal() * 10) + (Kartenwert.valueOf(kartenwert.toUpperCase()).ordinal());
    }
    public Spielkarte(){

    }

    public String toString(){
        return String.format("Die Karte ist %s %s.", kartenfarbe, kartenwert);
    }

    @Override
    public int compareTo(Spielkarte o) {
        if ((this.vergleichswert - o.vergleichswert) >= 0){
            return 1;
        }
        else {
            return -1;
        }
    }
}
