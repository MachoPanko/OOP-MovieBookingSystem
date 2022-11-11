package utils;

import java.io.*;

public class DatabaseLoader {

    public static <T extends Serializable> T loadDb(String filename) {
        T result = null;

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            result = (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public static <T extends Serializable> void writeDb(String filename, T buffer) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(buffer);
        } catch (Exception e) {
            System.out.println("Error writing to " + filename);
            System.out.println(e.getMessage());
        }
    }
}
