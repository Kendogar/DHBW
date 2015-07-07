package vererbung_fahrzeuge_abstract;

/**
 * Created by Lars on 20.02.2015.
 */
public class Fahrrad extends Fahrzeug {

    public Fahrrad(){
        super(0,0,30,2);
    }

    public void info(){
        System.out.println(this.toString());
    }
}
