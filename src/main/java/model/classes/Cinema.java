package model.classes;
import model.enums.CinemaType;

public class Cinema {
    private int cinemaCode;
    private Movie currentMovie;
    private Seating[][] seatingLayout;
    private CinemaType cinemaClass;
    private Showtime showTiming;
    public static final int ROWS = 10;
    public static final int COLS = 18;

    public Cinema(int cinemaCode, Movie currentMovie, CinemaType cinemaClass, Showtime showTiming){
        this.cinemaCode = cinemaCode;
        this.currentMovie = currentMovie;
        this.cinemaClass = cinemaClass;
        this.showTiming = showTiming;
        this.seatingLayout = new Seating[ROWS][COLS];
        for (int i = 0; i< ROWS; i++) {
            for(int j = 0; j< COLS; j++) {
                seatingLayout[i][j] = new Seating(i, j);
                if(i<4 && j<2){
                    seatingLayout[i][j].setToDisplay(false);
                }
                if(i>6){
                    if(i==9&&j>7&&j<10){
                        seatingLayout[i][j].setToDisplay(false);
                    }
                    else{
                        seatingLayout[i][j].setCoupleSeat(true);
                    }
                }
            }
        }
    }

    public int getCinemaCode() {
        return cinemaCode;
    }
    public void setCinemaCode(int cinemaCode) {
        this.cinemaCode = cinemaCode;
    }
    public Movie getCurrentMovie() {
        return currentMovie;
    }
    public void setCurrentMovie(Movie currentMovie) {
        this.currentMovie = currentMovie;
    }

    public Seating[][] getSeatingLayout() {
        return seatingLayout;
    }
    public void setSeatingLayout(Seating[][] seatingLayout) {
        this.seatingLayout = seatingLayout;
    }
    public void bookSeating(int row, int col){
        seatingLayout[row][col].occupySeat();
    }
    public void unbookSeating(int row, int col){
        seatingLayout[row][col].unOccupySeat();
    }
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
        System.out.println("  1   2   3   4   5   6   7   8   9   10   11   12   13   14   15   16   17   18");
        for (int i = 0; i< ROWS; i++) {
            int asciiRow = 74-i; // Ascii for J to A
            System.out.printf(i + " ");
            for(int j = 0; j< COLS; j++) {
                if(seatingLayout[i][j].isToDisplay()){
                    if(seatingLayout[i][j].isCoupleSeat()){

                        if(!seatingLayout[i][j].isOccupied()){
                            System.out.print("[  |  ] ");
                        }
                        else{
                            System.out.print("[ x|x ] ");
                        }
                        j++;
                    }
                    else{
                        if(!seatingLayout[i][j].isOccupied()){
                            System.out.print("[ ] ");
                        }
                        else{
                            System.out.print("[X] ");
                        }
                    }

                }
                else{
                    System.out.print("    ");
                }
            }
            System.out.println((char)asciiRow + "");
            System.out.println("____________________________________________________________________________");
        }
    }



}
