package klassen;

/**
 * Created by Lars on 30.01.2015.
 * Simuliert die Funktionen eines analogen Radios.
 */
public class Radio {
    boolean eingeschaltet;
    private int lautstaerke;
    private double frequenz;

    /**
     * Erstellt ein Radio mit Voreinstellungen.
     * @param einaus Zustand des Radios
     * @param laut Lautstärke des Radios
     * @param freq Eingestellte Frequenz
     */
    public Radio(boolean einaus, int laut, double freq) {
        eingeschaltet = einaus;
        setLautstaerke(laut);
        waehleSender(freq);
    }

    /**
     * Stellt die Lautstärke ein
     * @param lautstaerke Lautstärke, minimal 0, maximal 10
     */
    public void setLautstaerke(int lautstaerke) {
        if (lautstaerke >= 0 && lautstaerke <= 10){
            this.lautstaerke = lautstaerke;
        }
        else {
            this.lautstaerke = 5;
        }

    }

    /**
     * Erstellt ein Standard Radio
     */
    public Radio(){
        this(false, 5, 85.0);
    }

    /**
     * Erhöht die Lautstärke falls möglich um 1
     */
    public void lauter(){
        if (lautstaerke < 10 && eingeschaltet) {
            this.lautstaerke++;
        }
    }

    /**
     * Senkt die Lautstärke falls möglich um 1
     */
    public void leiser(){
        if (lautstaerke > 0 && eingeschaltet){
            this.lautstaerke--;
        }
    }

    /**
     * Schaltet das Radio ein
     */
    public void an(){
        this.eingeschaltet = true;
    }

    /**
     * Schaltet das Radio aus
     */
    public void aus(){
        this.eingeschaltet = false;
    }

    /**
     * Verändert die Frequenz des Radios
     * @param frequenz Einzustellende Frequenz
     */
    public void waehleSender( double frequenz ){
        if ( frequenz < 85.0 || frequenz > 110.0){
            this.frequenz = 99.9;
        }
        else {
            this.frequenz = frequenz;
        }
    }

    /**
     * Gibt alle Informationen zum aktuellen Radio aus
     * @return String mit Informationen
     */
    public String toString() {
        String ergebnis;
        if (eingeschaltet) {
            ergebnis = "Radio an: Frequenz = " + frequenz + " Lautstärke = " + lautstaerke;
            return ergebnis;
        }
        else {
            ergebnis = "Radio ausgeschaltet.";
            return  ergebnis;
        }

    }
    public static void main(String[] args) {
        Radio boombox = new Radio(true, 7, 87.5);

        System.out.println(boombox.toString());
        boombox.lauter();
        boombox.waehleSender(89.75);
        System.out.println(boombox.toString());
    }

}

