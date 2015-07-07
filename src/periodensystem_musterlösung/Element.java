package periodensystem_musterlösung;

/**
 * Created by Lars on 21.02.2015.
 */
public class Element {
    public static final int FEST = 1;
    public static final int FLUESSIG = 2;
    public static final int GASFOERMIG = 3;
    private String name;
    private String symbol;
    private int ordnungszahl;
    private char schale;
    private int aggregatszustand;
    private boolean hauptgruppe;
    public Element() {
    }
    public Element(String name, String symbol, int ordnungszahl, char schale,
                   int aggregatszustand, boolean hauptgruppe) {
        this.name = name;
        this.symbol = symbol;
        this.ordnungszahl = ordnungszahl;
        this.schale = schale;
        this.aggregatszustand = aggregatszustand;
        this.hauptgruppe = hauptgruppe;
    }
    @Override
    public String toString() {
        return "Element "+name+" ("+symbol+
                "), Oz:"+ordnungszahl+
                ", Schale "+schale+
                ", Aggregatszustand "+aggregatszustand2String(aggregatszustand)+
                ", Hauptgruppe: "+hauptgruppe;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public int getOrdnungszahl() {
        return ordnungszahl;
    } public void setOrdnungszahl(int ordnungszahl) {
        this.ordnungszahl = ordnungszahl;
    }
    public char getSchale() {
        return schale;
    }
    public void setSchale(char schale) {
        this.schale = schale;
    }
    public int getAggregatszustand() {
        return aggregatszustand;
    }
    public void setAggregatszustand(int aggregatszustand) {
        this.aggregatszustand = aggregatszustand;
    }
    public boolean isHauptgruppe() {
        return hauptgruppe;
    }
    public void setHauptgruppe(boolean hauptgruppe) {
        this.hauptgruppe = hauptgruppe;
    }
    public static String aggregatszustand2String(int agZustand) {
        switch(agZustand) {
            case Element.FEST : return "fest";
            case Element.FLUESSIG : return "flüssig";
            case Element.GASFOERMIG : return "gasförmig";
            default: return "";
        }
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Element) {
            Element el = (Element) o;
            return this.ordnungszahl == el.getOrdnungszahl();
        } else {
            return false;
        }
    }
}
