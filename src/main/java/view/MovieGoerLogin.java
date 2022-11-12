package view;
import controller.UserController;
import model.classes.MovieGoer;
import static model.Main.SC;
import static model.Main.VIEW_STATE;

public class MovieGoerLogin {
    public static void display() {
        System.out.println("Guest login!");
        System.out.println("1) Register new account\n2) Log in to existing account \n3) Back");
        int choice =  SC.nextInt();
        SC.nextLine();

        if (choice == 1) {// Create a new guest account
            System.out.println("Hello Guest! Guest account creation in progress...");
            System.out.println("Please enter your username");
            String username = SC.nextLine();
            System.out.println("Please enter your mobile number");
            int mobile = SC.nextInt();
            SC.nextLine();
            System.out.println("Please enter your age");
            int age = SC.nextInt();
            SC.nextLine();
            System.out.println("Please enter your email");
            String email = SC.nextLine();
            MovieGoer newUser = new MovieGoer(username,mobile,age,email);

            if (UserController.USER_DATABASE.get(username)==null){ // if user does not exist
                System.out.println("Account Creation Success! Welcome " + username +"!");
                VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);
                VIEW_STATE.setCurrUser(newUser);
                UserController.USER_DATABASE.put(username, newUser);
            }
            else {
                System.out.println("User Already Exists! Please try again.");
                VIEW_STATE.setCurrState(ViewState.State.MovieGoerLoginView);
            }

        } else if (choice == 2) {
            System.out.println("Logging in...");
            System.out.println("Please enter your username");
            String username = SC.nextLine();
            MovieGoer user = UserController.USER_DATABASE.get(username);
            if (user==null){ // if user does not exist
                System.out.println("User Does not Exist! Please try again.");
                VIEW_STATE.setCurrState(ViewState.State.MovieGoerLoginView);
            }
            else {
                System.out.println("Log in Success! Welcome " + username +"!");
                VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);
                VIEW_STATE.setCurrUser(user);
            }
            
        } else {
            VIEW_STATE.setCurrState(ViewState.State.LoginView);
        }

    }
}
