package view;


import controller.MovieController;
import model.classes.Movie;
import model.classes.Staff;
import model.classes.User;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static model.Main.VIEW_STATE;

/**
 * View for the list of top 5 movies
 */
public class ListTop5Movie {
    /**
     * To display the top 5 movies according to its rating
     */
    public static void displayByRating(){
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("-----------------------------------");
        System.out.println("Top 5 movies according to rating");
        System.out.println("-----------------------------------");

        ArrayList<Movie> sortedMovies = new ArrayList<>();
        MovieController.MOVIES.forEach((k,movie) -> sortedMovies.add(movie));
        sortedMovies.sort((a,b) ->  Double.compare(b.getMovieRating(), a.getMovieRating()));

        for(int i = 0; i < Math.min(sortedMovies.size(), 5); ++i) {
            Movie m = sortedMovies.get(i);

            System.out.println("Title: " + m.getMovieTitle() + ", " + df.format(m.getMovieRating()) );

        }
        System.out.println();

        boolean isStaff = VIEW_STATE.getCurrUser() instanceof Staff;

        if(isStaff) {
            VIEW_STATE.setCurrState(ViewState.State.StaffView);
        } else {
            VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);
        }
    }

    /**
     * To display the top 5 movies according to its ticket sales
     */
    public static void displayByTicketSales(){
        System.out.println("-----------------------------------");
        System.out.println("Top 5 movies according to ticket sales");
        System.out.println("-----------------------------------");

        ArrayList<Movie> sortedMovies = new ArrayList<>();
        MovieController.MOVIES.forEach((k,movie) -> sortedMovies.add(movie));
        sortedMovies.sort((a,b) ->  Integer.compare(b.getTicketSales(), a.getTicketSales()));

        for(int i = 0; i < Math.min(sortedMovies.size(), 5); ++i) {
            Movie m = sortedMovies.get(i);
            System.out.println("Title: " + m.getMovieTitle() + ", " + m.getTicketSales() );
        }
        System.out.println();

        boolean isStaff = VIEW_STATE.getCurrUser() instanceof Staff;

        if(isStaff) {
            VIEW_STATE.setCurrState(ViewState.State.StaffView);
        } else {
            VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);
        }
    }
}
