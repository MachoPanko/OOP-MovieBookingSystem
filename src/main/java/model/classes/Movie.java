package model.classes;
import model.enums.AgeRating;
import model.enums.MovieStatus;
import model.enums.MovieTag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * To make a Movie object
 */

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
     * @param movieTitle The title of the movie
     * @param movieTag
     * @param movieStatus
     * @param movieSynopsis
     * @param movieDirector
     * @param ageRating
     * @param casts An array of cast names
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

    /**
     * Gets the ticket sales
     * @return tickeSales
     */
    public int getTicketSales() { return ticketSales; }

    /**
     * Increases the ticket sales
     */
    public void increaseTicketSales() { this.ticketSales++; }

    /**
     * Prints the reviews
     */
    public void printReviews(){
        System.out.println(movieRating);
        for (Review r : this.reviews){
            System.out.println(r.getCustomerReview());
        }
    }

    /**
     * Updates the reviews
     * @param newReview A Review object
     */
    public void updateReviews(Review newReview) {
        this.numberOfRatings++;
        this.movieRating = (this.movieRating*(numberOfRatings-1)+newReview.getCustomerRating())/numberOfRatings;
        this.reviews.add(newReview);
    }

    /**
     * Sets the movie title
     * @param movieTitle The title of the movie
     */

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    /**
     * Gets the movie title
     * @return movieTitle
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     * Sets the movie tag
     * @param movieTag An enum of movie tags
     */
    public void setMovieTag(MovieTag movieTag) {
        this.movieTag = movieTag;
    }

    /**
     * Gets the movie tag
     * @return movieTag
     */
    public MovieTag getMovieTag() {
        return movieTag;
    }

    /**
     * Sets the movie status
     * @param movieStatus An enum of movie status
     */

    public void setMovieStatus(MovieStatus movieStatus) {
        this.movieStatus = movieStatus;
    }

    /**
     * Gets the movie status
     * @return movieStatus
     */
    public MovieStatus getMovieStatus() {
        return movieStatus;
    }

    /**
     * Sets the movie sypnosis
     * @param movieSynopsis The sypnosis of the movie
     */
    public void setMovieSynopsis(String movieSynopsis) {
        this.movieSynopsis = movieSynopsis;
    }

    /**
     * Gets the movie sypnosis
     * @return movieSypnosis
     */
    public String getMovieSynopsis() {
        return movieSynopsis;
    }

    /**
     * Sets the movie rating
     * @param movieRating The rating of the movie
     */

    public void setMovieRating(double movieRating) { this.movieRating = movieRating; }

    /**
     * Gets the movie rating
     * @return movieRating
     */
    public double getMovieRating() { return movieRating; }

    /**
     * Sets the director of the movie
     * @param movieDirector the movie director
     */
    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    /**
     * Sets the age rating
     * @param ageRating age rating of the movie
     */
    public void setAgeRating(AgeRating ageRating) {
        this.ageRating = ageRating;
    }

    /**
     * An array list of casts
     * @return casts
     */
    public ArrayList<String> getCasts() {
        return casts;
    }

    /**
     *Sets the array of casts
     * @param casts An array of casts
     */
    public void setCasts(ArrayList<String> casts) { this.casts = casts; }

    /**
     * Overrides toString
     * @return String
     */
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

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(movieTitle, movie.movieTitle);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(movieTitle);
    }
}
