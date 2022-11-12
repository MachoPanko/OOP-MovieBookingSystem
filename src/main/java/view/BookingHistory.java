package view;


import model.classes.MovieGoer;

import static model.Main.VIEW_STATE;

public class BookingHistory {
    public static void display() {
        System.out.println("You bookings!");
        MovieGoer m = (MovieGoer) VIEW_STATE.getCurrUser();
        m.getBookings().forEach(System.out::println);
        VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);
    }
}
