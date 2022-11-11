package view;
import model.classes.MovieGoer;
import static model.Main.SC;
import static model.Main.VIEW_STATE;

public class MovieGoerLogin {
    public static void display() {
        System.out.println("Guest login!");
        System.out.println("1) Confirm and Proceed\n2) Back");
        int choice =  SC.nextInt();
        SC.nextLine();

        if (choice == 1) {// Create a new staff account
            System.out.println("Hello Guest! Guest account creation in progress...");
            System.out.println("Please enter your username");
            String username = SC.nextLine();
            System.out.println("Please enter your name");
            String name = SC.nextLine();
            System.out.println("Please enter your mobile number");
            int mobile = SC.nextInt();
            SC.nextLine();
            System.out.println("Please enter your age");
            int age = SC.nextInt();
            SC.nextLine();
            System.out.println("Please enter your email");
            String email = SC.nextLine();
            VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);
            VIEW_STATE.setCurrUser(new MovieGoer(username,name,mobile,age,email));

        } else {
            VIEW_STATE.setCurrState(ViewState.State.LoginView);
        }

    }
}
