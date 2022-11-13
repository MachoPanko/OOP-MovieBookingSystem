package model.classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 */

public class Booking implements Serializable {
    private final String bookingId;
    private final MovieGoer movieGoer;
    private final String date;
    private final ArrayList<MovieTicket> movieTickets;
    private final Transaction transaction;
    private final String cineplexName;

    /**
     * Constructor for Booking class
     * @param bookingId A randomly generated string of character and numbers
     * @param movieGoer A MovieGoer object
     * @param date The date that the movieGoer is booking the ticket
     * @param movieTickets ArrayList of movieTickets
     * @param transaction A Transaction object
     * @param cineplexName The name of the cineplex that the movierGoer is going to go to
     */
    public Booking(String bookingId, MovieGoer movieGoer, String date, ArrayList<MovieTicket> movieTickets, Transaction transaction, String cineplexName) {
        this.bookingId = bookingId;
        this.movieGoer = movieGoer;
        this.date = date;
        this.movieTickets = movieTickets;
        this.transaction = transaction;
        this.cineplexName = cineplexName;
    }

    /**
     * Gets the booking id
     * @return bookingId
     */
    public String getBookingId() {
        return bookingId;
    }

    /**
     * Gets the MovieGoer object
     * @return MovieGoer
     */
    public MovieGoer getMovieGoer() {
        return movieGoer;
    }

    /**
     * Gets the date
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * Gets the array of movietickets
     * @return movieTickets
     */
    public ArrayList<MovieTicket> getMovieTickets() {
        return movieTickets;
    }

    /**
     * Gets the transaction object
     * @return transaction
     */
    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * Gets the cineplex name
     * @return cineplexName
     */
    public String getCineplexName() { return cineplexName; }

    /**
     * Overrides toString
     * @return String
     */
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

