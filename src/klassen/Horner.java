package klassen;

import java.util.Scanner;

/**
 * Created by Lars on 05.02.2015.
 */
public class Horner {
    int grad;
    double polynom[];

    public Horner(double[] array){
        polynom = array;
    }

    public double funktionswert(double x){
        double wert = 0;
        int i = polynom.length-1;
        wert += (polynom[i]);
        for (int j = polynom.length-2; j >= 0; j--){
            wert = (wert * x) + polynom[j];
        }
        return wert;
    }

    public static void main(String[] args) {
        /*Scanner scan = new Scanner(System.in);
        System.out.println("Grad des Polynoms eingeben:");
        int grad = scan.nextInt();*/

        // fallende polynomvariablen
        double polynom[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        Horner horn = new Horner(polynom);
        System.out.println(horn.funktionswert(5));

    }
}

