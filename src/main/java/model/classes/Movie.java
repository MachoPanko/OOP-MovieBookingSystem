package model.classes;
import model.enums.AgeRating;
import model.enums.MovieStatus;
import model.enums.MovieTag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;



public class Movie implements Serializable {

    private String movieTitle;
    private MovieTag movieTag;
    private MovieStatus movieStatus;
    private String movieSynopsis;
    private String movieDirector;
    private AgeRating ageRating;
    private ArrayList<String> casts;
    private double movieRating;
    private int numberOfRatings;
    private int ticketSales;
    private final ArrayList<Review> reviews;


    /**
     * Constructor for Movie class
     * @param movieTitle
     * @param movieTag
     * @param movieStatus
     * @param movieSynopsis
     * @param movieDirector
     * @param ageRating
     * @param casts
     */
    public Movie(String movieTitle,
                 MovieTag movieTag,
                 MovieStatus movieStatus,
                 String movieSynopsis,
                 String movieDirector,
                 AgeRating ageRating,
                 ArrayList<String> casts) {
        this.movieTitle = movieTitle;
        this.movieTag = movieTag;
        this.movieStatus = movieStatus;
        this.movieSynopsis = movieSynopsis;
        this.movieRating = 0;
        this.movieDirector = movieDirector;
        this.ageRating = ageRating;
        this.casts = casts;
        this.reviews = new ArrayList<>();
        this.numberOfRatings = 0;
    }

    /**
     * An array list which gets the reviews
     * @return reviews
     */
    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public int getTicketSales() { return ticketSales; }
    public void increaseTicketSales() { this.ticketSales++; }

    public void printReviews(){
        System.out.println(movieRating);
        for (Review r : this.reviews){
            System.out.println(r.getCustomerReview());
        }
    }

    public void updateReviews(Review newReview) {
        this.numberOfRatings++;
        this.movieRating = (this.movieRating*(numberOfRatings-1)+newReview.getCustomerRating())/numberOfRatings;
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

    public void setMovieRating(double movieRating) { this.movieRating = movieRating; }
    public double getMovieRating() { return movieRating; }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public void setAgeRating(AgeRating ageRating) {
        this.ageRating = ageRating;
    }

    public ArrayList<String> getCasts() {
        return casts;
    }
    public void setCasts(ArrayList<String> casts) { this.casts = casts; }

    @Override
    public String toString() {
        // cut short movieSynopsis for displaying
        StringBuilder sb = new StringBuilder();

        // print all of short or print 10 chars
        for(int i = 0; i < Math.min(movieSynopsis.length(), 20); ++i) {
            sb.append(movieSynopsis.charAt(i));
        }

        if(sb.length() <= movieSynopsis.length()) {
            sb.append("....");
        }

        return "Movie {" +
                "  movieTitle='" + movieTitle + '\'' +
                ", movieTag=" + movieTag +
                ", movieStatus=" + movieStatus +
                ", movieSynopsis='" + sb + '\'' +
                ", movieRating=" + String.format("%.2f", movieRating) +
                ", movieDirector='" + movieDirector + '\'' +
                ", ageRating=" + ageRating +
                ", casts=" + casts +
                ", reviews=" + reviews +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(movieTitle, movie.movieTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieTitle);
    }
}
