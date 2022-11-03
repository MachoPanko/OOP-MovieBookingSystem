package model.classes;


import model.classes.Movie;
import model.enums.CinemaType;
import model.enums.DayType;

import java.io.Serializable;

public class MovieTicket implements Serializable {
    private Movie movie;
    private CinemaType cinemaType;
    private int movieGoerAge;
    private DayType dayType;
    private boolean isStudent;

    public MovieTicket( Movie movie, CinemaType cinemaType, int movieGoerAge, DayType dayType, boolean isStudent){
        this.movie = movie;
        this.cinemaType = cinemaType;
        this.movieGoerAge = movieGoerAge;
        this.dayType = dayType;
        this.isStudent = isStudent;
    }

    public boolean getStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public CinemaType getCinemaType() {
        return cinemaType;
    }

    public void setCinemaType(CinemaType cinemaType) {
        this.cinemaType = cinemaType;
    }

    public int getMovieGoerAge() {
        return movieGoerAge;
    }

    public void setMovieGoerAge(int movieGoerAge) {
        this.movieGoerAge = movieGoerAge;
    }

    public DayType getDayType() {
        return dayType;
    }

    public void setDayType(DayType dayType) {
        this.dayType = dayType;
    }

}
