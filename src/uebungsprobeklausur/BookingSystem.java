package uebungsprobeklausur;

/**
 * Created by Lars Krakhecke on 01.10.2015.
 */
public class BookingSystem {

    public static void main(String[] args) {
            Destination frankfurt = new Destination("Flughafen Berlin Brandenburg", "Frankfurt am Main", "FRA");
            Destination newyork = new Destination("Int. Flughafen 'John F. Kennedy'","New York City", "JFK");
            Airline lufthansa = new Airline("DLH","Deutsche Lufthansa");
// Lufthansa-Flug LH4711 mit 15 Sitzreihen zu jeweils 4 Sitzen (A..D)
            Flug f = new Flug("LH4711", lufthansa, frankfurt, newyork, 15, 4);
            BookingForm bf = new BookingForm(f);
    }
}
