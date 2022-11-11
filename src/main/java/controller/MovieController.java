package controller;

import model.classes.Movie;
import utils.DatabaseLoader;

import java.util.HashMap;

public class MovieController {
    private static final String filename = "src/database/movieDatabase.txt";

    public static HashMap<String, Movie> MOVIES = new HashMap<>();

    public static void loadMovies() {
        HashMap<String, Movie> hm = DatabaseLoader.loadDb(filename);
        if(hm != null) MOVIES = hm;
    }
}
