package view;

import static model.Main.SC;
import static model.Main.VIEW_STATE;

/**
 * View for login
 */
public class LoginView {

    /**
     * Display login view
     */
    public static void display() {
        System.out.println("""
                Welcome to MOBLIMA
                Are you a staff or a customer?
                1) Staff
                2) Customer
                3) Exit""");

        int choice = SC.nextInt();
        SC.nextLine();

        if(choice == 1) {
            VIEW_STATE.setCurrState(ViewState.State.StaffLoginView);
        } else if(choice == 2) {
            VIEW_STATE.setCurrState(ViewState.State.MovieGoerLoginView);
        } else {
            VIEW_STATE.setCurrState(ViewState.State.ExitedView);
        }
    }
}
