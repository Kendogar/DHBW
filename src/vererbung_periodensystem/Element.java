package vererbung_periodensystem;

/**
 * Created by Lars on 20.02.2015.
 */
public class Element {
    private String Name, Symbol;
    private int Ordnungszahl, Aggregatszustand;
    private char Schale;
    private boolean Hauptgruppe;

    //public Element(){};

    public Element(String name, String symbol, int ordnungszahl, int aggregatszustand, char schale, boolean hauptgruppe) {
        Name = name;
        Symbol = symbol;
        Ordnungszahl = ordnungszahl;
        Aggregatszustand = aggregatszustand;
        Schale = schale;
        Hauptgruppe = hauptgruppe;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public int getOrdnungszahl() {
        return Ordnungszahl;
    }

    public void setOrdnungszahl(int ordnungszahl) {
        Ordnungszahl = ordnungszahl;
    }

    public int getAggregatszustand() {
        return Aggregatszustand;
    }

    public void setAggregatszustand(int aggregatszustand) {
        if (aggregatszustand >= 0 && aggregatszustand < 4){
            Aggregatszustand = aggregatszustand;
        }
    }

    public char getSchale() {
        return Schale;
    }

    public void setSchale(char schale) {
        Schale = schale;
    }

    public boolean isHauptgruppe() {
        return Hauptgruppe;
    }

    public void setHauptgruppe(boolean hauptgruppe) {
        Hauptgruppe = hauptgruppe;
    }

    public String toString(){
        String  zustand;
        char gruppe;
        switch (this.getAggregatszustand()){
            case 1:
                zustand = "fest";
                break;
            case 2:
                zustand = "flüssig";
                break;
            case 3:
                zustand = "gasf.";
                break;
            default:
                zustand = "";
        }
        if (this.isHauptgruppe()){
            gruppe = 'H';
        } else {
            gruppe = 'N';
        }

        return String.format("| %-6s | %-10s\t| %-2d | %-6c | %-8s| %-3s |", this.getSymbol(), this.getName(), this.getOrdnungszahl(), this.getSchale(), zustand, gruppe);
    }

    public boolean equals(Object o){
        if (o instanceof Element && this.getOrdnungszahl() == ((Element) o).getOrdnungszahl()){
            return true;
        }
        else{
            return false;
        }
    }
}
