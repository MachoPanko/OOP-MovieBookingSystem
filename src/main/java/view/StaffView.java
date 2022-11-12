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
                 6) See Top 5 ranking by ticket sales
                 7) See Top 5 ranking by overall reviewers' ratings
                 8) Logout""");

        int choice = SC.nextInt();
        SC.nextLine();

        switch (choice) {
            case 1 -> VIEW_STATE.setCurrState(ViewState.State.ViewMoviesView);
            case 2 -> VIEW_STATE.setCurrState(ViewState.State.AddMovieView);
            case 3 -> VIEW_STATE.setCurrState(ViewState.State.UpdateMovieView);
            case 4 -> VIEW_STATE.setCurrState(ViewState.State.DeleteMovieView);
            case 5 -> VIEW_STATE.setCurrState(ViewState.State.ConfigureSystemSettingView);
            case 6 -> VIEW_STATE.setCurrState(ViewState.State.ListTop5Movie);
            case 7 -> VIEW_STATE.setCurrState(ViewState.State.ListTop5Movie2);
            default -> {
                System.out.println("Logging out staff.");
                VIEW_STATE.setCurrState(ViewState.State.LoginView);
                VIEW_STATE.setCurrUser(null);
            }
        }
    }
}
