package view;
import controller.DatabaseController;
import model.classes.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieListing {
    public static void listMovies(){
        System.out.println("1)List all movies\n" +
                "2)List top 5 movies by ticket sales\n" +
                "3) List top 5 movies by ticket ratings\n" +
                "4) Search for a movie\n");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        ArrayList<Movie> movies = DatabaseController.loadMovieData();
        if(choice == "1"){
            for(Movie m : movies){
                System.out.println(m);
            }
        }
        else if(choice == "4"){
            System.out.println("Which movie do you want to search?");
            String searchChoice = sc.nextLine();
            for(Movie m : movies){
                if(searchChoice.toUpperCase().replaceAll("\\s+","") == m.getMovieTitle().toUpperCase().replaceAll("\\s+","")){
                    System.out.println(m);
                }
            }
        }
    }
}
