package probeklausur;

/**
 * Created by Lars on 19.03.2015.
 */
public class ZooTier {
    private String name, art, lieblingsfutter;

    public ZooTier(String name, String art, String lieblingsfutter){
        this.name = name;
        this.art = art;
        this.lieblingsfutter = lieblingsfutter;
    }

    public ZooTier(){
    }

    public String getName() {
        return name;
    }

    public String getArt() {
        return art;
    }

    public void fuettern(String futter){
        if (this.lieblingsfutter.equalsIgnoreCase(futter)){
            System.out.printf("%s (%s) frisst %s!\n", this.name, this.art, futter);
        }
        else {
            System.out.printf("%s (%s) verschmäht %s!\n", this.name, this.art, futter);
        }
    }

    public String toString(){
        return String.format("Name: %s \tArt: %s\n", this.name, this.art);
    }
}
