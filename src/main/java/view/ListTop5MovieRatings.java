package view;


import controller.MovieController;
import model.classes.Movie;

import java.util.ArrayList;

import static model.Main.VIEW_STATE;

public class ListTop5MovieRatings {

    public static void display(){
        System.out.println("-----------------------------------");
        System.out.println("Top 5 movies according to rating");
        System.out.println("-----------------------------------");

        ArrayList<Movie> sortedMovies = new ArrayList<>();
        MovieController.MOVIES.forEach((k,movie) -> sortedMovies.add(movie));
        sortedMovies.sort((a,b) ->  Double.compare(b.getMovieRating(), a.getMovieRating()));

        for(int i = 0; i < Math.min(sortedMovies.size(), 5); ++i) {
            Movie m = sortedMovies.get(i);
            System.out.println("Title " + m.getMovieTitle() + ", " + m.getMovieRating() );
        }
        System.out.println();
        VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);
    }
}
