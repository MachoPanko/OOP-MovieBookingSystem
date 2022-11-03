package model.classes;

import model.enums.CinemaType;
import model.enums.DayType;
import java.io.Serializable;

public class MovieTicket implements Serializable {
    private Movie movie;
    private CinemaType cinemaType;
    private Cinema cinemaRoom;
    private int movieGoerAge;
    private DayType dayType;

    public MovieTicket( Movie movie, CinemaType cinemaType, Cinema cinemaRoom, int movieGoerAge, DayType dayType){
        this.movie = movie;
        this.cinemaType = cinemaType;
        this.cinemaRoom = cinemaRoom;
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

    public Cinema getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(Cinema cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
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
