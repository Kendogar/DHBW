package aufzählungstypen;

public enum Kartenwert {SIEBEN("7"), ACHT("8"), NEUN("9"), BUBE("Bube"), DAME("Dame"), KÖNIG("König"), ZEHN("10"), ASS("Ass");
    public String wert;
    private Kartenwert(String wert) {
        this.wert = wert;
    }
}
