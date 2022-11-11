package controller;

import model.classes.Movie;
import utils.DatabaseLoader;

import java.util.HashMap;

public class MovieController {
    private static final String filename = "src/database/movieDatabase.ser";

    public static final HashMap<String, Movie> MOVIES = new HashMap<>();

    public static void load() {
        HashMap<String, Movie> hm = DatabaseLoader.loadDb(filename);
        if(hm != null) {
            System.out.println("[+] Loaded Movie Database!");
            MOVIES.putAll(hm);
        }
    }

    public static void write() {
        DatabaseLoader.writeDb(filename, MOVIES);
    }
}
