package view;

import controller.MovieController;
import model.classes.Movie;

import static model.Main.SC;
import static model.Main.VIEW_STATE;

/**
 * View to delete movie
 */
public class MovieDelete {
    /**
     * To display the delete movie screen
     */
    public static void display() {
        System.out.println("Enter the name of the movie to delete");
        String movieId = SC.nextLine();
        Movie m = MovieController.MOVIES.get(movieId);
        if(m == null) {
            System.out.println("MovieID " + movieId + " does not exists!");
        } else {
            MovieController.MOVIES.remove(movieId);
            System.out.println("Movie " + m.getMovieTitle() + " deleted!");
        }
        VIEW_STATE.setCurrState(ViewState.State.StaffView);
    }
}
