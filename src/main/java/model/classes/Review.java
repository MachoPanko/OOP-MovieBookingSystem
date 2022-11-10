package model.classes;

import java.io.Serializable;

public class Review implements Serializable {
    private MovieGoer customer;
    private String customerReview;
    private double customerRating;

    public Review(MovieGoer customer, String customerReview, double customerRating){
        this.customer = customer;
        this.customerReview = customerReview;
        this.customerRating = customerRating;
    }

    public MovieGoer getCustomer() {
        return customer;
    }

    public void setCustomer(MovieGoer customer) {
        this.customer = customer;
    }

    public String getCustomerReview() {
        return customerReview;
    }

    public void setCustomerReview(String customerReview) {
        this.customerReview = customerReview;
    }

    public double getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(double customerRating) {
        this.customerRating = customerRating;
    }
}
