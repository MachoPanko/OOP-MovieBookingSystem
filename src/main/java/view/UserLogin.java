package view;

import controller.StaffController;
import model.classes.Staff;

import java.util.Scanner;

public class UserLogin {

    public static void displayLoginMenu() {
        System.out.println("Welcome to MOBLIMA");
        System.out.println("Are you a staff or a customer?");
        System.out.println("1) Staff\n2) Customer");

        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1 -> {
                System.out.println("You are a staff!");
                System.out.println("1) Create staff account\n2) Login staff account");
                int choiceToCreateOrLogin = sc.nextInt();
                sc.nextLine();
                switch (choiceToCreateOrLogin) {
                    case 1 -> { // Create a new staff account
                        System.out.println("Create your username");
                        String username = sc.nextLine();

                        System.out.println("Create your password");
                        String password = sc.nextLine();
                        Staff staff = StaffController.STAFF_ACCOUNTS.get(username);

                        if(staff != null) {
                            System.out.println("Staff account already exist!");
                        } else {
                            StaffController.STAFF_ACCOUNTS.put(username, new Staff(username, password));
                            System.out.println("[+] New staff account added!");
                        }

                    }
                    case 2 -> { // Login to an existing account
                        System.out.println("Enter your username");
                        String username = sc.nextLine();

                        System.out.println("Enter your password");
                        String password = sc.nextLine();
                        Staff staff = StaffController.STAFF_ACCOUNTS.get(username);
                        if(staff == null) {
                            System.out.println("Staff " + username + " does not exist!");
                        } else if (staff.getPassword().equals(password)){
                            System.out.println("Welcome " + staff.getUsername());
                            System.out.println("Enter your choice");
                            System.out.println("1) Configure movies\n");
                            int staffChoice = Integer.parseInt(sc.nextLine());
                            if (staffChoice == 1) {
                                MovieConfiguration.configureMovies();
                            }
                        } else {
                            System.out.println("Staff account does not exists!");
                        }
                    }
                }
            }
        }
    }

}
