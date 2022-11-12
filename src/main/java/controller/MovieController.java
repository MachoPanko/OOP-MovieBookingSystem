package controller;

import model.classes.Movie;
import model.classes.MovieGoer;
import model.classes.Review;
import model.enums.AgeRating;
import model.enums.MovieStatus;
import model.enums.MovieTag;
import utils.DatabaseLoader;

import java.util.*;

public class MovieController {
    private static final String filename = "src/database/movieDatabase.ser";

    public static final HashMap<String, Movie> MOVIES = new HashMap<>();

    public static void load() {
        HashMap<String, Movie> hm = DatabaseLoader.loadDb(filename);

        if(hm == null || hm.size() == 0) {
            // preload movies if first time creating or there is no movies
            String dummySynopsis = "Dominic Toretto (Vin Diesel) enjoys the adrenaline of street car racing and his fans treat him like a rock star. After a blazing encounter with the ruthless Johnny Tran, Dom decides to take Brian (Paul Walker), a newcomer to street racing, under his wing. Dom's sister Mia sees something she likes in Brian, too. Trouble is, neither of them realize he's an undercover cop, and Dominic and his rival Johnny Tran are both the prime suspects in a case involving dirty money and big-rig hijacking.";
            MOVIES.put("Ice Age 2", new Movie("Ice Age 2", MovieTag.THREED, MovieStatus.NOW_SHOWING, dummySynopsis,  "Tao", AgeRating.PG, new ArrayList<>(List.of("Budi", "Azfar"))));
            MOVIES.put("Fast and Furious 420", new Movie("Fast and Furious 420", MovieTag.BLOCKBUSTER, MovieStatus.NOW_SHOWING, dummySynopsis,  "Tao", AgeRating.PG, new ArrayList<>(List.of("Budi", "Azfar"))));
            MOVIES.put("KingsWomen", new Movie("KingsWomen", MovieTag.BLOCKBUSTER, MovieStatus.NOW_SHOWING, dummySynopsis,  "Tao", AgeRating.PG, new ArrayList<>(List.of("Budi", "Azfar"))));
            MOVIES.put("The Beginning of OOP", new Movie("The Beginning of OOP", MovieTag.BLOCKBUSTER, MovieStatus.NOW_SHOWING, dummySynopsis,  "Tao", AgeRating.PG, new ArrayList<>(List.of("Budi", "Azfar"))));
            MOVIES.put("Parasite", new Movie("Parasite", MovieTag.NORMAL, MovieStatus.NOW_SHOWING, dummySynopsis,  "Tao", AgeRating.PG, new ArrayList<>(List.of("Budi", "Azfar"))));
            MOVIES.put("Jon7", new Movie("Jon7", MovieTag.NORMAL, MovieStatus.NOW_SHOWING, dummySynopsis,  "Tao", AgeRating.PG, new ArrayList<>(List.of("Budi", "Azfar"))));
            MOVIES.put("Slow and Chill 7", new Movie("Slow and Chill 7", MovieTag.NORMAL, MovieStatus.NOW_SHOWING, dummySynopsis, "Tao", AgeRating.PG, new ArrayList<>(List.of("Budi", "Azfar"))));

            Random rand = new Random();
            MOVIES.forEach((k,v) -> {
                v.increaseTicketSales();
                if(v.getMovieTitle().equals("KingsWomen")) {
                    return;
                }
                v.updateReviews(new Review(new MovieGoer("John7", 999, 21, "John7@gmail.com"), "Good movie!",rand.nextDouble(0.0, 5.0)));
            });
        }

        if(hm != null) {
            System.out.println("[+] Loaded Movie Database!");
            MOVIES.putAll(hm);
        }
    }

    public static void write() {
        DatabaseLoader.writeDb(filename, MOVIES);
    }
}
