package view;

import controller.DatabaseController;
import model.enums.AgeRating;
import model.classes.Movie;
import model.enums.MovieStatus;
import model.enums.MovieTag;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieUpdate {

    public static void updateMovie(){
        System.out.println("Enter the ID of the movie to update");
        Scanner sc = new Scanner(System.in);

        String movieId = sc.nextLine();

        ArrayList<Movie> movies = DatabaseController.loadMovieData();

        for(Movie m : movies){
            if(movieId.equals(m.getMovieId())){

                System.out.println("What do you want to update?");
                System.out.println("""
                        1) Title
                        2) Director
                        3) Casts
                        4) Movie Tag
                        5) Status
                        6)Age Rating
                        7)Movie Rating
                        8)Synopsis""");

                int updateChoice = sc.nextInt();
                sc.nextLine();

                switch (updateChoice) {
                    case 1 -> {
                        System.out.println("Update movie title:");
                        String titleUpdate = sc.nextLine();
                        m.setMovieTitle(titleUpdate);
                    }
                    case 2 -> {
                        System.out.println("Update movie director:");
                        String directorUpdate = sc.nextLine();
                        m.setMovieDirector(directorUpdate);
                    }
                    case 3 -> {
                        System.out.println("Update movie casts");
                        ArrayList<String> casts = new ArrayList<>();
                        System.out.println("Enter number of casts:");
                        int noCast = Integer.parseInt(sc.nextLine());

                        for (int i = 0; i < noCast; ++i) {
                            System.out.println("Enter cast name:");
                            String castName = sc.nextLine();
                            casts.add(castName);
                        }

                        m.setCasts(casts);
                    }
                    case 4 -> {
                        System.out.println("Update movie tag");
                        System.out.println("Blockbuster, Normal, 3D");
                        String tagChoice = sc.nextLine();
                        MovieTag movieTag = MovieTag.getMovieTag(tagChoice);
                        m.setMovieTag(movieTag);
                    }
                    case 5 -> {
                        System.out.println("Update movie status");
                        System.out.println("Coming_Soon, Preview, Now_Showing");
                        String statusChoice = sc.nextLine();
                        MovieStatus movieStatus = MovieStatus.getMovieStatus(statusChoice);
                        m.setMovieStatus(movieStatus);
                    }
                    case 6 -> {
                        System.out.println("Update age rating");
                        System.out.println("G, PG, PG13, NC17");
                        String ageRatingUpdate = sc.nextLine();
                        AgeRating ageRating = AgeRating.getRating(ageRatingUpdate);
                        m.setAgeRating(ageRating);
                    }
                    case 7 -> {
                        System.out.println("Update movie rating (0-5)");
                        double movieRatingUpdate = Double.parseDouble(sc.nextLine());
                        m.setMovieRating(movieRatingUpdate);
                    }
                    case 8 -> {
                        System.out.println("Update movie synopsis");
                        String synopsisUpdate = sc.nextLine();
                        m.setMovieSynopsis(synopsisUpdate);
                    }
                }

            }
            DatabaseController.updateMovieData(m,Integer.parseInt(movieId)-1);
        }
    }

}
