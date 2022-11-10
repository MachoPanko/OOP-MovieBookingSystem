package view;

import java.io.IOException;
import java.util.Scanner;

public class MovieGoerMenu {
    public static void menu() throws IOException {
        System.out.println("1) Movie Listing\n2) Book & purchase ticket\n3) View Booking History\n");
        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1 -> MovieListing.listMovies(); // List out all movies
            case 2 -> BookingSystem.purchaseTicket();
            case 3 -> {
                System.out.println("Please enter your name");
                String name = sc.nextLine();
                BookingHistory.getBookingHistory(name); // Print out booking history
            }
        }
    }
}
