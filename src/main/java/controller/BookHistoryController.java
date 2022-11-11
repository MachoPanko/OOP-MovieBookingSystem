package controller;

import model.classes.Booking;
import model.classes.Movie;
import utils.DatabaseLoader;

import java.util.HashMap;

public class BookHistoryController {
    private static final String filename = "src/database/bookHistDatabase.txt";

    public static final HashMap<String, Booking> BOOKING_HIST = new HashMap<>();

    public static void loadBookingHist() {
        HashMap<String, Booking> hm = DatabaseLoader.loadDb(filename);
        if(hm != null) {
            System.out.println("Loaded booking hist database!");
            BOOKING_HIST.putAll(hm);
        } else {
            System.out.println("Empty booking hist database loaded.");
        }
    }

    public static void writeBookingHist() {
        DatabaseLoader.writeDb(filename, BOOKING_HIST);
    }
}
