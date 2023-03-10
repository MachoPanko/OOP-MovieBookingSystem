package model;

import controller.CineplexController;
import utils.DatabaseLoader;
import view.*;
import java.util.Scanner;

/**
 * This is where we run the MOBLIMA menu
 */
public class Main {

    /**
     * Contains user and view information to display things correctly. Need to make sure invariants are CHECKED, before
     * state and user is set!
     */
    public static final ViewState VIEW_STATE = new ViewState(ViewState.State.LoginView, null);

    /**
     * Global Scanner object to be used. DO NOT CREATE ANY OTHER SCANNER OBJECTS
     */
    public static final Scanner SC = new Scanner(System.in);

    /**
     * To run the menu
     * @param args Stores input used to run it in string array
     */
    public static void main(String[] args) {
        // register ctrl-c handler, we should save all database on exit or unexpected shutdown
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
//        System.out.println(CineplexController.CINEPLEXES);

        while (VIEW_STATE.getCurrState() != ViewState.State.ExitedView) {
            switch (VIEW_STATE.getCurrState()) {
                case LoginView -> LoginView.display();
                case StaffLoginView -> StaffLoginView.display();
                case StaffView -> StaffView.display();
                case ViewMoviesView -> MovieListing.display();
                case AddMovieView -> MovieCreation.display();
                case UpdateMovieView -> MovieUpdate.display();
                case UpdateMovieViewSubmenu -> MovieUpdate.displaySubmenu();
                case DeleteMovieView -> MovieDelete.display();
                case ConfigureSystemSettingView -> ConfigureSystemSettingView.display();
                case ConfigureCinemaView -> ConfigureCinemaView.display();
                case ConfigureCinemaSubmenu -> ConfigureCinemaView.displaySubmenu();
                case MovieGoerLoginView -> MovieGoerLogin.display();
                case MovieGoerView -> MovieGoerMenu.display();
                case BookingSystemView -> BookingSystem.display();
                case BookingHistView -> BookingHistory.display();
                case ReviewView -> MovieGoerMenu.displayReviewMenu();
                case ListTop5Movie -> ListTop5Movie.displayByRating();
                case ListTop5Movie2 -> ListTop5Movie.displayByTicketSales();
                case ExitedView -> {}
            }
        }
    }

}