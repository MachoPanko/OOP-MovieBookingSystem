package model.classes;
import model.enums.CinemaType;

import java.util.ArrayList;

public class Cinema {
    private int cinemaCode;
    private Movie currentMovie;
    private Seating[][] seatingLayout;
    private CinemaType cinemaClass;
    private int[] showTiming;
    public int rows = 10;
    public int columns = 18;

    public Cinema(int cinemaCode, Movie currentMovie, CinemaType cinemaClass, int[] showTiming){
        this.cinemaCode = cinemaCode;
        this.currentMovie = currentMovie;
        this.cinemaClass = cinemaClass;
        this.showTiming = showTiming;
        this.seatingLayout = new Seating[rows][columns];
        for (int i = 0; i< this.rows; i++) {
            for(int j=0; j< this.columns; j++) {
                seatingLayout[i][j] = new Seating(i, j);
            }
        }
    }
    public void printSeatingLayout(){

        System.out.println("                                    Screen                                          ");
        System.out.println("   1    2   3   4   5   6   7   8   9   10   11   12   13   14   15   16   17   18");
        for (int i = 0; i< this.rows; i++) {
            int asciiRow = 74-i; // Ascii for J to A
            System.out.printf((char)asciiRow + " ");
            for(int j=0; j< this.columns; j++) {
                if(seatingLayout[i][j].isOccupied()==false){
                    System.out.printf("[ ] ");
                }
                else{
                    System.out.print("[X] ");
                }
            }
            System.out.println((char)asciiRow + "");
            System.out.println("____________________________________________________________________________");
        }
    }

}
