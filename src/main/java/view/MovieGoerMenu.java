package view;

import java.util.Scanner;

public class MovieGoerMenu {
    public static void display() {
        System.out.println("""
                1) List/Search Movies
                2) Book & purchase ticket
                3) View Booking History
                4) See Top 5 ranking by ticket sales
                5) See Top 5 ranking by overall reviewers' ratings""");
        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
//            case 1 -> MovieListing.display(); // List out all movies
//            case 2 -> BookingSystem.purchaseTicket();
//            case 3 -> {
//                System.out.println("Please enter your name");
//                String name = sc.nextLine();
//                BookingHistory.getBookingHistory(name); // Print out booking history
//            }
        }
    }
}
