package view;

import controller.BookHistoryController;
import model.classes.Booking;
import model.classes.MovieGoer;

import java.awt.print.Book;
import java.io.IOException;

import static model.Main.SC;
import static model.Main.VIEW_STATE;
public class MovieGoerMenu {
    public static void display() throws IOException {
        System.out.println("""
                1) List/Search Movies
                2) Book & purchase ticket
                3) View Booking History
                4) See Top 5 ranking by ticket sales
                5) See Top 5 ranking by overall reviewers' ratings
                6) Add Review for a movie
                7) Back""");


        int choice = Integer.parseInt(SC.nextLine());
        switch (choice) {
            case 1 -> {
                VIEW_STATE.setCurrState(ViewState.State.MovieListing);
                // List out all movies
            }
//            case 2 -> BookingSystem.purchaseTicket();
//            case 3 -> {
//                System.out.println("Please enter your name");
//                String name = SC.nextLine();
//                BookingHistory.getBookingHistory(name); // Print out booking history
//            }
            //case 4 ->
            case 6 -> {
                handleReview();
                VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);
            }
            default -> VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);

        }
    }
    public static void handleReview() {
        String movieName = SC.nextLine();
        MovieGoer movieGoer = (MovieGoer) VIEW_STATE.getCurrUser();
        String username = movieGoer.getUsername();
        boolean ValidWatcher = false;
        //for (Booking b : BookHistoryController.BOOKING_HIST.get(username)){

        //}
        //if( )//user never watch before , exit , else let him change review
    }
}
