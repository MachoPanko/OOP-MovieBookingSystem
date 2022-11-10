package view;

import controller.DatabaseController;
import model.classes.Booking;
import model.classes.Review;

import java.util.ArrayList;

public class ReviewHistory {

        public static void getReviewHistory(String id){
            // load booking files from database
            ArrayList<Review> reviews = DatabaseController.loadReviews();
            for(Review r : reviews){
                    System.out.println(r.getCustomerReview());
            }
        }


}
