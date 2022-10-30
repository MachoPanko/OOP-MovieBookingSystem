package view;

import controller.DatabaseController;
import model.AgeRating;
import model.Movie;
import model.MovieStatus;
import model.MovieTag;

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
                System.out.println("1) Title\n2) Director\n3) Casts\n4) Movie Tag\n" +
                        "5) Status\n6)Age Rating\n7)Movie Rating\n8)Sypnosis");
                int updateChoice = sc.nextInt();
                sc.nextLine();
                switch (updateChoice){
                    case 1:
                        System.out.println("Update movie title:");
                        String titleUpdate = sc.nextLine();
                        m.setMovieTitle(titleUpdate);
                        break;
                    case 2:
                        System.out.println("Update movie director:");
                        String directorUpdate = sc.nextLine();
                        m.setMovieDirector(directorUpdate);
                        break;
                    case 3:
                        System.out.println("Update movie casts");
                        ArrayList<String> casts = new ArrayList<String>();
                        while(casts.size() < 2){ // For now add only 2 casts
                            System.out.println("Enter cast name:");
                            String castName = sc.nextLine();
                            casts.add(castName);
                        }
                        m.setCasts(casts);
                        break;
                    case 4:
                        System.out.println("Update movie tag");
                        System.out.println("Blockbuster, Normal, 3D");
                        String tagChoice = sc.nextLine();
                        MovieTag movieTag = MovieTag.getMovieTag(tagChoice);
                        m.setMovieTag(movieTag);
                        break;
                    case 5:
                        System.out.println("Update movie status");
                        System.out.println("Coming_Soon, Preview, Now_Showing");
                        String statusChoice = sc.nextLine();
                        MovieStatus movieStatus = MovieStatus.getMovieStatus(statusChoice);
                        m.setMovieStatus(movieStatus);
                        break;
                    case 6:
                        System.out.println("Update age rating");
                        System.out.println("G, PG, PG13, NC17");
                        String ageRatingUpdate = sc.nextLine();
                        AgeRating ageRating = AgeRating.getRating(ageRatingUpdate);
                        m.setAgeRating(ageRating);
                        break;
                    case 7:
                        System.out.println("Update movie rating (0-5)");
                        String movieRatingUpdate = sc.nextLine();
                        m.setMovieRating(movieRatingUpdate);
                        break;
                    case 8:
                        System.out.println("Update movie sypnosis");
                        String sypnosisUpdate = sc.nextLine();
                        m.setMovieSypnosis(sypnosisUpdate);
                        break;

                }

            }
            DatabaseController.updateMovieData(m,Integer.valueOf(movieId)-1);
        }
    }

}
