package model.classes;
import model.enums.CinemaType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * To make a Cinema object
 */

public class Cinema implements Serializable {
    public static final int ROWS = 10;
    public static final int COLS = 18;

    private final int cinemaCode;
    /**
     * Each Timing requires their own seating layout
     */
    private boolean[][][] seatingLayout;
    private final CinemaType cinemaClass;
    private final Showtime showTiming;
    private final Movie[] moviesShown;

    /**
     * Constructor for Cinema class
     * @param cinemaCode The individual code number that the cinema belongs to
     * @param cinemaClass A CinemaType enum
     */
    public Cinema(int cinemaCode, CinemaType cinemaClass){
        this.cinemaCode = cinemaCode;
        this.cinemaClass = cinemaClass;
        this.showTiming = new Showtime();
        this.seatingLayout = new boolean[this.showTiming.TIME.length][ROWS][COLS];
        this.moviesShown = new Movie[this.showTiming.TIME.length];
    }

    /**
     * Gets the cinema code
     * @return cinemaCode
     */
    public int getCinemaCode() {
        return cinemaCode;
    }

    /**
     * Gets the seating layout
     * @return seatingLayout
     */
    public boolean[][][] getSeatingLayout() {
        return seatingLayout;
    }

    /**
     * This method is to book seats
     * @param timingIdx
     * @param row The row of where the seat is
     * @param col The column of where the seat is
     */
    public void bookSeating(int timingIdx, int row, int col){ seatingLayout[timingIdx][row][col] = true; }

    /**
     * Gets the cinema class
     * @return cinemaClass
     */
    public CinemaType getCinemaClass() { return cinemaClass; }

    /**
     * Gets the show timing
     * @return showTiming
     */
    public Showtime getShowTiming() { return showTiming; }

    /**
     * This method displays the layout of the seatings
     * @param timingIdx The index of the movie timing
     */

    public void display(int timingIdx){
        System.out.print("                                    Screen                                          \n ");
        for (int i = 0; i < COLS; ++i) {

            if(i > 9) {
                System.out.print(i + " ");
            } else if(i == 9) {
                System.out.print("  " + i + " ");
            } else {
                System.out.print("  " + i);
            }

        }
        System.out.println();

        for(int i = 0; i < ROWS; ++i) {
            System.out.print(i + " ");
            for(int j = 0; j < COLS; ++j) {
                if(this.seatingLayout[timingIdx][i][j])
                    System.out.print("[X]");
                else
                    System.out.print("[ ]");
            }
            System.out.println();
        }
    }

    /**
     * Sets the movies shown
     * @param m A movie object
     * @param idx The index of the movies shown
     */
    public void setMoviesShown(Movie m, int idx){
        this.moviesShown[idx] = m;
    }
    public Movie[] getMoviesShown() { return this.moviesShown; }

    public ArrayList<Movie> getMoviesShownFiltered() {
        ArrayList<Movie> movies = new ArrayList<>();
        for (Movie movie : this.moviesShown) {
            if(movie != null) {
                movies.add(movie);
            }
        }

        return movies;
    }

    /**
     * Overrides toString
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Movie movie : this.moviesShown) {
            if(movie != null) {
                sb.append(movie.getMovieTitle());
            } else {
                sb.append("NA");
            }
            sb.append(",");
        }

        return "Cinema{" +
                "cinemaCode=" + cinemaCode +
                ", cinemaClass=" + cinemaClass +
                ", showTiming=" + showTiming +
                ", moviesShown=[" + sb + "]" +
                '}';
    }
}
