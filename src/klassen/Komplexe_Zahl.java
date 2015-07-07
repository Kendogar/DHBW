package klassen;

import java.util.Arrays;

/**
 * Created by Lars on 05.02.2015.
 */
public class Komplexe_Zahl {
   private double realteil, imaginaerteil;

    public double getRealteil() {
        return realteil;
    }

    public void setRealteil(double realteil) {
        this.realteil = realteil;
    }

    public double getImaginaerteil() {
        return imaginaerteil;
    }

    public void setImaginaerteil(double imaginaerteil) {
        this.imaginaerteil = imaginaerteil;
    }

    public Komplexe_Zahl(double realteil, double imaginaerteil) {
        this.realteil = realteil;
        this.imaginaerteil = imaginaerteil;
    }

    public Komplexe_Zahl add(Komplexe_Zahl zahl){
        Komplexe_Zahl result = new Komplexe_Zahl(this.realteil + zahl.getRealteil(), this.imaginaerteil + zahl.getImaginaerteil());
        return result;
    }

    public Komplexe_Zahl sub(Komplexe_Zahl zahl){
        Komplexe_Zahl result = new Komplexe_Zahl(this.realteil - zahl.getRealteil(), this.imaginaerteil - zahl.getImaginaerteil());
        return result;
    }

    public Komplexe_Zahl mult(Komplexe_Zahl zahl){
        Komplexe_Zahl result = new Komplexe_Zahl((this.realteil*zahl.getRealteil()-this.imaginaerteil*zahl.getImaginaerteil()), (this.realteil*zahl.getImaginaerteil()+this.imaginaerteil*zahl.getRealteil()));
        return result;
    }

    public Komplexe_Zahl div(Komplexe_Zahl zahl){
        Komplexe_Zahl result = new Komplexe_Zahl((this.realteil*zahl.getRealteil()+this.imaginaerteil*zahl.getImaginaerteil())/(Math.pow(zahl.getRealteil(),2.0)+Math.pow(zahl.getImaginaerteil(), 2.0)),(this.imaginaerteil*zahl.getRealteil()-this.realteil*zahl.getImaginaerteil())/(Math.pow(zahl.getRealteil(),2.0)+Math.pow(zahl.getImaginaerteil(), 2.0)));
        return result;
    }

    public double getBetrag(){
        return Math.abs(Math.sqrt(Math.pow(this.realteil,2)+Math.pow(this.imaginaerteil, 2)));
    }

    public boolean kleiner(Komplexe_Zahl zahl){
        return this.getBetrag() < zahl.getBetrag();
    }

    @Override
    public String toString() {
        return "Komplexe_Zahl{" +
                "realteil=" + realteil +
                ", \timaginaerteil=" + imaginaerteil +
                ",  \tDarstellung: "  + realteil + " + " + imaginaerteil + "i }";
    }

    public static void main(String[] args) {
        Komplexe_Zahl c1 = new Komplexe_Zahl(2.0, 7.0);
        Komplexe_Zahl c2 = new Komplexe_Zahl(1.0, 1.0);

        System.out.println(c1.toString());
        System.out.println(c2.toString());

        System.out.println(c1.add(c2));
        System.out.println(c1.sub(c2));
        System.out.println(c1.mult(c2));
        System.out.println(c1.div(c2));
        System.out.println(c1.getBetrag());
        System.out.println(c1.kleiner(c2));

        Komplexe_Zahl zahl_array [] = new Komplexe_Zahl[10];
        for (int i = 0; i < 10; i++){
            zahl_array[i] = new Komplexe_Zahl(Math.round(Math.random()*10),Math.round(Math.random()*10));
        }

        int count = 1;
        while (count != 0){
            count = 0;
            for (int i = 0; i < zahl_array.length-1; i++){
                if (zahl_array[i+1].getBetrag() < zahl_array[i].getBetrag()){
                    Komplexe_Zahl temp = zahl_array[i];
                    zahl_array[i] = zahl_array[i+1];
                    zahl_array[i+1] = temp;
                    count++;
                }
            }
        }
        // System.out.println(Arrays.toString(zahl_array));

        for (int i = 0; i < zahl_array.length; i++){
            System.out.println( zahl_array[i].toString() +" - " + zahl_array[i].getBetrag());
        }

    }
}
