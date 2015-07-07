package arrays_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Lars on 29.01.2015.
 */
public class A6_BubbleSort {
    public static void main(String[] args) {
        int komponenten;
        double temp;
        int count = 1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Wieviele Zahlen?");
        komponenten = scan.nextInt();
        double zahlenreihe [] = new double[komponenten];

        for (int i = 0; i < zahlenreihe.length; i++) {
            System.out.println("Zahl " + (i + 1) + " eingeben:");
            zahlenreihe[i] = scan.nextDouble();
        }
        System.out.println(Arrays.toString(zahlenreihe));
        while (count != 0){
            count = 0;
            for (int i = 0; i < zahlenreihe.length-1; i++){
                if (zahlenreihe[i+1] < zahlenreihe[i]){
                    temp = zahlenreihe[i];
                    zahlenreihe[i] = zahlenreihe[i+1];
                    zahlenreihe[i+1] = temp;
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(zahlenreihe));
    }
}
