package view;

import controller.DatabaseController;
import model.classes.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieConfiguration {

    public static void configureMovies(){
        System.out.println("What would you like to do?");
        System.out.println("1)Display movies\n2) Create movie\n3) Update movie\n3) Delete movie");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice == 1){ // Display movies (Stiil cannot show casts)
            ArrayList<Movie> movies = DatabaseController.loadMovieData();
            for(Movie m : movies){
                System.out.println(m);
            }
        }else if(choice == 2){ // Create movie
            MovieCreation.createMovie();
        }
        else if(choice == 3){ // Update movie
            MovieUpdate.updateMovie();
        }
    }
}
