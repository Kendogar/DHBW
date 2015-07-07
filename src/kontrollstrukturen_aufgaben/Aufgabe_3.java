package kontrollstrukturen_aufgaben;

/**
 * Created by Lars on 23.01.2015.
 */
public class Aufgabe_3 {
    public static void main(String[] args) {
        double x_0,a,x_n, x_n_inc, result;

        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.println();
        System.out.println("Zahl eingeben: ");
        a = scan.nextDouble();
        x_0 = 1;
        x_n = x_0;
        x_n_inc = (x_n + (a / x_n))/2;

        while(Math.abs(x_n_inc-x_n) >= Math.pow(10, -6)){
            x_n = x_n_inc;
            x_n_inc = (x_n + (a / x_n))/2;
        }
        System.out.println("Ergebnis: " + x_n_inc);
    }
}
