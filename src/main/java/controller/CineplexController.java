package controller;

import model.classes.Cinema;
import model.classes.Cineplex;
import model.classes.Movie;
import model.enums.CinemaType;
import model.enums.MovieStatus;
import utils.DatabaseLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Controller to set predefined cinemas to cineplexes hash map
 */

public class CineplexController {
    private static final String filename = "src/database/cinemaDatabase.ser";

    public static final HashMap<String, Cineplex> CINEPLEXES = new HashMap<>();

    /**
     * Load cinema objects to cineplex hash map
     */
    public static void load() {
        HashMap<String, Cineplex> hm = DatabaseLoader.loadDb(filename);
        if(hm == null || hm.size() == 0) {
            // preload movies if first time creating or there is no movies
            Cinema econ = new Cinema(1,CinemaType.Economy);
            Cinema imax = new Cinema(2,CinemaType.IMAX);
            Cinema plat = new Cinema(3,CinemaType.Platinum);

            ArrayList<Movie> movieList = new ArrayList<>();
            for(Movie m: MovieController.MOVIES.values()) {
                if(m.getMovieStatus() == MovieStatus.END_OF_SHOWING) continue;
                movieList.add(m);
            }

            Random rand = new Random();
            for(int i = 0; i < econ.getShowTiming().size(); ++i) {
                Movie randMovie = movieList.get(rand.nextInt(0, movieList.size()));
                econ.setMoviesShown(randMovie, i);
                imax.setMoviesShown(randMovie, i);
                plat.setMoviesShown(randMovie, i);
            }

            Cineplex amk = new Cineplex("AMK HUB", new ArrayList<>(List.of(econ, imax, plat)));
            Cineplex dtEast = new Cineplex("DOWNTOWN EAST", new ArrayList<>(List.of(econ, imax, plat)));
            Cineplex cwPt = new Cineplex("CAUSEWAY POINT", new ArrayList<>(List.of(econ, imax, plat)));

            CINEPLEXES.put("AMK HUB", amk);
            CINEPLEXES.put("DOWNTOWN EAST", dtEast);
            CINEPLEXES.put("CAUSEWAY POINT", cwPt);
        }

        if(hm != null) {
            System.out.println("[+] Loaded Movie Database!");
            CINEPLEXES.putAll(hm);
        }
    }

    /**
     * Write updated file to cineplexes hash map
     */
    public static void write() {
        DatabaseLoader.writeDb(filename, CINEPLEXES);
    }}
