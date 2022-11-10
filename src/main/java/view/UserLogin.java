package view;


import controller.DatabaseController;
import model.classes.Staff;

import java.util.ArrayList;
import java.util.Scanner;

public class UserLogin {

    public static void login() {
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

                        Staff staff = new Staff(username, password);
                        DatabaseController.saveStaffAccount(staff);
                    }
                    case 2 -> { // Login to an existing account
                        System.out.println("Enter your username");
                        String username = sc.nextLine();

                        System.out.println("Enter your password");
                        String password = sc.nextLine();
                        ArrayList<Staff> staff = DatabaseController.loadStaffAccount();
                        for (Staff s : staff) {
                            if (s.getUsername().equalsIgnoreCase(username) &&
                                    s.getPassword().equalsIgnoreCase(password)) {
                                System.out.println("Welcome " + s.getUsername());
                                System.out.println("Enter your choice");
                                System.out.println("1) Configure movies\n");
                                int staffChoice = Integer.parseInt(sc.nextLine());
                                if (staffChoice == 1) {
                                    MovieConfiguration.configureMovies();
                                }
                            } else {
                                System.out.println("The details you have entered does not exist");
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

}
