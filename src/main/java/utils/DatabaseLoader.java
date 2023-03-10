package utils;

import controller.CineplexController;
import controller.UserController;
import controller.MovieController;
import controller.StaffController;

import java.io.*;

/**
 * Utility class to help handle the loading and saving to database
 */
public class DatabaseLoader {

    /**
     * Load the file provided by filename.
     * Usually `T` is HashMap or ArrayList
     * @param filename Path of file
     * @param <T>      T must extends Serializable
     * @return T
     */
    public static <T extends Serializable> T loadDb(String filename) {
        T result = null;

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            result = (T) ois.readObject();
        } catch(EOFException e) {
            System.out.println("[-] Empty file loaded");
        } catch (FileNotFoundException e) {
            DatabaseLoader.createNewDatabase(filename);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("[-] Make sure you provide the correct class!");
        }

        return result;
    }

    private static void createNewDatabase(String filename) {
        File f = new File(filename);
        try {
            boolean created = f.createNewFile();
            if (created) {
                System.out.println("[+] Created new database @ " + filename);
            } else {
                System.out.println("[-] File already exist!");
            }
        } catch (IOException e) {
            System.out.println("[-] Error creating file!");
        }
    }

    /**
     * Writes to the database
     * @param filename of the database
     * @param buffer the data we want to write
     * @param <T> Buffer datatype
     */
    public static <T extends Serializable> void writeDb(String filename, T buffer) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(buffer);
            oos.close();
        } catch (Exception e) {
            System.out.println("[-] Error writing to " + filename);
            System.out.println(e.getMessage());
        }
    }

    /**
     * Loads all the databases. If there are any databases not created, it will create a new one
     */
    public static void loadAllDb() {
        MovieController.load();
        UserController.load();
        StaffController.load();
        CineplexController.load();
    }

    /**
     * Save all the data to the database. Should only be called during ctrl-c handler or on exit
     */
    public static void saveAllDb() {
        MovieController.write();
        UserController.write();
        StaffController.write();
        CineplexController.write();
    }
}
