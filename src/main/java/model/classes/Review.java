package model.classes;

import java.io.Serializable;

/**
 * To make a Review object
 */

public class Review implements Serializable {
    private final MovieGoer customer;
    private final String customerReview;
    private final double customerRating;

    /**
     * Constructor for Review class
     * @param customer A MovieGoer object
     * @param customerReview The review that the customer gives to the movie
     * @param customerRating The rating that the customer gives to the movie
     */
    public Review(MovieGoer customer, String customerReview, double customerRating){
        this.customer = customer;
        this.customerReview = customerReview;
        this.customerRating = customerRating;
    }

    /**
     * Gets the MovieGoer object
     * @return customer
     */
    public MovieGoer getCustomer() {
        return customer;
    }

    /**
     * Gets the customer review
     * @return customerReview
     */
    public String getCustomerReview() {
        return customerReview;
    }

    /**
     * Gets the customer rating
     * @return customerRating
     */
    public double getCustomerRating() {
        return customerRating;
    }

    /**
     * Overrides toString
     * @return String
     */
    @Override
    public String toString() {
        return "Review{" +
                "customer=" + customer +
                ", customerReview='" + customerReview + '\'' +
                ", customerRating=" + String.format("%.2f", customerRating) +
                '}';
    }
}
