package view;

import java.util.Scanner;

public class MovieGoerMenu {
    public static void menu(){
        System.out.println("1) Movie Listing\n2) Book & purchase ticket\n3) View Booking History\n");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if(choice == "1"){
            MovieListing.listMovies(); // List out all movies
        }
        else if(choice == "2"){
            BookingSystem.purchaseTicket();
        }
        else if(choice == "3"){
            System.out.println("Please enter your name");
            String name = sc.nextLine();
            BookingHistory.getBookingHistory(name); // Print out booking history
        }
    }
}
