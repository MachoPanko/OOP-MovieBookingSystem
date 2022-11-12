package view;

import controller.MovieController;
import controller.UserController;
import model.classes.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static model.Main.SC;
import static model.Main.VIEW_STATE;
public class MovieGoerMenu {
    public static void display() {
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
                VIEW_STATE.setCurrState(ViewState.State.ViewMoviesView);
                // List out all movies
            }
            case 2 -> {
                VIEW_STATE.setCurrState(ViewState.State.BookingSystemView);
            }
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
            case 7 -> {
                System.out.println("Logging out Guest...");
                VIEW_STATE.setCurrState(ViewState.State.LoginView);
                VIEW_STATE.setCurrUser(null);
            }
            default -> VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);

        }
    }
    public static void handleReview() {  //UNTESTED AS OF FRI NIGHT. 233AM i go sleep first sorry
        System.out.println("What is the name of the Movie You are reviewing?");
        String movieName = SC.nextLine();
        Movie movie = MovieController.MOVIES.get(movieName);
        MovieGoer movieGoer = (MovieGoer) VIEW_STATE.getCurrUser();
        String username = movieGoer.getUsername();
        boolean ValidWatcher = false;
        ArrayList<Booking> bookingArrayList = UserController.USER_DATABASE.get(username).getBookings();
        for (Booking b : bookingArrayList){
            for(MovieTicket m : b.getMovieTickets())
                if(Objects.equals(m.getMovie().getMovieTitle(), movieName)){
                    ValidWatcher = true;
                    break;
                }
        }
        if (ValidWatcher){
            System.out.println("Please enter the Rating out of 5");
            double rating = SC.nextDouble();
            System.out.println("Please enter your comments about the movie:");
            String customerReview = SC.nextLine();
            Review review = new Review((MovieGoer) VIEW_STATE.getCurrUser(),customerReview,rating );
            movie.updateReviews(review,rating);
        }
        else{
            System.out.println("You havent watched this movie before! Try Another option.");
        }
        return;


        //if( )//user never watch before , exit , else let him change review
    }
}
