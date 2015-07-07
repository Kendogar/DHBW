package vererbung_periodensystem;

/**
 * Created by Lars on 20.02.2015.
 */
public class Metall extends Element {
    private boolean halbmetall;
    private double leitfaehigkeit;

    public boolean isHalbmetall() {
        return halbmetall;
    }

    public void setHalbmetall(boolean halbmetall) {
        this.halbmetall = halbmetall;
    }

    public double getLeitfaehigkeit() {
        return leitfaehigkeit;
    }

    public void setLeitfaehigkeit(double leitfaehigkeit) {
        this.leitfaehigkeit = leitfaehigkeit;
    }

    public Metall(String name, String symbol, int ordnungszahl, int aggregatszustand, char schale, boolean hauptgruppe, boolean halbmetall, double leitfaehigkeit){
        super(name,symbol,ordnungszahl,aggregatszustand,schale,hauptgruppe);
        this.halbmetall = halbmetall;
        this.leitfaehigkeit = leitfaehigkeit;
    }

    public String toString() {
        return super.toString() + String.format(" %-6b | %2.3e S/m", this.isHalbmetall(), this.getLeitfaehigkeit());
    }
}
