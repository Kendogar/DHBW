package jUnitTests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class KontoTest {

    private static Konto konto;
    private static final long anfangsbetrag = 4711;

    public KontoTest(){

    }

    @BeforeClass
    public static void setUpKonto() {
        System.out.println("Konto angelegt...");
        konto = new Konto(anfangsbetrag);
    }

    @Before
    public void setUp(){
        konto.setKontostand(anfangsbetrag);
    }

    @Test
    public void kontostand() throws KontoException{
        assertEquals(anfangsbetrag, konto.gibKontostand());
    }

    // Testen, ob zwei sequentielle Einzahlung als Summe gebucht werden
    @Test
    public void einzahlen() throws KontoException {
        konto.einzahlen(500);
        konto.einzahlen(200);
        assertEquals(anfangsbetrag+500+200, konto.gibKontostand()) ;
    }
    // Testen, ob eine negative Einzahlung zu einer Exception führt
    @Test (expected=KontoException.class)
    public void einzahlenNegativ() throws KontoException {
        konto.einzahlen(-200);
    }
    // Testen, ob eine Einzahlung von 0 den Kontostand nicht ändert
    @Test
    public void einzahlenNull() throws KontoException {
        long standZuvor = konto.gibKontostand();
        konto.einzahlen(0);
        assertEquals(standZuvor, konto.gibKontostand()) ;
    }

    @Test
    public void positivo(){
        konto.setKontostand(1000);
        assertEquals(true, konto.kontostandPositiv() );
    }


}