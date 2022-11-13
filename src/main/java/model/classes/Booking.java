package model.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Booking implements Serializable {
    private final String bookingId;
    private final MovieGoer movieGoer;
    private final String date;
    private final ArrayList<MovieTicket> movieTickets;
    private final Transaction transaction;
    private final String cineplexName;

    public Booking(String bookingId, MovieGoer movieGoer, String date, ArrayList<MovieTicket> movieTickets, Transaction transaction, String cineplexName) {
        this.bookingId = bookingId;
        this.movieGoer = movieGoer;
        this.date = date;
        this.movieTickets = movieTickets;
        this.transaction = transaction;
        this.cineplexName = cineplexName;
    }

    public String getBookingId() {
        return bookingId;
    }

    public MovieGoer getMovieGoer() {
        return movieGoer;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<MovieTicket> getMovieTickets() {
        return movieTickets;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public String getCineplexName() { return cineplexName; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[\n");

        for(MovieTicket movieTicket : this.getMovieTickets()) {
            sb.append("\t");
            sb.append(movieTicket);
            sb.append("\n");
        }

        sb.append("]");

        return "Booking ID: " + this.getBookingId() + "\n" +
                "Name: " + this.getMovieGoer().getUsername() + "\n" +
                "Cineplex: " + this.cineplexName + "\n" +
                "Date: " + this.getDate() + "\n" +
                "Tickets: " + sb + "\n" +
                "Transaction: " + this.getTransaction().toString() + "\n";
    }
}

