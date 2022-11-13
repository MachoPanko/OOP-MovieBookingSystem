package model.classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *  To make a Cineplex object
 */
public class Cineplex implements Serializable {

    private final String cineplexName;
    private final ArrayList<Cinema> cinemaList;

    /**
     * Constructor for Cineplex class
     * @param cineplexName The name of the cineplex
     */
    public Cineplex(String cineplexName) {
        this.cineplexName = cineplexName;
        cinemaList = new ArrayList<>();
    }

    /**
     * Constructor for Cineplex class
     * @param cineplexName The name of the cineplex
     * @param cinemaList An array of Cinema object
     */
    public Cineplex(String cineplexName, ArrayList<Cinema> cinemaList) {
        this.cineplexName = cineplexName;
        this.cinemaList = cinemaList;
    }

    /**
     * Gets an array of cinema objects
     * @return cinemaList
     */

    public ArrayList<Cinema> getCinemaList() { return this.cinemaList; }

    /**
     * Gets the cineplex name
     * @return cineplexName
     */
    public String getCineplexName() { return cineplexName; }

    /**
     * Overrides toString
     * @return String
     */
    @Override
    public String toString() {
        return "Cineplex{" +
                ", cineplexName='" + cineplexName + '\'' +
                ", cinemaList=" + cinemaList +
                '}';
    }
}
