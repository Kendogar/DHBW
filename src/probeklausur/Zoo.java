package probeklausur;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Lars on 19.03.2015.
 */
public class Zoo {
    private int gehege;
    private int aktuelleTiere;
    private ZooTier[] maxTiere;


    public Zoo(){
        this.gehege = 5;
        this.maxTiere = new ZooTier[5];
    }

    public Zoo(int kapazität){
        this.gehege = kapazität;
        this.maxTiere = new ZooTier[kapazität];
    }

    public void addAnimal(ZooTier tier) throws ZooCapacityException{
        if (this.aktuelleTiere < this.gehege){
            maxTiere[this.aktuelleTiere] = tier;
            this.aktuelleTiere += 1;
            System.out.printf("%s (%s) wurde dem Zoo hinzugefügt!\n", tier.getName(), tier.getArt());
        }
        else {
                throw new ZooCapacityException("Fehler: Der Zoo ist voll. Versuch's nebenan.\n");
        }
    }

    public ZooTier[] getAnimals(){
        int counter = 0;
        for (int i = 0; i < maxTiere.length; i++){
            if (maxTiere[i] != null){
                counter++;
            }
        }
        ZooTier[] tiere = new ZooTier[counter];
        for (int j = 0; j < counter; j++){
            tiere[j] = maxTiere[j];
        }
        return tiere;
    }

    public boolean existsAnimal(String name){
        System.out.printf("Gibt es '%s' im Zoo?", name);
        for (int i = 0; i < maxTiere.length; i++){
            if (maxTiere[i].getName().equalsIgnoreCase(name)){
                System.out.println(" Ja!");
                return true;
            }
        }
        System.out.println(" Nein!");
        return false;
    }

    public void fuettern(String futter){
        for (int i = 0; i < maxTiere.length; i++){
            if (maxTiere[i] != null){
                maxTiere[i].fuettern(futter);
            }
        }
    }

    public void saveToFile(String filename) throws  ZooFileException{
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename)));
            String sep = System.lineSeparator();
            for (int i = 0; i < maxTiere.length; i++){
                if (maxTiere[i] != null){
                    bw.write(maxTiere[i].getArt()+";"+maxTiere[i].getName()+";"+maxTiere[i].getClass().getSimpleName()+sep);
                }
            }
            bw.flush();
            bw.close();
            System.out.println("Tiere in Datei gespeichert!");
        }
        catch (IOException e1){
            throw new ZooFileException("Something went wrong");
        }
    }

    public static void main(String[] args) {
        Zoo z = new Zoo(2);
        try {
            z.addAnimal(new Raubtier("Tiger","Fred"));
            z.addAnimal(new Raubtier("Tiger","Lisa"));
            z.addAnimal(new Raubtier("Löwe","Simba"));
            z.addAnimal(new Singvogel("Kleiber","Hansi"));
            z.addAnimal(new Singvogel("Schneeammer","Sina"));
            z.addAnimal(new Singvogel("Zaunkoenig","Henry"));
        }
        catch (ZooCapacityException e1){
            System.out.println(e1.getMessage());
        }

        try {
            z.saveToFile("zootiere.txt");
        }
        catch (ZooFileException e2){
            System.out.println(e2.getMessage());
        }


        z.fuettern("Körner");

        System.out.println("\n");
        z.existsAnimal("Fred");
        z.existsAnimal("Kimba");
        z.existsAnimal("Henry");
        z.existsAnimal("Lotte");

    }
}
