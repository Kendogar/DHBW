package klassen;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Lars on 30.01.2015.
 */
public class Punkt {
    private double x_cord;
    private double y_cord;

    public Punkt(double x, double y){
        setX_cord(x);
        setY_cord(y);
    }

    public Punkt(){
        this(0, 0);
    }


    public double getX_cord() {
        return x_cord;
    }

    public void setX_cord(double x_cord) {
        this.x_cord = x_cord;
    }

    public double getY_cord() {
        return y_cord;
    }

    public void setY_cord(double y_cord) {
        this.y_cord = y_cord;
    }

    public double abstandUrsprung(){

        return Math.sqrt(Math.pow((x_cord - 0), 2) + Math.pow((y_cord - 0), 2));
    }

    public Punkt spiegelung_x(){
        double new_y = y_cord * (-1);
        Punkt gespiegeltX = new Punkt(x_cord, new_y);

        return gespiegeltX;
    }

    public Punkt spiegelung_y(){
        double new_x = x_cord * (-1);
        Punkt gespiegeltY = new Punkt(new_x, y_cord);

        return gespiegeltY;
    }

    public Punkt spiegelung_ursprung(){
        double new_x = x_cord * (-1);
        double new_y = y_cord * (-1);
        Punkt gespiegeltUrsprung = new Punkt(new_x, new_y);

        return gespiegeltUrsprung;
    }

    public double punktabstand(Punkt p){

        return Math.sqrt(Math.pow((x_cord - p.x_cord), 2) + Math.pow((y_cord - p.y_cord), 2));
    }

    public String toString(){
        String ergebnis = "Punkt hat koordinaten X = " + this.x_cord + " und Y = " + this.y_cord;

        return ergebnis;
    }

    public static void main(String[] args) {
        Punkt p1 = new Punkt(10,10);
        Punkt p2 = new Punkt(2, -7);
        System.out.println("ToString Method:");
        System.out.println(p1.toString());
        System.out.println("Abstand von P1 zum Ursprung:");
        System.out.println(p1.abstandUrsprung());
        System.out.println("Punktspiegelung an X-Achse:");
        System.out.println(p1.spiegelung_x().toString());
        System.out.println("Punktspiegelung an Y-Achse:");
        System.out.println(p1.spiegelung_y().toString());
        System.out.println("Punktspiegelung am Ursprung:");
        System.out.println(p1.spiegelung_ursprung().toString());
        System.out.println("Abstand P1 zu P2:");
        System.out.println(p1.punktabstand(p2));
    }
}
