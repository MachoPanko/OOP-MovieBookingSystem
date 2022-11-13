package model.classes;

import java.io.Serializable;
import java.util.ArrayList;


public class Cineplex implements Serializable {

    private final String cineplexName;
    private final ArrayList<Cinema> cinemaList;

    public Cineplex(String cineplexName) {
        this.cineplexName = cineplexName;
        cinemaList = new ArrayList<>();
    }

    /**
     * Constructor for Cineplex class
     * @param cineplexName The name of the cineplex
     * @param cinemaList
     */
    public Cineplex(String cineplexName, ArrayList<Cinema> cinemaList) {
        this.cineplexName = cineplexName;
        this.cinemaList = cinemaList;
    }

    public ArrayList<Cinema> getCinemaList() { return this.cinemaList; }
    public String getCineplexName() { return cineplexName; }

    @Override
    public String toString() {
        return "Cineplex{" +
                ", cineplexName='" + cineplexName + '\'' +
                ", cinemaList=" + cinemaList +
                '}';
    }
}
