package controller;

import model.classes.MovieGoer;
import utils.DatabaseLoader;

import java.util.HashMap;

public class UserController {
    private static final String filename = "src/database/userDatabase.ser";

    public static final HashMap<String, MovieGoer> USER_HISTORY = new HashMap<>();

    public static void load() {
        HashMap<String, MovieGoer> hm = DatabaseLoader.loadDb(filename);
        if(hm != null) {
            System.out.println("[+] Loaded booking hist database!");
            USER_HISTORY.putAll(hm);
        } else {
            System.out.println("[-] Empty booking hist database loaded.");
        }
    }

    public static void write() {
        DatabaseLoader.writeDb(filename, USER_HISTORY);
    }
}
