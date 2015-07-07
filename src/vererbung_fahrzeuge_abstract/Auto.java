package vererbung_fahrzeuge_abstract;

/**
 * Created by Lars on 20.02.2015.
 */
public class Auto extends Fahrzeug {

    public Auto(){
        super(0,0,140,4);
    }

    public void info(){
        System.out.println(this.toString());
    }

    protected Auto(double maxgeschwindigkeit){
        super(0,0,maxgeschwindigkeit,4);
    }
}


