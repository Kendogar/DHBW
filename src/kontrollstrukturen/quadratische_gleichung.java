package kontrollstrukturen;

/**
 * Created by Lars on 23.01.2015.
 */
public class quadratische_gleichung {
    public static void main (String[] args){
        java.util.Scanner scan = new java.util.Scanner(System.in);
        double x, a, b, c;


        System.out.println("A eingeben:");
        a = scan.nextDouble();
        System.out.println("B eingeben:");
        b = scan.nextDouble();
        System.out.println("C eingeben:");
        c = scan.nextDouble();

        if (a == 0){
            if (b == 0){
                System.out.println("Die Gleichung ist degeneriert.");
            }
            else {
                x = -(c / b);
                System.out.println("Lösung: X = " + x);
            }
        }
        else{
            double D = (b*b) - 4 * a * c;
            if (D >= 0){
                double x1 = (-b + Math.sqrt(D))/(2*a);
                double x2 = (-b - Math.sqrt(D))/(2*a);
                System.out.println("Lösungen sind: x1 = " + x1 + " x2 = " + x2);
            }
            else{
                System.out.println("Die Lösung ist konjugiert komplex.");
            }
        }
    }
}
