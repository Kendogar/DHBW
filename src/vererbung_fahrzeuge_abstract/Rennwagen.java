package vererbung_fahrzeuge_abstract;

/**
 * Created by Lars on 20.02.2015.
 */
public class Rennwagen extends Auto {

    public Rennwagen(){
        super(220);
    }

    public void info(){
        System.out.println(this.toString());
    }
}
