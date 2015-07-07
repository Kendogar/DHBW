package strings;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Lars on 07.02.2015.
 */
public class Quersumme {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Zahl eingeben:");
        String temp = scan.nextLine();
        int sum = 0;
        for (int i = 0; i < temp.length(); i++){
            sum += Integer.parseInt(String.valueOf(temp.charAt(i)));
        }
        System.out.println("Summe: " + sum);



        try {
            File test = new File("Quersummen.txt");
            test.createNewFile();

            FileWriter fw = new FileWriter(test, true);
            BufferedWriter bw = new BufferedWriter(fw);
            String sep = System.lineSeparator();
            bw.write("Zahl = "+temp+" Quersumme = "+sum+sep);
            bw.flush();
            System.out.println("done");
        } catch (IOException e1){
            System.out.println("exception");
            e1.getMessage();
        }


    }
}
