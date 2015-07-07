package jUnitTests;

/**
 * Created by Lars on 07.07.2015.
 */
public class Konto {
    long kontostand;

    public long getKontostand() {
        return kontostand;
    }

    public void setKontostand(long kontostand) {
        this.kontostand = kontostand;
    }

    public Konto(long startwert){
        this.kontostand = startwert;
    }

    public long gibKontostand(){
        return this.kontostand;
    }

    public void einzahlen(long einzahlung) throws KontoException {
        if (einzahlung >= 0){
            this.kontostand+=einzahlung;
        } else {
            throw new KontoException("Betrag ist negativ, depp");
        }


    }

    public long auszahlen(long auszahlung) throws KontoException {
        this.kontostand -= auszahlung;
        return auszahlung;
    }

    public boolean kontostandPositiv(){
        return this.kontostand >= 0;
    }
}
