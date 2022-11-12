package model.classes;
import model.enums.CinemaType;

public class Cinema {
    private final String cinemaCode;
    private Movie currentMovie;
    private boolean[][] seatingLayout;
    private CinemaType cinemaClass;
    private Showtime showTiming;
    public static final int ROWS = 10;
    public static final int COLS = 18;

    public Cinema(String cinemaCode, Movie currentMovie, CinemaType cinemaClass, Showtime showTiming){
        this.cinemaCode = cinemaCode;
        this.currentMovie = currentMovie;
        this.cinemaClass = cinemaClass;
        this.showTiming = showTiming;
        this.seatingLayout = new boolean[ROWS][COLS];
    }

    public String getCinemaCode() {
        return cinemaCode;
    }
    public Movie getCurrentMovie() {
        return currentMovie;
    }
    public void setCurrentMovie(Movie currentMovie) {
        this.currentMovie = currentMovie;
    }
    public boolean[][] getSeatingLayout() {
        return seatingLayout;
    }

    public void setSeatingLayout(boolean[][] seatingLayout) {
        this.seatingLayout = seatingLayout;
    }
    public void bookSeating(int row, int col){ seatingLayout[row][col] = true; }
    public CinemaType getCinemaClass() {
        return cinemaClass;
    }
    public void setCinemaClass(CinemaType cinemaClass) {
        this.cinemaClass = cinemaClass;
    }
    public Showtime getShowTiming() {
        return showTiming;
    }
    public void setShowTiming(Showtime showTiming) {
        this.showTiming = showTiming;
    }

    public void printSeatingLayout(){
        System.out.println("                                    Screen                                          ");
        for (int i = 0; i < COLS; ++i) {
            System.out.print(i + "\t");
        }

        for(int i = 0; i < COLS; ++i) {
            for(int j = 0; j < ROWS; ++j) {
                if(this.seatingLayout[i][j])
                    System.out.println("[X]");
                else
                    System.out.println("[ ]");
            }
            System.out.println();
        }
    }
}
