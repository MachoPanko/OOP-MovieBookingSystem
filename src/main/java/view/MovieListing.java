package view;

import controller.MovieController;
import model.classes.Staff;

import static model.Main.SC;
import static model.Main.VIEW_STATE;

public class MovieListing {
    public static void display() {
        System.out.println("""
                Movie Listing!
                1) List all movies
                2) List top 5 movies by ticket sales
                3) List top 5 movies by movie ratings
                4) Search for a movie
                5) Back""");
        int choice = SC.nextInt();
        SC.nextLine();

        switch (choice) {
            case 1 -> {
                if(MovieController.MOVIES.size() == 0) {
                    System.out.println("There are no movies!");
                } else {
                    System.out.println("List of Movies");
                    MovieController.MOVIES.forEach((k,v) -> System.out.println(v));
                    System.out.println();
                }
            }
            case 2 -> {
                System.out.println("These are the top 5 movies based on ticket sales");
                VIEW_STATE.setCurrState(ViewState.State.ListTop5Movie2);
            }
            case 3 -> {
                System.out.println("These are the top 5 movies based on ratings");
                VIEW_STATE.setCurrState(ViewState.State.ListTop5Movie);
            }
            case 4 -> {
                System.out.println("Which movie do you want to search?");
                String searchChoice = SC.nextLine();
//                MovieController.MOVIES.stream()
//                        .filter(m -> searchChoice.toUpperCase().replaceAll("\\s+", "").equals(m.getMovieTitle().toUpperCase().replaceAll("\\s+", "")))
//                        .forEach(System.out::println);
            }
            case 5 -> {
                if( VIEW_STATE.getCurrUser() instanceof Staff){
                    VIEW_STATE.setCurrState(ViewState.State.StaffView);
                }
                else{
                    VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);
                }

            }
        }
    }
}
