package utils;

import controller.BookHistoryController;
import controller.MovieController;

import java.io.*;

public class DatabaseLoader {

    /**
     * Load the file provided by filename.
     *
     * @param filename Path of file
     * @param <T>      T must extends
     * @return T
     */
    public static <T extends Serializable> T loadDb(String filename) {
        T result = null;

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            result = (T) ois.readObject();
        } catch(EOFException e) {
            System.out.println("Empty file loaded");
        } catch (IOException e) {
            e.printStackTrace();
            DatabaseLoader.createNewDatabase(filename);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Make sure you provide the correct class!");
        }

        return result;
    }

    private static void createNewDatabase(String filename) {
        File f = new File(filename);
        try {
            boolean created = f.createNewFile();
            if (created) {
                System.out.println("Created new database @ " + filename);
            } else {
                System.out.println("File already exist!");
            }
        } catch (IOException e) {
            System.out.println("Error creating file!");
        }
    }

    public static <T extends Serializable> void writeDb(String filename, T buffer) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(buffer);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error writing to " + filename);
            System.out.println(e.getMessage());
        }
    }

    public static void loadAllDb() {
        MovieController.loadMovies();
//        BookHistoryController.loadMovies();
    }
}
