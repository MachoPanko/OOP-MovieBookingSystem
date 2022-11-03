package model.classes;



import java.io.Serializable;
import java.util.ArrayList;

public class Booking implements Serializable {
    private String bookingId;
    private MovieGoer movieGoer;
    private String date;
    private ArrayList<MovieTicket> movieTickets;
    private Seating seating;
    private Transaction transaction;
    private Double time; // hh:mm

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Booking(String bookingId, MovieGoer movieGoer, String date, ArrayList<MovieTicket> movieTicket, Seating seating, Transaction transaction, Double time) {
        this.bookingId = bookingId;
        this.movieGoer = movieGoer;
        this.date = date;
        this.movieTickets = movieTickets;
        this.seating = seating;
        this.transaction = transaction;
        this.time = time;
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

    public Seating getSeating() {
        return seating;
    }

    public void setSeating(Seating seating) {
        this.seating = seating;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString(){
        StringBuilder build = new StringBuilder();
        build.append("Booking ID: "); build.append(this.getBookingId()); build.append("\n");
        build.append("Name: "); build.append(this.getMovieGoer().getName()); build.append("\n");
        build.append("Date: "); build.append(this.getDate()); build.append("\n");
        build.append("Ticket: "); build.append(this.getMovieTickets()); build.append("\n");
        build.append("seating Number: "); build.append(this.getSeating()); build.append("\n");
        build.append("Transaction: "); build.append(this.getTransaction()); build.append("\n");
        return build.toString();
}
}

