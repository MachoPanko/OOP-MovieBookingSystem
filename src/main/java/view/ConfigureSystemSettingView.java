package view;

import controller.CineplexController;
import controller.MovieController;
import model.classes.Cinema;
import model.classes.Cineplex;
import model.classes.Movie;

import java.util.ArrayList;

import static model.Main.SC;

public class ConfigureSystemSettingView {
    public static void display() {
        System.out.println("""
                Configure System Setting
                1) Add all movies
                2) Add a Movie
                3) Exit""");
        int choice = SC.nextInt();
        SC.nextLine();
        switch (choice) {
            case 1 -> {
                for (Cineplex cineplex : CineplexController.CINEPLEXES.values()){
                    for(Cinema cinema : cineplex.getCinemaList()){
                        cinema.setMoviesShown((ArrayList<Movie>) MovieController.MOVIES.values()); // error
                    }
                }
            }
        }
    }
}
