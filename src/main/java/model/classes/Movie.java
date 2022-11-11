package model.classes;
import static model.Main.SC;
import model.enums.AgeRating;
import model.enums.MovieStatus;
import model.enums.MovieTag;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {

    private String movieTitle;
    private MovieTag movieTag;
    private MovieStatus movieStatus;
    private String movieSynopsis;
    private double movieRating; //Overall Reviewer Rating of movie 0-5
    private String movieDirector;
    private AgeRating ageRating;
    private ArrayList<String> casts;

    private int numberOfRatings;
    private ArrayList<Review> reviews;

    //Still need to implement past reviews and reviewers rating

    public Movie(
                 String movieTitle,
                 MovieTag movieTag,
                 MovieStatus movieStatus,
                 String movieSynopsis,
                 double movieRating,
                 String movieDirector,
                 AgeRating ageRating,
                 ArrayList<String> casts) {

        this.movieTitle = movieTitle;
        this.movieTag = movieTag;
        this.movieStatus = movieStatus;
        this.movieSynopsis = movieSynopsis;
        this.movieRating = movieRating;
        this.movieDirector = movieDirector;
        this.ageRating = ageRating;
        this.casts = casts;
        this.reviews = new ArrayList<>();
        this.numberOfRatings = 0;
    }
    public ArrayList<Review> getReviews() {
        return reviews;
    }
    public void printReviews(){
        System.out.println(movieRating);
        for ( Review r : this.reviews){
            System.out.println(r.getCustomerReview());
        }
    }

    public void updateReviews(Review newReview) {
        this.numberOfRatings++;
        System.out.println("How many stars out of 5 would you rate this movie? : ");
        this.movieRating = (this.movieRating*(numberOfRatings-1)+SC.nextInt())/numberOfRatings;
        SC.nextLine();
        this.reviews.add(newReview);
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
                ", movieTitle='" + movieTitle + '\'' +
                ", movieTag=" + movieTag +
                ", movieStatus=" + movieStatus +
                ", movieSynopsis='" + movieSynopsis + '\'' +
                ", movieRating=" + movieRating +
                ", movieDirector='" + movieDirector + '\'' +
                ", ageRating=" + ageRating +
                ", casts=" + casts +
                ", reviews=" + reviews +
                '}';
    }
}
