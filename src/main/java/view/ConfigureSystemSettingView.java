package view;

import controller.CineplexController;
import controller.MovieController;
import model.classes.Cinema;
import model.classes.Cineplex;
import model.classes.Movie;
import model.enums.DayType;

import java.util.ArrayList;

import static java.util.stream.Collectors.toCollection;
import static model.Main.SC;
import static model.Main.VIEW_STATE;

/**
 * View for system setting
 */
public class ConfigureSystemSettingView {
    /**
     * To display the system setting screen
     */
    public static void display() {
        System.out.println("""
                Configure System Setting
                1) Add all
                2) Configure holidays
                3) Configure cinema
                4) Exit""");
        int choice = SC.nextInt();
        SC.nextLine();

        ArrayList<Movie> m = new ArrayList<>(MovieController.MOVIES.values());
        System.out.println(m);
        switch (choice) {
            case 1 -> {
            // remove  first
            }
            case 2 -> {
                System.out.println("""
                Configure System Setting
                1) Add holidays
                2) Remove holidays
                """);
                choice = SC.nextInt();
                SC.nextLine();
                if(choice == 1){
                    System.out.println("Enter the date of the holiday in this format 'ddMM'");
                    String holiday = SC.nextLine();
                    DayType.addHoliday(holiday);
                } else if (choice == 2) {
                    String holiday = SC.nextLine();
                    DayType.deleteHoliday(holiday);
                }
                VIEW_STATE.setCurrState(ViewState.State.StaffView);
            }
            case 3 -> VIEW_STATE.setCurrState(ViewState.State.ConfigureCinemaView);
            case 4 -> VIEW_STATE.setCurrState(ViewState.State.StaffView);
        }
    }
}
