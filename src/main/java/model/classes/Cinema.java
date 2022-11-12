package model.classes;
import model.enums.CinemaType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

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

    public Cinema(int cinemaCode, CinemaType cinemaClass){
        this.cinemaCode = cinemaCode;
        this.cinemaClass = cinemaClass;
        this.showTiming = new Showtime();
        this.seatingLayout = new boolean[this.showTiming.TIME.length][ROWS][COLS];
        this.moviesShown = new Movie[this.showTiming.TIME.length];
    }

    public int getCinemaCode() {
        return cinemaCode;
    }
    public boolean[][][] getSeatingLayout() {
        return seatingLayout;
    }

    public void bookSeating(int timingIdx, int row, int col){ seatingLayout[timingIdx][row][col] = true; }
    public CinemaType getCinemaClass() { return cinemaClass; }
    public Showtime getShowTiming() { return showTiming; }

    public void display(int timingIdx){
        System.out.println("                                    Screen                                          \n ");
        for (int i = 0; i < ROWS; ++i) {
            System.out.print(i + "\t");
        }
        System.out.println();

        for(int i = 0; i < ROWS; ++i) {
            for(int j = 0; j < COLS; ++j) {
                if(this.seatingLayout[timingIdx][i][j])
                    System.out.print("[X]");
                else
                    System.out.print("[ ]");
            }
            System.out.println();
        }
    }

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
                ", moviesShown=[" + sb.toString() + "]" +
                '}';
    }
}
