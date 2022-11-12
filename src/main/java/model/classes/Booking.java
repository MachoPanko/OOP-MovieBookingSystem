package model.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Booking implements Serializable {
    private String bookingId;
    private MovieGoer movieGoer;
    private String date;
    private ArrayList<MovieTicket> movieTickets;
    private Transaction transaction;

    public Booking(String bookingId, MovieGoer movieGoer, String date, ArrayList<MovieTicket> movieTickets, Transaction transaction) {
        this.bookingId = bookingId;
        this.movieGoer = movieGoer;
        this.date = date;
        this.movieTickets = movieTickets;
        this.transaction = transaction;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public MovieGoer getMovieGoer() {
        return movieGoer;
    }

    public void setMovieGoer(MovieGoer movieGoer) {
        this.movieGoer = movieGoer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<MovieTicket> getMovieTickets() {
        return movieTickets;
    }

    public void setMovieTickets(ArrayList<MovieTicket> movieTickets) {
        this.movieTickets = movieTickets;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "Booking ID: " + this.getBookingId() + "\n" +
                "Name: " + this.getMovieGoer().getUsername() + "\n" +
                "Date: " + this.getDate() + "\n" +
                "Ticket: " + this.getMovieTickets().toString() + "\n" +
                "Transaction: " + this.getTransaction().toString() + "\n";
    }
}

