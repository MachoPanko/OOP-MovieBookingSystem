package view;

import static model.Main.SC;
import static model.Main.VIEW_STATE;

public class LoginView {

    public static void display() {
        System.out.println("Welcome to MOBLIMA");
        System.out.println("Are you a staff or a customer?");
        System.out.println("1) Staff\n2) Customer\n3) Exit");

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
