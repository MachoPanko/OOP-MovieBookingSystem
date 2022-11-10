package model.classes;

import model.enums.AgeRating;
import model.enums.MovieStatus;
import model.enums.MovieTag;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
    private String movieId;
    private String movieTitle;
    private MovieTag movieTag;
    private MovieStatus movieStatus;
    private String movieSynopsis;
    private double movieRating; //Overall Reviewer Rating of movie 0-5
    private String movieDirector;
    private AgeRating ageRating;
    private ArrayList<String> casts;

    //Still need to implement past reviews and reviewers rating

    public Movie(String movieId,
                 String movieTitle,
                 MovieTag movieTag,
                 MovieStatus movieStatus,
                 String movieSynopsis,
                 double movieRating,
                 String movieDirector,
                 AgeRating ageRating,
                 ArrayList<String> casts) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.movieTag = movieTag;
        this.movieStatus = movieStatus;
        this.movieSynopsis = movieSynopsis;
        this.movieRating = movieRating;
        this.movieDirector = movieDirector;
        this.ageRating = ageRating;
        this.casts = casts;
    }

    public String getMovieId() {
        return movieId;
    }
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
    public String getMovieTitle() {
        return movieTitle;
    }
    public void setMovieTag(MovieTag movieTag) {
        this.movieTag = movieTag;
    }
    public MovieTag getMovieTag() {
        return movieTag;
    }
    public void setMovieStatus(MovieStatus movieStatus) {
        this.movieStatus = movieStatus;
    }
    public MovieStatus getMovieStatus() {
        return movieStatus;
    }
    public void setMovieSynopsis(String movieSynopsis) {
        this.movieSynopsis = movieSynopsis;
    }
    public String getMovieSynopsis() {
        return movieSynopsis;
    }
    public void setMovieRating(double movieRating) {
        this.movieRating = movieRating;
    }
    public double getMovieRating() {
        return movieRating;
    }
    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }
    public String getMovieDirector() {
        return movieDirector;
    }
    public void setAgeRating(AgeRating ageRating) {
        this.ageRating = ageRating;
    }
    public AgeRating getAgeRating() {
        return ageRating;
    }
    public ArrayList<String> getCasts() {
        return casts;
    }
    public void setCasts(ArrayList<String> casts) {
        this.casts = casts;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                ", movieTag=" + movieTag +
                ", movieStatus=" + movieStatus +
                ", movieSypnosis='" + movieSynopsis + '\'' +
                ", movieRating='" + movieRating + '\'' +
                ", movieDirector='" + movieDirector + '\'' +
                ", ageRating=" + ageRating +
                ", casts=" + casts +
                '}';
    }
}
