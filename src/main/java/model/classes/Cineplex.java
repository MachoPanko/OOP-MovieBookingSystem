package model.classes;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class Cineplex {
    private int cineplexID;
    private ArrayList<Movie> movieList;

    Cineplex(int cineplexID){
        this.cineplexID = cineplexID;
        movieList = new ArrayList<>();
    }
    Cineplex(int cineplexID , ArrayList<Movie> movieList){
        this.cineplexID = cineplexID;
        this.movieList = movieList;
    }
    public boolean addMovie (Movie newMovie){
        return this.movieList.add(newMovie);
    }
    public boolean removeMoviebyIndex(int index){
        return this.movieList.remove(index) != null;
    }
    public boolean removeMoviebyMovie(Movie movie){
        return this.movieList.remove(movie);
    }

    public int getCineplexID() {
        return cineplexID;
    }

    public void setCineplexID(int cineplexID) {
        this.cineplexID = cineplexID;
    }
}
