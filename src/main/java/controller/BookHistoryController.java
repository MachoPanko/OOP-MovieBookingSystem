package controller;

import model.classes.Booking;
import utils.DatabaseLoader;

import java.util.HashMap;

public class BookHistoryController {
    private static final String filename = "src/database/bookHistDatabase.ser";

    public static final HashMap<String, Booking> BOOKING_HIST = new HashMap<>();

    public static void load() {
        HashMap<String, Booking> hm = DatabaseLoader.loadDb(filename);
        if(hm != null) {
            System.out.println("[+] Loaded booking hist database!");
            BOOKING_HIST.putAll(hm);
        } else {
            System.out.println("[-] Empty booking hist database loaded.");
        }
    }

    public static void write() {
        DatabaseLoader.writeDb(filename, BOOKING_HIST);
    }
}
