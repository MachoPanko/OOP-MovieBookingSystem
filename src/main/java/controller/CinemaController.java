package controller;

import model.classes.Cinema;
import utils.DatabaseLoader;

import java.util.HashMap;


public class CinemaController {
    private static final String filename = "src/database/cinemaDatabase.ser";

    public static final HashMap<String, Cinema> CINEMAS = new HashMap<>();

    public static void load() {
        HashMap<String, Cinema> hm = DatabaseLoader.loadDb(filename);
        if(hm != null) {
            System.out.println("[+] Loaded Movie Database!");
            CINEMAS.putAll(hm);
        }
    }

    public static void write() {
        DatabaseLoader.writeDb(filename, CINEMAS);
    }
}
