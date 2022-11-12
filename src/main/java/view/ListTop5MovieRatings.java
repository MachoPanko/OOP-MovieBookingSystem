package view;


import controller.MovieController;
import model.classes.Review;

import java.util.ArrayList;
import java.util.HashMap;

import static controller.MovieController.MOVIES;

public class ListTop5MovieRatings {

    public static void display(){

        HashMap<String,Double> movieRatingsSum = new HashMap<String,Double>();

        HashMap<String,Double> movieRatingsAvg = new HashMap<String,Double>();

        MOVIES.forEach((movieName, movie) -> {
            double sum = 0;
            double avg = 0;
            for(Review r : movie.getReviews())
            {
                sum += r.getCustomerRating();
            }
            avg = sum / movie.getReviews().size();
            movieRatingsAvg.put(movieName,avg);
        });

        String[] max_rating_movies = new String[MOVIES.size()];
        Double[] max_ratings = new Double[MOVIES.size()];

        int counter = 0;

        for(String m : movieRatingsAvg.keySet()){
            if(counter < MOVIES.size()){
                max_rating_movies[counter] = m;
                max_ratings[counter] = movieRatingsAvg.get(m);

            }
        }

        for(int i = 1; i < MOVIES.size(); ++i){
            Double key = max_ratings[i];
            int j = i - 1;
            while(j >= 0 && max_ratings[j] > key){
                max_ratings[j+1] = max_ratings[j];
                j = j-1;
            }
            max_ratings[j+1] = key;
        }

        for (int i = 0; i < MOVIES.size(); ++i)
            System.out.print(max_ratings[i] + " ");

        System.out.println();

//            else{
//                int min_ind = 0;
//                double min = max_ratings[min_ind];
//                for(int i = 0; i < MOVIES.size(); i++){
//                    if(max_ratings[i] < min){
//                        min_ind = i;
//                        min =  max_ratings[i];
//                    }
//                }
//                if(movieRatingsAvg.get(m) > min){
//                    max_rating_movies[min_ind] = m;
//                    max_ratings[min_ind] = movieRatingsAvg.get(m);
//                }
//            }
//        System.out.println("-----------------------------------");
//        System.out.println("Top 5 movies according to rating");
//        System.out.println("-----------------------------------");
//
//        //remaining printing
//        for(int i = 0; i < 5; i++) {
//            System.out.print(max_rating_movies[i] + " : ");
//            System.out.printf("%.2f", max_ratings[i]); System.out.println();
//        }
//        System.out.println();

    }
}
