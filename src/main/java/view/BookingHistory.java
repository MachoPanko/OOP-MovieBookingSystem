package view;

import controller.DatabaseController;
import model.classes.Booking;

import java.util.ArrayList;

public class BookingHistory {
        public static void getBookingHistory(String id){
            // load booking files from database
            ArrayList<Booking> bookings = DatabaseController.loadBookings();
            for(Booking b : bookings){
                if(b.getMovieGoer().getCustomerId() == id){
                    System.out.println(b);
                }
            }
        }
}
