package model.classes;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class Cineplex {
    private int cineplexID;

    private final ArrayList<Movie> movieList;
    private final ArrayList<Cinema> cinemaList;

    Cineplex(int cineplexID) {
        this.cineplexID = cineplexID;
        movieList = new ArrayList<>();
        cinemaList = new ArrayList<>();
    }

    Cineplex(int cineplexID, ArrayList<Movie> movieList, ArrayList<Cinema> cinemaList) {
        this.cineplexID = cineplexID;
        this.movieList = movieList;
        this.cinemaList = cinemaList;
    }

    public boolean addMovie(Movie newMovie) { return this.movieList.add(newMovie); }
    public boolean removeMovieByIndex(int index) { return this.movieList.remove(index) != null; }
    public boolean removeMovieByMovie(Movie movie) { return this.movieList.remove(movie); }
    public ArrayList<Cinema> getCinemaList() { return this.cinemaList; }
    public int getCineplexID() { return cineplexID; }
    public ArrayList<Movie> getMovieList() { return movieList; }
    public void setCineplexID(int cineplexID) { this.cineplexID = cineplexID; }
}
