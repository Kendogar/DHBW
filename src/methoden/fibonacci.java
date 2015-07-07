package methoden;

import java.util.Scanner;

/**
 * Created by Lars on 08.02.2015.
 */
public class fibonacci {

    public static int fibs(int zahl){
        if (zahl <= 2){
            return 1;
        }
        else {
            return (fibs(zahl -1)+fibs(zahl -2));
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Positive Zahl eingeben:");
            n = scan.nextInt();
        } while (n < 0);

        for (int i = 1; i <= n; i++){
            System.out.printf("F(%d) = \t%d\n", i, fibs(i));
        }
    }
}
