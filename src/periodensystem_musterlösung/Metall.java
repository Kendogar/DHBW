package periodensystem_musterlösung;

/**
 * Created by Lars on 21.02.2015.
 */
public class Metall extends Element {
    boolean halbmetall;
    double leitfaehigkeit;

    public Metall() {
    }

    public Metall(String name, String symbol, int ordnungszahl, char schale,
                  int aggregatszustand, boolean hauptgruppe,
                  boolean halbmetall, double leitfaehigkeit) {
        super(name, symbol, ordnungszahl, schale, aggregatszustand, hauptgruppe);
        this.halbmetall = halbmetall;
        this.leitfaehigkeit = leitfaehigkeit;
    }

    @Override
    public String toString() {
        return super.toString() + ", Halbmetall: " + halbmetall +
                ", Leitfähigkeit: " + leitfaehigkeit;
    }

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
}