package model;

import utils.DatabaseLoader;
import view.*;

import java.util.Scanner;

public class Main {

    /**
     * Contains user and view information to display things correctly
     */
    public static final ViewState VIEW_STATE = new ViewState(ViewState.State.LoginView, null);
    public static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        // register ctrl-c handler, we should save all database on exit
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
                case MovieGoerLoginView -> {}
                case ExitedView -> {}
            }
        }

//        UserLogin.displayLoginMenu();
//        MovieCreation.createMovie();
//        MovieConfiguration.configureMovies();
//        BookingSystem.purchaseTicket();

    }

}