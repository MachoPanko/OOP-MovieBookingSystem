package controller;

import model.classes.Cinema;
import model.classes.Cineplex;
import model.classes.Movie;
import model.classes.Showtime;
import model.enums.AgeRating;
import model.enums.CinemaType;
import model.enums.MovieStatus;
import model.enums.MovieTag;
import utils.DatabaseLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CineplexController {
    private static final String filename = "src/database/cinemaDatabase.ser";

    public static final HashMap<String, Cineplex> CINEPLEXES = new HashMap<>();

    public static void load() {
        HashMap<String, Cineplex> hm = DatabaseLoader.loadDb(filename);
        if(hm != null) {
            if(hm.size() == 0) {
                // preload movies if first time creating or there is no movies
                CinemaType cinemaType;
                //CINEPLEXES.put("AMK HUB",new Cineplex("AMK HUB", new ArrayList<Cinema>(new Cinema(1,null,CinemaType.Economy, new Showtime()))));

            }

            System.out.println("[+] Loaded Movie Database!");
            CINEPLEXES.putAll(hm);
        }
    }

    public static void write() {
        DatabaseLoader.writeDb(filename, CINEPLEXES);
    }}
