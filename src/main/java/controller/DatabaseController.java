package controller;

import model.classes.Booking;
import model.classes.Movie;
import model.classes.Review;
import model.classes.Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;


public class DatabaseController {

    public static void initMovieData() {
        try{
            File obj = new File("src/database/movieDatabase.txt");
            if(obj.createNewFile()) {
                System.out.println("Created new movieDatabase.txt");
            } else {
                System.out.println("Error creating new movieDATA");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void saveMovieData(Movie movie){
        try{
            ArrayList<Movie> movies = loadMovieData();
            movies.add(movie);
            File obj = new File("src/database/movieDatabase.txt");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(obj));
            oos.writeObject(movies); // write the
            oos.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public  static void updateMovieData(Movie movie,int index){
        try{
            ArrayList<Movie> movies = loadMovieData();
            movies.remove(index);
            movies.add(movie);
            File obj = new File("src/database/movieDatabase.txt");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(obj));
            oos.writeObject(movies); // write the
            oos.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Movie> loadMovieData(){
        ArrayList<Movie> movies = new ArrayList<>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/database/movieDatabase.txt"));
            movies = (ArrayList<Movie>) ois.readObject();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return movies;
    }

    public static void saveStaffAccount(Staff staff){
        try{
            ArrayList<Staff> staffData = loadStaffAccount();
            boolean userExists = false;
                for(Staff s : staffData) {
                    if (staff.getUsername().toUpperCase().equals(s.getUsername().toUpperCase())) {
                        System.out.println("Staff account already exists.");
                        userExists = true;
                        break;
                    }
                }
                if(!userExists){
                    staffData.add(staff);
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/database/staffAccount.txt"));
                    oos.writeObject(staffData);
                    oos.close();
                }

        }catch (Exception e){
            System.out.println("There was an error in saving the staff login details");
        }

    }

    public static ArrayList<Staff> loadStaffAccount(){
        ArrayList<Staff> staffData = new ArrayList<>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/database/staffAccount.txt"));
            staffData = (ArrayList<Staff>) ois.readObject();
        } catch (Exception e){
            System.out.println("There was an error in retrieving the staff login details");
        }

        return staffData;
    }
    public static void saveBookings(Booking booking){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/database/bookingHistory.txt"));
            ArrayList<Booking> bookings = new ArrayList<Booking>();
            bookings.add(booking);
            oos.writeObject(bookings);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Booking> loadBookings(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/database/bookingHistory.txt"));
            ArrayList<Booking> bookings = (ArrayList<Booking>) ois.readObject();
            return bookings;
        } catch (Exception fileE){
            System.out.println(fileE.getMessage());
            return (new ArrayList<Booking>());
        }
    }
    public static void createReviews(){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/database/reviewHistory.txt"));
            HashMap<String, ArrayList<Review>>reviews = new HashMap<>();
            oos.writeObject(reviews);

        }catch(Exception e){
            System.out.println("Error! Cant Initialize Database!");
            System.out.println(e.getMessage());
        }
    }

    public static void updateReviews(Movie movie, Review newReview){
        try{
            ObjectInputStream ois = new ObjectInputStream( new FileInputStream("src/database/reviewHistory.txt"));
            HashMap<String, ArrayList<Review>> dataBase = (HashMap<String, ArrayList<Review>>)ois.readObject();
            ArrayList<Review> reviewList = dataBase.get(movie.getMovieTitle());
            if( reviewList != null){ // if there alr is a movie entry
                reviewList.add(newReview);
            }
            else{ // if there is no movie entry
                dataBase.put(movie.getMovieTitle(),new ArrayList<>());
                dataBase.get(movie.getMovieTitle()).add(newReview);
            }

        }catch(Exception e){
            System.out.println("Error! Cant Update Database!");
            System.out.println(e.getMessage());
        }
    }

    public static HashMap<String,ArrayList<Review>> loadReviews(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/database/reviewHistory.txt"));
            return (HashMap<String, ArrayList<Review>>) ois.readObject();
        } catch (Exception fileE){
            System.out.println(fileE.getMessage());
            System.out.println("Error! No Database Initialized!");
            return (new HashMap<>());
        }
    }

}
