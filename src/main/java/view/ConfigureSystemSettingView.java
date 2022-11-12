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
                for (Cineplex cineplex : CineplexController.CINEPLEXES.values()){
                    for(Cinema cinema : cineplex.getCinemaList()){
                        cinema.setMoviesShown(m);
                    }
                }
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

        }
        VIEW_STATE.setCurrState(ViewState.State.StaffView);
    }
}
