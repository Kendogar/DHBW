package uebungsprobeklausur;

import java.util.Calendar;

/**
 * Created by Lars Krakhecke on 01.10.2015.
 */
public class Flug {
    private String name;
    private Airline airline;
    private Destination from, to;
    private Calendar departure, landing;
    private int rows, seats;
    private Sitz[][] allSeats;

    public Flug(String name, Airline airline, Destination from, Destination to, int rows, int seats) {
        this.name = name;
        this.airline = airline;
        this.from = from;
        this.to = to;
        this.rows = rows;
        this.seats = seats;
        this.allSeats = new Sitz[this.getRows()][this.getSeats()];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                allSeats[i][j] = new Sitz(i+1,(char)('A'+j));
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Destination getFrom() {
        return from;
    }

    public void setFrom(Destination from) {
        this.from = from;
    }

    public Destination getTo() {
        return to;
    }

    public void setTo(Destination to) {
        this.to = to;
    }

    public Calendar getDeparture() {
        return departure;
    }

    public void setDeparture(Calendar departure) {
        this.departure = departure;
    }

    public Calendar getLanding() {
        return landing;
    }

    public void setLanding(Calendar landing) {
        this.landing = landing;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Sitz[][] getAllSeats() {
        return allSeats;
    }

    public void setAllSeats(Sitz[][] allSeats) {
        this.allSeats = allSeats;
    }

    public int freiePlaetze() {
        int seatcounter = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                if (allSeats[i][j].getStatus() == Buchungsstatus.FREI) {
                    seatcounter++;
                }
            }
        }
        return seatcounter;
    }
}

