package controller;

import model.classes.Booking;
import model.classes.Movie;
import model.classes.MovieTicket;
import model.enums.CinemaType;
import model.enums.DayType;
import model.enums.MovieTag;

import static model.enums.DayType.*;
import static model.enums.MovieTag.THREED;

public class PricingController {
    // nvr take into consideration cinematype
    public static double getPrice(MovieTicket movieTicket,double time){
        double price = 0.0;
        boolean isStudent = movieTicket.isStudent();
        boolean isElderly = movieTicket.isElderly();
        double bookingTime =time;
        MovieTag movieTag = movieTicket.getMovie().getMovieTag();
        DayType dayType = movieTicket.getDayType();
        boolean isSixpm = false;
        if(bookingTime > 18.00){
            isSixpm = true;
        }

        if(movieTag != THREED) {
            if(isElderly == true && dayType != HOLIDAY && isSixpm == false){
                price = 4.00;
            }
            else if(isStudent == true && dayType != HOLIDAY && isSixpm != true){
                price = 7.00;
            }
            else if (dayType == FRIDAY) {
                if (isSixpm == false) {
                    price = 9.50;
                } else {
                    price = 11.00;
                }


            } else if (dayType == THURSDAY) {
                price = 9.50;
            } else if (dayType == WEEKDAY) {
                price = 8.50;
            } else if (dayType == WEEKEND) {
                price = 11.00;
            }
        } else if (movieTag == THREED) {
            if(isStudent == true && dayType != HOLIDAY && isSixpm != true){
                price = 9.00;
            } else if (dayType == FRIDAY) {
                price = 15.00;
            } else if (dayType == WEEKDAY || dayType == THURSDAY) {
                price = 11.00;
            } else if (dayType == WEEKEND) {
                price = 15.00;
            }
        }
        return price;
    }
}
