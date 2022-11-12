package view;


import controller.MovieController;

import static controller.MovieController.MOVIES;

public class ListTop5MovieRatings {

    public static void display(){
        MOVIES.forEach((movieName, movie) -> {
            movie.getMovieRating();
        });
    }
}
