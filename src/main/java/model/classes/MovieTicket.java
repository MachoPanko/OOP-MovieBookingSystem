package model.classes;

import model.enums.CinemaType;
import model.enums.DayType;

import java.io.Serializable;

/**
 * To make a MovieTicket object
 */

public class MovieTicket implements Serializable {
    private final Movie movie;
    private final CinemaType cinemaType;
    private final DayType dayType;
    private final int cinemaRoom;
    private final boolean isElderly;
    private final boolean isStudent;
    private final int seatRow;
    private final int seatCol;

    /**
     * Constructor for MovieTicket class
     * @param movie A Movie object
     * @param cinemaType An enum of cinemaType
     * @param dayType An enum of dayType
     * @param cinemaRoom The room number of the cinema
     * @param isElderly True if is an elderly and false if otherwise
     * @param isStudent True if is a student and false if otherwise
     * @param seatRow The row of the seat
     * @param seatCol The column of the seat
     */

    public MovieTicket(Movie movie,
                       CinemaType cinemaType,
                       DayType dayType,
                       boolean isStudent,
                       boolean isElderly,
                       int seatRow,
                       int seatCol,
                       int cinemaRoom) {
        this.movie = movie;
        this.cinemaType = cinemaType;
        this.dayType = dayType;
        this.isStudent = isStudent;
        this.isElderly = isElderly;
        this.seatCol = seatCol;
        this.seatRow = seatRow;
        this.cinemaRoom = cinemaRoom;
    }

    /**
     * Gets the movie object
     * @return movie
     */
    public Movie getMovie() { return movie; }

    /**
     * Gets the cinemaType enum
     * @return cinemaType
     */
    public CinemaType getCinemaType() { return cinemaType; }

    /**
     * Gets the dayType enum
     * @return dayType
     */
    public DayType getDayType() { return dayType; }

    /**
     * Checks if is elderly
     * @return true if is elderly, false otherwise
     */
    public boolean isElderly() { return isElderly; }

    /**
     * Checks if is student
     * @return true if is student, false otherwise
     */
    public boolean isStudent() { return isStudent; }

    /**
     * Overrides toString
     * @return String
     */
    @Override
    public String toString() {
        return "MovieTicket { movie=" + movie +
                ", cinemaType=" + cinemaType +
                ", dayType=" + dayType +
                ", hallNo=" + cinemaRoom +
                ", isElderly=" + isElderly +
                ", isStudent=" + isStudent +
                ", seatRow=" + seatRow +
                ", seatCol=" + seatCol +
                '}';
    }
}