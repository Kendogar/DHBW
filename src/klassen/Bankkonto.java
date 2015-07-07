package klassen;

/**
 * Created by Lars on 31.01.2015.
 */
public class Bankkonto {
    String name, vorname;
    private double kontostand, dispolimit;

    public Bankkonto(String name, String vorname, double kontostand, double dispolimit){
        this.name = name;
        this.vorname = vorname;
        this.kontostand = kontostand;
        this.dispolimit = dispolimit;
    }

    public Bankkonto(){
        this("Anon", "Anonymous", 1337.00,666);
    }

    public void einzahlung(double betrag){
        if (betrag > 0){
            this.kontostand += betrag;
        }
    }

    public void auszahlung(double betrag){
        if ((this.kontostand - betrag) > (this.dispolimit * -1)){
            this.kontostand -= betrag;
        }
    }

    public String kontostand(){
        String kontostand = String.format("Aktuelles Guthaben beträgt %.2f €.", this.kontostand);
        return kontostand;
    }

    public String kontoinfo(){
        String kontoinfo = String.format("Kontoinhaber: %s %s \nKontostand: %.2f €\nDispolimit: %.2f €",this.vorname, this.name, this.kontostand, this.dispolimit);
        return kontoinfo;
    }

    public static void main(String[] args) {
        Bankkonto meinKonto = new Bankkonto("Krakhecke", "Lars", 25000, 3000);
        meinKonto.einzahlung(3000);
        meinKonto.auszahlung(2000);
        System.out.println(meinKonto.kontostand());
        System.out.println(meinKonto.kontoinfo());
    }

}
