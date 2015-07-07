package methoden;

import java.util.Scanner;

/**
 * Created by Lars on 08.02.2015.
 */
public class potenzieren {

    public static double xhochn(double basis, int exponent){
        if (exponent == 0){
            return 1;
        }
        else {
            return basis * xhochn(basis, exponent-1);
        }
    }

    public static void main(String[] args) {
        double basis;
        int exponent;
        Scanner scan = new Scanner(System.in);
        System.out.println("Basis:");
        basis = scan.nextDouble();
        System.out.println("Exponent:");
        exponent = scan.nextInt();
        System.out.println("Ergebnis: " + xhochn(basis, exponent));


    }
}

