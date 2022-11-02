package controller;
import model.classes.Movie;
import model.classes.Staff;

import java.io.*;
import java.util.ArrayList;


public class DatabaseController {

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
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/database/movieDatabase.txt"));
            ArrayList<Movie> movies = new ArrayList<Movie>();
            movies = (ArrayList<Movie>) ois.readObject();
            return movies;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return (new ArrayList<Movie>());
        }
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
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/database/staffAccount.txt"));
            ArrayList<Staff> staffData = new ArrayList<Staff>();
            staffData = (ArrayList<Staff>) ois.readObject();
            return staffData;
        }catch (FileNotFoundException fileE){
            return (new ArrayList<Staff>());
        }
        catch (Exception e){
            System.out.println("There was an error in retrieving the staff login details");
            return (new ArrayList<Staff>());
        }
    }

}
