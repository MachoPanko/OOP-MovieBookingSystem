package model.classes;

import java.io.Serializable;

public class Review implements Serializable {
    private final MovieGoer customer;
    private final String customerReview;
    private final double customerRating;

    public Review(MovieGoer customer, String customerReview, double customerRating){
        this.customer = customer;
        this.customerReview = customerReview;
        this.customerRating = customerRating;
    }

    public MovieGoer getCustomer() {
        return customer;
    }
    public String getCustomerReview() {
        return customerReview;
    }
    public double getCustomerRating() {
        return customerRating;
    }
}
