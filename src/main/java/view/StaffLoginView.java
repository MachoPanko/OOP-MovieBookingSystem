package view;

import controller.StaffController;
import model.classes.Staff;

import java.util.Scanner;

import static model.Main.SC;
import static model.Main.VIEW_STATE;

public class StaffLoginView {
    public static void display() {
        System.out.println("You are a staff!");
        System.out.println("1) Login staff account\n2) Back");
        int choice =  SC.nextInt();
        SC.nextLine();

        if (choice == 1) {// Create a new staff account
            System.out.println("Enter your username");
            String username = SC.nextLine();

            System.out.println("Enter your password");
            String password = SC.nextLine();

            Staff staff = StaffController.STAFF_ACCOUNTS.get(username);

            if (staff == null) {
                System.out.println("Staff account dont exist!");
            } else {
                if(staff.getPassword().equals(password)) {
                    System.out.println("Hello " + staff.getUsername());
                    VIEW_STATE.setCurrState(ViewState.State.StaffView);
                } else {
                    System.out.println("Wrong password! Try again!");
                }
            }
        } else {
            VIEW_STATE.setCurrState(ViewState.State.LoginView);
        }
    }
}
