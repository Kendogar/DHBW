package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Lars on 13.03.2015.
 */
public class TeilEinerDatei {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("TeilEinerDatei.txt"));
            ArrayList<Integer> numbrs = new ArrayList<Integer>();
            while(br.ready()){
                int temp = Integer.parseInt(br.readLine());
                numbrs.add(temp);
            }
            br.close();
            int sum = 0;
            for (int i = 0; i<numbrs.size();i++) {
                if (i >= 2 && i <= 5) {
                    System.out.println(numbrs.get(i));
                    sum += numbrs.get(i);
                }
            }
            System.out.println("\n Summe: "+sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
