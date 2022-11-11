package view;

import static model.Main.SC;
import static model.Main.VIEW_STATE;

public class StaffView {
    public static void display() {
        System.out.println("Staff Menu!");
        System.out.println("""
                 1) View Movies
                 2) Add Movie
                 3) Update Movie
                 4) Delete Movie
                 5) Configure System Settings
                 6) Logout""");

        int choice = SC.nextInt();
        SC.nextLine();

        switch (choice) {
            case 1 -> VIEW_STATE.setCurrState(ViewState.State.ViewMoviesView);
            case 2 -> VIEW_STATE.setCurrState(ViewState.State.AddMovieView);
            case 3 -> VIEW_STATE.setCurrState(ViewState.State.UpdateMovieView);
            case 4 -> VIEW_STATE.setCurrState(ViewState.State.DeleteMovieView);
            case 5 -> VIEW_STATE.setCurrState(ViewState.State.ConfigureSystemSettingView);
            default -> {
                System.out.println("Logging out staff.");
                VIEW_STATE.setCurrState(ViewState.State.LoginView);
                VIEW_STATE.setCurrUser(null);
            }
        }
    }
}
