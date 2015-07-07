package vererbung_fahrzeuge;

/**
 * Created by Lars on 20.02.2015.
 */
public class Krankenwagen extends Auto{
    private int blaulicht;

    public Krankenwagen(){
        super(80);
        blaulicht = 0;
    }

    public void setBlaulicht(int blaulicht) {
        if (this.blaulicht == 1){
            this.blaulicht = 0;
        }
        else {
            this.blaulicht = 1;
        }
    }

    public String toString(){
        return String.format("%s mit %d Rädern an Position %.2f km mit v=%.2f km/h. Blaulicht: %d",this.getClass().getSimpleName(), this.getRaeder(), this.getPosition(), this.getGeschwindigkeit(), this.blaulicht);
    }
}
