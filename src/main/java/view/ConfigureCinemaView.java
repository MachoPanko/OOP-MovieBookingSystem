package view;

import controller.CineplexController;
import controller.MovieController;
import model.classes.Cinema;
import model.classes.Cineplex;
import model.classes.Movie;
import model.classes.Showtime;
import model.enums.MovieStatus;

import static model.Main.SC;
import static model.Main.VIEW_STATE;

/**
 * View for staff to configure cinema setting
 */
public class ConfigureCinemaView {

    private static Cineplex currentCineplex;
    private static Cinema cinema;

    /**
     * To display configure cinema setting screen
     */
    public static void display() {
        System.out.println("""
                Please Enter the name of the Cineplex to configure!!
                Enter BACK to go back
                - AMK HUB
                - DOWNTOWN EAST
                - CAUSEWAY POINT
                """);

        String cineplexStr = SC.nextLine();
        if(cineplexStr.equalsIgnoreCase("BACK")) {
            VIEW_STATE.setCurrState(ViewState.State.ConfigureSystemSettingView);
        }

        currentCineplex = CineplexController.CINEPLEXES.get(cineplexStr);
        if(currentCineplex == null) {
            System.out.println("We dont have that cineplex! Try again!");
            return;
        }
        System.out.println("Please Enter the cinema room of the Cineplex to configure!!");

        for(int i = 0; i < currentCineplex.getCinemaList().size(); ++i) {
            Cinema c = currentCineplex.getCinemaList().get(i);
            System.out.println((i+1) + ")\tHall " + c.getCinemaCode() + "(" + c.getCinemaClass() + ")");
        }

        int cinemaCode = SC.nextInt() - 1;
        SC.nextLine();

        System.out.println("Configuring Hall " + (cinemaCode + 1));
        cinema = currentCineplex.getCinemaList().get(cinemaCode);
        VIEW_STATE.setCurrState(ViewState.State.ConfigureCinemaSubmenu);
    }

    /**
     * To display the second page of the configure cinema
     */
    public static void displaySubmenu() {
        System.out.println("""
                Configure Cinema!!
                1) Remove Movie from showtime
                2) Add/Replace Movie to showtime
                3) Display Movie Shown
                4) Back""");
        int choice = SC.nextInt();
        SC.nextLine();

        switch (choice) {
            case 1 -> {
                Showtime showtime = cinema.getShowTiming();
                System.out.println("Select show time to remove movie");
                for(int i = 0; i < showtime.size(); ++i) {
                    System.out.print((i + 1) + ")\t" + showtime.TIME[i] + "\t");
                    if(i % 3 == 0) { System.out.println(); }
                }
                System.out.println();
                int showTimeIdx = SC.nextInt() - 1;
                SC.nextLine();

                cinema.getMoviesShown()[showTimeIdx] = null;
                System.out.println("Removed movie!");
                VIEW_STATE.setCurrState(ViewState.State.ConfigureCinemaSubmenu);
            }
            case 2 -> {
                Showtime showtime = cinema.getShowTiming();
                System.out.println("Select show time to add/replace movie");
                for(int i = 0; i < showtime.size(); ++i) {
                    System.out.print((i + 1) + ")\t" + showtime.TIME[i] + "\t");
                    if(i % 3 == 0) { System.out.println(); }
                }
                System.out.println();

                int showTimeIdx = SC.nextInt() - 1;
                SC.nextLine();

                System.out.println("Select movies to showtime");

                MovieController.MOVIES.forEach((k, v) -> {
                    if(v.getMovieStatus() == MovieStatus.END_OF_SHOWING) return;
                    System.out.println(v.getMovieTitle());
                });

                String movieStr = SC.nextLine();
                cinema.getMoviesShown()[showTimeIdx] = MovieController.MOVIES.get(movieStr);

                System.out.println("Added/Replaced movie with " + cinema.getMoviesShown()[showTimeIdx] + '\n');
                VIEW_STATE.setCurrState(ViewState.State.ConfigureCinemaSubmenu);
            }
            case 3 -> {
                System.out.println("Show timing and movies");
                Showtime showtime = cinema.getShowTiming();
                Movie[] movies = cinema.getMoviesShown();
                System.out.println("Displaying all showtime and movie\n");
                for(int i = 0; i < showtime.size(); ++i) {
                    String movieName = movies[i] != null ? movies[i].getMovieTitle() : "-";
                    System.out.println(showtime.TIME[i] + ":" + movieName + "\t");
                }
                System.out.println();
                VIEW_STATE.setCurrState(ViewState.State.ConfigureCinemaSubmenu);
            }
            case 4 -> VIEW_STATE.setCurrState(ViewState.State.ConfigureSystemSettingView);
        }
    }
}
