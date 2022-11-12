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
                2) Configure holidays
                3) Exit""");
        int choice = SC.nextInt();
        SC.nextLine();
        ArrayList<Movie> m = new ArrayList<>(MovieController.MOVIES.values());
        System.out.println(m);
        switch (choice) {
            case 1 -> {
            // remove  first
            }
            case 2 -> {
                System.out.println("Enter new holiday date in this format : ddMM");
                String newHoliday = SC.nextLine();


            }
        }
        VIEW_STATE.setCurrState(ViewState.State.StaffView);
    }
}
