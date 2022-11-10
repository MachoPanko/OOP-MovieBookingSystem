package view;

import model.enums.AgeRating;
import model.classes.Movie;
import controller.*;
import model.enums.MovieStatus;
import model.enums.MovieTag;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieCreation {

    public static void createMovie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID of movie:");
        String movieId = sc.nextLine();

        System.out.println("Enter title of movie:");
        String movieTitle = sc.nextLine();

        System.out.println("Enter name of director:");
        String director = sc.nextLine();

        ArrayList<String> casts = new ArrayList<>();
        System.out.println("Enter number of casts:");
        int noCast = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < noCast; ++i) {
            System.out.println("Enter cast name:");
            String castName = sc.nextLine();
            casts.add(castName);
        }

        System.out.println("Enter Age Rating:");
        System.out.println("G, PG, PG13, NC17");
        String ageRatingChoice = sc.nextLine();
        AgeRating ageRating = AgeRating.getRating(ageRatingChoice);

        System.out.println("Enter Movie Tag:");
        System.out.println("Blockbuster, Normal, 3D");
        String tagChoice = sc.nextLine();
        MovieTag movieTag = MovieTag.getMovieTag(tagChoice);

        System.out.println("Enter Movie Status:");
        System.out.println("Coming_Soon, Preview, Now_Showing");
        String statusChoice = sc.nextLine();
        MovieStatus movieStatus = MovieStatus.getMovieStatus(statusChoice);

        System.out.println("Enter Movie Rating (0-5):");
        double movieRating = Double.parseDouble(sc.nextLine());

        System.out.println("Enter Synopsis:");
        String synopsis = sc.nextLine();

        Movie movie = new Movie(movieId,
                movieTitle,
                movieTag,
                movieStatus,
                synopsis,
                movieRating,
                director,
                ageRating,
                casts
        );

        DatabaseController.saveMovieData(movie);
    }
}
