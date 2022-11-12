package view;

import controller.CineplexController;
import controller.MovieController;
import model.classes.Cinema;
import model.classes.Cineplex;
import model.classes.Movie;

import java.util.ArrayList;

import static java.util.stream.Collectors.toCollection;
import static model.Main.SC;
import static model.Main.VIEW_STATE;

public class ConfigureSystemSettingView {
    public static void display() {
        System.out.println("""
                Configure System Setting
                1) Add all
                2) Add a Movie
                3) Exit""");
        int choice = SC.nextInt();
        ArrayList<Movie> m = new ArrayList<>(MovieController.MOVIES.values());
        System.out.println(m);

        SC.nextLine();
        switch (choice) {
            case 1 -> {
                for (Cineplex cineplex : CineplexController.CINEPLEXES.values()){
                    for(Cinema cinema : cineplex.getCinemaList()){
                        cinema.setMoviesShown(m);
                    }
                }
            }
        }
        VIEW_STATE.setCurrState(ViewState.State.StaffView);
    }
}
