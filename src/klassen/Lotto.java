package klassen;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Lars on 06.02.2015.
 */
public class Lotto {
    private int ziehungen, pool;
    private int[] tipp,  gezogen;

    public Lotto(int anzahl_der_tipps, int groesse_des_pools){
        this.ziehungen = anzahl_der_tipps;
        this.pool = groesse_des_pools;
        this.tipp = new int[anzahl_der_tipps];
        this.gezogen = new int[anzahl_der_tipps];
    }

    public Lotto(){
        this(6,49);
    }

    public void tippen(){
        boolean eingabecheck = true;
        Scanner scan = new Scanner(System.in);
        while (eingabecheck){
            System.out.printf("\nBitte tippe %d unterschiedliche Zahlen kleiner als %d:", this.ziehungen, this.pool+1);
            String input = scan.nextLine();
            String[] splittedInput = input.split(" ");
            for (int i = 0; i < this.ziehungen; i++) {
                this.tipp[i] = Integer.parseInt(splittedInput[i]);
            }
            //validation
            int counter = 0;
            for (int i = 0; i < this.tipp.length; i++){
                for (int j = 0; j < this.tipp.length; j++){
                    if (this.tipp[i]==this.tipp[j]){
                        counter++;
                    }
                }
            }
            if (counter == this.ziehungen){
                eingabecheck = false;
            }
        }
    }

    public void tippen(int[] mytipp){
        this.tipp = mytipp;
        int counter = 0;
        for (int i = 0; i < this.tipp.length; i++){
            for (int j = 0; j < this.tipp.length; j++){
                if (this.tipp[i]==this.tipp[j]){
                    counter++;
                }
            }
        }
        if (counter != this.ziehungen){
            System.out.println("Ungültiges Array.");
            System.exit(1);
        }
    }

    public void ziehen(){
        boolean weiterziehen = true;
        Random rand = new Random();
        while (weiterziehen){
            for (int i = 0; i < this.gezogen.length; i++){
                this.gezogen[i] = rand.nextInt(this.pool + 1);
            }

            int counter = 0;
            for (int i = 0; i < this.gezogen.length; i++){
                for (int j = 0; j < this.gezogen.length; j++){
                    if (this.gezogen[i]==this.gezogen[j]){
                        counter++;
                    }
                }
            }
            if (counter == this.ziehungen){
                weiterziehen = false;
            }
        }

        System.out.println(Arrays.toString(this.gezogen));
    }

    public int richtige(){
        int counter = 0;
        for (int i = 0; i < this.tipp.length; i++){
            for (int j = 0; j < this.gezogen.length; j++){
                if (this.tipp[i] == this.gezogen[j]){
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Lotto deutsch = new Lotto();
        deutsch.tippen();
        deutsch.ziehen();
        System.out.println("richtige: "+deutsch.richtige());

        /*Lotto test = new Lotto(5, 10);
        test.tippen();
        test.ziehen();
        System.out.println("Richtige Zahlen: " +test.richtige());*/
    }


}
