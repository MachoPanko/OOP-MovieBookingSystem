package controller;

import model.classes.Booking;
import model.classes.Movie;
import utils.DatabaseLoader;

import java.util.HashMap;

public class BookHistoryController {
    private static final String filename = "src/database/movieDatabase.txt";

    public static final HashMap<String, Booking> BOOKING_HIST = new HashMap<>();

    public static void loadMovies() {
        HashMap<String, Booking> hm = DatabaseLoader.loadDb(filename);
        if(hm != null) BOOKING_HIST.putAll(hm);
    }

    public static void writeMovies() {
        DatabaseLoader.writeDb(filename, BOOKING_HIST);
    }
}
