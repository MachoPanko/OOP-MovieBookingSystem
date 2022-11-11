package view;

import controller.MovieController;
import model.enums.AgeRating;
import model.classes.Movie;
import model.enums.MovieStatus;
import model.enums.MovieTag;

import java.util.ArrayList;

import static model.Main.SC;
import static model.Main.VIEW_STATE;

public class MovieUpdate {
    private static Movie m = null;

    public static void display() {
        System.out.println("Enter the name of the movie to update");
        String movieId = SC.nextLine();
        m = MovieController.MOVIES.get(movieId);

        if(m == null) {
            System.out.println("MovieID " + movieId + " does not exists!");
            VIEW_STATE.setCurrState(ViewState.State.StaffView);
        } else {
            VIEW_STATE.setCurrState(ViewState.State.UpdateMovieViewSubmenu);
        }
    }

    public static void displaySubmenu() {
        System.out.println("What do you want to update?");
        System.out.println("""
                        1) Title
                        2) Director
                        3) Casts
                        4) Movie Tag
                        5) Status
                        6) Age Rating
                        7) Movie Rating
                        8) Synopsis
                        9) Back""");

        int updateChoice = SC.nextInt();
        SC.nextLine();

        switch (updateChoice) {
            case 1 -> {
                System.out.println("Update movie title:");
                String titleUpdate = SC.nextLine();
                m.setMovieTitle(titleUpdate);
                MovieController.MOVIES.put(titleUpdate, m);
                MovieController.MOVIES.remove(titleUpdate);
            }
            case 2 -> {
                System.out.println("Update movie director:");
                String directorUpdate = SC.nextLine();
                m.setMovieDirector(directorUpdate);
            }
            case 3 -> {
                System.out.println("Update movie casts");
                ArrayList<String> casts = new ArrayList<>();
                System.out.println("Enter number of casts:");
                int noCast = Integer.parseInt(SC.nextLine());

                for (int i = 0; i < noCast; ++i) {
                    System.out.println("Enter cast name:");
                    String castName = SC.nextLine();
                    casts.add(castName);
                }

                m.setCasts(casts);
            }
            case 4 -> {
                System.out.println("Update movie tag");
                System.out.println("Blockbuster, Normal, 3D");
                String tagChoice = SC.nextLine();
                MovieTag movieTag = MovieTag.getMovieTag(tagChoice);
                m.setMovieTag(movieTag);
            }
            case 5 -> {
                System.out.println("Update movie status");
                System.out.println("Coming_Soon, Preview, Now_Showing, End_Of_Showing");
                String statusChoice = SC.nextLine();
                MovieStatus movieStatus = MovieStatus.getMovieStatus(statusChoice);
                m.setMovieStatus(movieStatus);
            }
            case 6 -> {
                System.out.println("Update age rating");
                System.out.println("G, PG, PG13, NC17");
                String ageRatingUpdate = SC.nextLine();
                AgeRating ageRating = AgeRating.getRating(ageRatingUpdate);
                m.setAgeRating(ageRating);
            }
            case 7 -> {
                System.out.println("Update movie rating (0-5)");
                double movieRatingUpdate = Double.parseDouble(SC.nextLine());
                m.setMovieRating(movieRatingUpdate);
            }
            case 8 -> {
                System.out.println("Update movie synopsis");
                String synopsisUpdate = SC.nextLine();
                m.setMovieSynopsis(synopsisUpdate);
            }
            case 9 -> {
                VIEW_STATE.setCurrState(ViewState.State.StaffView);
                return;
            }
        }

        VIEW_STATE.setCurrState(ViewState.State.UpdateMovieViewSubmenu);
    }
}
