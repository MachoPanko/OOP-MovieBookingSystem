package view;

import controller.DatabaseController;
import model.classes.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieListing {
    public static void listMovies() {
        System.out.println("""
                1) List all movies
                2) List top 5 movies by ticket sales
                3) List top 5 movies by ticket ratings
                4) Search for a movie
                """);
        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());
        ArrayList<Movie> movies = DatabaseController.loadMovieData();
        switch (choice) {
            case 1 -> movies.forEach(System.out::println);
            case 4 -> {
                System.out.println("Which movie do you want to search?");
                String searchChoice = sc.nextLine();
                movies.stream()
                        .filter(m -> searchChoice.toUpperCase().replaceAll("\\s+", "").equals(m.getMovieTitle().toUpperCase().replaceAll("\\s+", "")))
                        .forEach(System.out::println);
            }
        }
    }
}
