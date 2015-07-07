package kontrollstrukturen_aufgaben;

/**
 * Created by Lars on 23.01.2015.
 */
public class Aufgabe_2 {
    public static void main(String[] args) {
        System.out.printf("Zentimeter\t\t\t\t| Schuhgröße\n");
        System.out.println("----------------------------------");
        for (int i = 30; i<= 50; i++) {
            System.out.printf("%.6f - %.6f\t| %d%n", (i-1)/1.5, i/1.5, i);
        }
    }
}
