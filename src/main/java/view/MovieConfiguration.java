package view;

import controller.DatabaseController;
import model.classes.Movie;

import java.util.ArrayList;
import java.util.Scanner;

import static model.Main.SC;

public class MovieConfiguration {

    public static void configureMovies() {
        System.out.println("What would you like to do?");
        System.out.println("""
                1) Display movies
                2) Create movie
                3) Update movie
                4) Delete movie""");
        switch (SC.nextInt()) {
            case 1 -> {
                // Display movies (Still cannot show casts)
                ArrayList<Movie> movies = DatabaseController.loadMovieData();
                if (movies.size() == 0) {
                    // create a file
                    DatabaseController.initMovieData();
                    System.out.println("There are no movies! Try creating new ones!");
                } else {
                    movies.forEach(System.out::println);
                }
            }
            case 2 -> MovieCreation.display(); // Create movie
            case 3 -> MovieUpdate.display(); // Update movie
        }
    }
}
