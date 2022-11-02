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
    private String movieSypnosis;
    private String movieRating; //Overall Reviewer Rating of movie 0-5
    private String movieDirector;
    private AgeRating ageRating;
    private ArrayList<String> casts;

    //Still need to implement past reviews and reviewers rating

    public Movie(String movieId,String movieTitle, MovieTag movieTag, MovieStatus movieStatus, String movieSypnosis, String movieRating, String movieDirector, AgeRating ageRating, ArrayList<String> casts){
            this.movieId = movieId;
            this.movieTitle = movieTitle;
            this.movieTag = movieTag;
            this.movieStatus = movieStatus;
            this.movieSypnosis = movieSypnosis;
            this.movieRating = movieRating;
            this.movieDirector = movieDirector;
            this.ageRating = ageRating;
            this.casts = new ArrayList<String>();
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

    public void setMovieSypnosis(String movieSypnosis) {
        this.movieSypnosis = movieSypnosis;
    }

    public String getMovieSypnosis() {
        return movieSypnosis;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public String getMovieRating() {
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
    public String toString(){
        StringBuilder build = new StringBuilder();
        build.append("ID: "); build.append(this.getMovieId()); build.append("\n");
        build.append("Title: "); build.append(this.getMovieTitle()); build.append("\n");
        build.append("Director: "); build.append(this.getMovieDirector()); build.append("\n");
        build.append("Casts: "); build.append(this.getCasts()); build.append("\n");
        build.append("Tag: "); build.append(this.getMovieTag()); build.append("\n");
        build.append("Status: "); build.append(this.getMovieStatus()); build.append("\n");
        build.append("Age Rating: "); build.append(this.getAgeRating()); build.append("\n");
        build.append("Movie Rating: "); build.append(this.getMovieRating()); build.append("\n");
        build.append("Sypnosis: "); build.append(this.getMovieSypnosis()); build.append("\n");
        return build.toString();
    }
}
