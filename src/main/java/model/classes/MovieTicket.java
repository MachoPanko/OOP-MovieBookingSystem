package model.classes;

import model.enums.CinemaType;
import model.enums.DayType;

import java.io.Serializable;

public class MovieTicket implements Serializable {
    private int movieGoerid;
    private Movie movie;
    private CinemaType cinemaType;
    private int movieGoerAge;
    private DayType dayType;

    public MovieTicket(int movieGoerid, Movie movie, CinemaType cinemaType, int movieGoerAge, DayType dayType){
        this.movieGoerid = movieGoerid;
        this.movie = movie;
        this.cinemaType = cinemaType;
        this.movieGoerAge = movieGoerAge;
        this.dayType = dayType;

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

    public int getMovieGoerid() {
        return movieGoerid;
    }

    public void setMovieGoerid(int movieGoerid) {
        this.movieGoerid = movieGoerid;
    }
}
