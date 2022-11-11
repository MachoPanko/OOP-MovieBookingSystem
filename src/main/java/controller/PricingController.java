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
    public static double getPrice(MovieTicket movieTicket, String time){
        double price = 0.0;
        double costOfCinemaType = 1;
        //adjust cost based on cinema Type
        if(movieTicket.getCinemaType() == CinemaType.IMAX){
            costOfCinemaType = 1.3;
        } else if (movieTicket.getCinemaType() == CinemaType.Platinum) {
            costOfCinemaType = 1.5;
        }

        boolean isStudent = movieTicket.isStudent();
        boolean isElderly = movieTicket.isElderly();
        double bookingTime = Double.parseDouble(time) / 100.0;
        MovieTag movieTag = movieTicket.getMovie().getMovieTag();
        DayType dayType = movieTicket.getDayType();
        boolean isSixpm = bookingTime >= 18.00;

        if(movieTag != THREED) {
            if(isElderly && dayType != HOLIDAY && !isSixpm){
                price = 4.00;
            }
            else if(isStudent && dayType != HOLIDAY && !isSixpm){
                price = 7.00;
            }
            else if (dayType == FRIDAY) {
                if (!isSixpm) {
                    price = 9.50;
                } else {
                    price = 11.00;
                }
            } else if (dayType == THURSDAY) {
                price = 9.50;
            } else if (dayType == WEEKDAY) {
                price = 8.50;
            } else if (dayType == WEEKEND || dayType == HOLIDAY) {
                price = 11.00;
            }
        } else {
            if(isStudent && dayType != HOLIDAY && !isSixpm){
                price = 9.00;
            } else if (dayType == FRIDAY) {
                price = 15.00;
            } else if (dayType == WEEKDAY || dayType == THURSDAY) {
                price = 11.00;
            } else if (dayType == WEEKEND || dayType == HOLIDAY) {
                price = 15.00;
            }
        }
        return price * costOfCinemaType;
    }
}
