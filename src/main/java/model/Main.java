package model;

import model.enums.MovieStatus;
import model.enums.MovieTag;
import utils.DatabaseLoader;
import view.BookingSystem;
import view.MovieCreation;
import view.MovieListing;
import view.UserLogin;
import model.classes.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // register ctrl-c handler, we should save all database on exit
        /*
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                Thread.sleep(200);
                System.out.println("[+] Handling ctrl-c!");
                System.out.println("[+] Running cleanup code!");
                DatabaseLoader.saveAllDb();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }));

        DatabaseLoader.loadAllDb();
        UserLogin.displayLoginMenu();

//        MovieCreation.createMovie();
//        MovieConfiguration.configureMovies();
//        BookingSystem.purchaseTicket();


         */
        //MovieCreation.createMovie();
        //MovieListing.listMovies();
        BookingSystem.purchaseTicket();
    }


}