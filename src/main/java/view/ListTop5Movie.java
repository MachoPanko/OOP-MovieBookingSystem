package view;


import controller.MovieController;
import model.classes.Movie;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static model.Main.VIEW_STATE;

public class ListTop5Movie {

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
        VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);
    }

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
        VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);
    }
}
