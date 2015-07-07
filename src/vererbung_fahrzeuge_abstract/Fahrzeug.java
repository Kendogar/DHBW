package vererbung_fahrzeuge_abstract;

/**
 * Created by Lars on 20.02.2015.
 */
public abstract class Fahrzeug {
    private double position, geschwindigkeit, maximalGeschwindigkeit;
    private int raeder;

    protected Fahrzeug(double position, double geschwindigkeit, double maximalGeschwindigkeit, int raeder){
        this.position = position;
        this.geschwindigkeit = geschwindigkeit;
        this.maximalGeschwindigkeit = maximalGeschwindigkeit;
        this.raeder = raeder;
    }

    public void setPosition(double position) {
        this.position += position;
    }

    public void setGeschwindigkeit(double geschwindigkeit) {
        if (geschwindigkeit <= maximalGeschwindigkeit) {
            this.geschwindigkeit = geschwindigkeit;
        }
        else {
            this.geschwindigkeit = this.maximalGeschwindigkeit;
        }
    }

    public void setMaximalGeschwindigkeit(double maximalGeschwindigkeit) {
        this.maximalGeschwindigkeit = maximalGeschwindigkeit;
    }

    public void setRaeder(int raeder) {
        this.raeder = raeder;
    }

    public double getPosition() {
        return position;
    }

    public double getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public double getMaximalGeschwindigkeit() {
        return maximalGeschwindigkeit;
    }

    public int getRaeder() {
        return raeder;
    }

    public void bewege(double minuten){
        this.setPosition(minuten * (this.geschwindigkeit / 60));
    }

    public double maxGeschwindigkeit(){
        return this.maximalGeschwindigkeit;
    }

    public int raeder(){
        return this.raeder;
    }

    public abstract void info();

    public String toString(){
        return String.format("%s mit %d Rädern an Position %.2f km mit v=%.2f km/h",this.getClass().getSimpleName(), this.getRaeder(), this.getPosition(), this.getGeschwindigkeit());
    }
}
