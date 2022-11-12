package view;

import controller.MovieController;
import model.classes.*;

import java.util.HashSet;

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
                7) Logout""");

        int choice = Integer.parseInt(SC.nextLine());
        switch (choice) {
            case 1 -> VIEW_STATE.setCurrState(ViewState.State.ViewMoviesView);
            case 2 -> VIEW_STATE.setCurrState(ViewState.State.BookingSystemView);
            case 3 -> VIEW_STATE.setCurrState(ViewState.State.BookingHistView);
            case 4 -> VIEW_STATE.setCurrState(ViewState.State.ListTop5Movie2);
            case 5 -> VIEW_STATE.setCurrState(ViewState.State.ListTop5Movie);
            case 6 -> VIEW_STATE.setCurrState(ViewState.State.ReviewView);
            case 7 -> {
                System.out.println("Logging out Guest...");
                VIEW_STATE.setCurrState(ViewState.State.LoginView);
                VIEW_STATE.setCurrUser(null);
            }
            default -> VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);
        }
    }
    public static void displayReviewMenu() {  //UNTESTED AS OF FRI NIGHT. 233AM i go sleep first sorry
        System.out.println("These are the movies you have watched!");
        MovieGoer movieGoer = (MovieGoer) VIEW_STATE.getCurrUser();
        HashSet<Movie> watchedMovies = new HashSet<>();
        // print movies that person have booked
        movieGoer.getBookings().forEach(bookings -> {
            bookings.getMovieTickets().forEach(ticket -> {
                System.out.println(ticket.getMovie());
                watchedMovies.add(ticket.getMovie());
            });
        });

        System.out.println("What is the name of the Movie You are reviewing?");
        String movieName = SC.nextLine();
        Movie movie = MovieController.MOVIES.get(movieName);

        if(movie != null) {
            if(watchedMovies.contains(movie)) {
                // check if customer alr made review
                for(Review r : movie.getReviews()) {
                    if(r.getCustomer().getUsername().equals(movieGoer.getUsername())) {
                        System.out.println("You have reviewed this movie!");
                        VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);
                        return;
                    }
                }
                System.out.println("Please enter the Rating out of 5");
                double rating = SC.nextDouble();
                SC.nextLine();
                System.out.println("Please enter your comments about the movie:");
                String customerReview = SC.nextLine();
                movie.updateReviews(new Review(movieGoer, customerReview, rating));
                VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);
            } else {
                System.out.println("You have not watched this movie!");
            }
        }
    }
}
