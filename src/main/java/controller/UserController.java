package controller;

import model.classes.Booking;
import model.classes.MovieGoer;
import model.classes.MovieTicket;
import model.classes.Transaction;
import model.enums.CinemaType;
import model.enums.DayType;
import model.enums.TransactionType;
import utils.DatabaseLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Controller class to make a predefined movieGoer with bookings in the system
 */

public class UserController {
    private static final String filename = "src/database/userDatabase.ser";

    public static final HashMap<String, MovieGoer> USER_DATABASE = new HashMap<>();

    /**
     * A function to load predefined movies
     */
    public static void load() {
        HashMap<String, MovieGoer> hm = DatabaseLoader.loadDb(filename);
        if(hm == null || hm.size() == 0) {
            MovieGoer m = new MovieGoer("John7", 999, 21, "John7@gmail.com");

            m.updateBookings(new Booking(UUID.randomUUID().toString(), m, "27-11-2022", new ArrayList<>(List.of(
                    new MovieTicket(MovieController.MOVIES.get("Ice Age 2"), CinemaType.Economy, DayType.FRIDAY, true, false, 0, 0, 1),
                    new MovieTicket(MovieController.MOVIES.get("Fast and Furious 420"), CinemaType.Economy, DayType.FRIDAY, true, false, 0, 0, 1),
                    new MovieTicket(MovieController.MOVIES.get("KingsWomen"), CinemaType.Economy, DayType.FRIDAY, true, false, 0, 0, 1),
                    new MovieTicket(MovieController.MOVIES.get("The Beginning of OOP"), CinemaType.Economy, DayType.FRIDAY, true, false, 0, 0, 1),
                    new MovieTicket(MovieController.MOVIES.get("Parasite"), CinemaType.Economy, DayType.FRIDAY, true, false, 0, 0, 1),
                    new MovieTicket(MovieController.MOVIES.get("Jon7"), CinemaType.Economy, DayType.FRIDAY, true, false, 0, 0, 1),
                    new MovieTicket(MovieController.MOVIES.get("Slow and Chill 7"), CinemaType.Economy, DayType.FRIDAY, true, false, 0, 0, 1)
            )), new Transaction(UUID.randomUUID().toString(), 70.0, "27-10-2022", TransactionType.CREDITCARD), "AMK HUB"));

            USER_DATABASE.put("John7", m);
        }

        if(hm != null) {
            System.out.println("[+] Loaded booking hist database!");
            USER_DATABASE.putAll(hm);
        } else {
            System.out.println("[-] Empty booking hist database loaded.");
        }
    }

    /**
     * Writes an updated file to the database
     */
    public static void write() {
        DatabaseLoader.writeDb(filename, USER_DATABASE);
    }
}
