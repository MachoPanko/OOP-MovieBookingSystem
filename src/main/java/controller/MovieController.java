package controller;

import model.classes.Movie;
import utils.DatabaseLoader;

import java.util.HashMap;

public class MovieController {
    private static final String filename = "src/database/movieDatabase.txt";

    public static final HashMap<String, Movie> MOVIES = new HashMap<>();

    public static void loadMovies() {
        HashMap<String, Movie> hm = DatabaseLoader.loadDb(filename);
        if(hm != null) {
            System.out.println("Loaded Movie Database!");
            MOVIES.putAll(hm);
        } else {
            System.out.println("Empty movie database loaded.");
        }
    }

    public static void writeMovies() {
        DatabaseLoader.writeDb(filename, MOVIES);
    }
}
