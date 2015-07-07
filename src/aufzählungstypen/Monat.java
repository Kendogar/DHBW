package aufzählungstypen;

import java.util.Calendar;

/**
 * Created by Lars on 09.06.2015.
 */
public enum Monat {
    Januar (31, "Hartung, Eismond"),
    Februar (28, "Hornung, Schmelzmond, Taumond, Narrenmond, Rebmond, Hintester"),
    März (31, "Lenzing, Lenzmond"),
    April (30, "Launing, Ostermond"),
    Mai (31, "Wintermond, Blumenmond"),
    Juni (30, "Brachet, Brachmond"),
    Juli (31, "Heuert, Heumond"),
    August (31, "Ernting, Erntemond, Bisemond"),
    September (30, "Scheiding, Herbstmond"),
    Oktober (31, "Gilbhart, Gilbhard, Weinmond"),
    November (30, "Nebelung, Windmond, Wintermond"),
    Dezember (31, "Julmond, Heilmond, Christmond, Dustermond");

    public int tageDesMonats;
    public String alteNamenDesMonats;

    Monat(int tage, String alteNamen){
        tageDesMonats = tage;
        alteNamenDesMonats = alteNamen;
    }
    public String toString(){
        return String.format("Der %s hat %d Tage und hieß früher '%s'",this.name(), this.tageDesMonats, this.alteNamenDesMonats );
    }

    public static void main(String[] args) {
        Monat[] alleMonate = Monat.values();
        System.out.println(alleMonate[Calendar.getInstance().get(Calendar.MONTH)].toString());
    }
}
