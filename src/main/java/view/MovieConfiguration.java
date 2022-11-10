package view;

import controller.DatabaseController;
import model.classes.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieConfiguration {

    public static void configureMovies() {
        System.out.println("What would you like to do?");
        System.out.println("1) Display movies\n2) Create movie\n3) Update movie\n3) Delete movie");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
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
            case 2 -> MovieCreation.createMovie(); // Create movie
            case 3 -> MovieUpdate.updateMovie(); // Update movie
        }
    }
}
