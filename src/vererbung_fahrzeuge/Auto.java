package vererbung_fahrzeuge;

/**
 * Created by Lars on 20.02.2015.
 */
public class Auto extends Fahrzeug {

    public Auto(){
        super(0,0,140,4);
    }

    protected Auto(double maxgeschwindigkeit){
        super(0,0,maxgeschwindigkeit,4);
    }
}
