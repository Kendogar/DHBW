package aufzählungstypen;

/**
 * Created by Lars on 09.06.2015.
 */
public enum Farbe {KARO("Karo"),HERZ("Herz"), PIK("Pik"), KREUZ("Kreuz");
    public String name;
    private Farbe(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
