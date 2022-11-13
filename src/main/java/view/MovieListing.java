package view;

import controller.MovieController;
import model.classes.Movie;
import model.classes.MovieGoer;
import model.classes.Staff;
import model.enums.MovieStatus;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static model.Main.SC;
import static model.Main.VIEW_STATE;

/**
 * View for movie list
 */
public class MovieListing {
    public static void display() {
        System.out.println("""
                Movie Listing!
                1) List all movies
                2) Search for a movie
                3) Back""");

        int choice = SC.nextInt();
        SC.nextLine();

        switch (choice) {
            case 1 -> {
                if (MovieController.MOVIES.size() == 0) {
                    System.out.println("There are no movies!");
                } else {
                    System.out.println("List of Movies");
                    MovieController.MOVIES.forEach((k, v) -> {
                        boolean isStaff = VIEW_STATE.getCurrUser() instanceof Staff;
                        if (!isStaff) {
                            if (v.getMovieStatus() == MovieStatus.END_OF_SHOWING) {
                                return;
                            }
                        }
                        System.out.println(v);
                    });
                    System.out.println();
                }
            }
            case 2 -> {
                System.out.println("Which movie do you want to search?");
                String movieToSearch = SC.nextLine();
                ArrayList<Movie> m = MovieController.MOVIES.values()
                        .stream()
                        .filter(movie -> movie.getMovieTitle().contains(movieToSearch))
                        .collect(Collectors.toCollection(ArrayList::new));

                System.out.println("These are the movies that you might be looking for!");
                for(Movie movie : m) {
                    System.out.println(movie);
                }
                System.out.println();
            }
            case 3 -> {
                if (VIEW_STATE.getCurrUser() instanceof Staff) {
                    VIEW_STATE.setCurrState(ViewState.State.StaffView);
                } else {
                    VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);
                }

            }
        }
    }
}
