package controller;

import model.classes.Booking;
import model.classes.Staff;
import utils.DatabaseLoader;

import java.util.HashMap;

/**
 * Controller to set predefined staff accounts
 */
public class StaffController {
    private static final String filename = "src/database/staffAccount.ser";

    public static final HashMap<String, Staff> STAFF_ACCOUNTS = new HashMap<>();

    /**
     * Load predefined staff accounts to STAFF_ACCOUNTS hash map
     */
    public static void load() {
        HashMap<String, Staff> hm = DatabaseLoader.loadDb(filename);
        if(hm == null || hm.size() == 0) {
            STAFF_ACCOUNTS.put("budi", new Staff("budi", "budi123"));
            STAFF_ACCOUNTS.put("admin", new Staff("admin", "admin"));
        }

        if(hm != null) {
            System.out.println("[+] Loaded staff account database!");
            STAFF_ACCOUNTS.putAll(hm);
        } else {
            System.out.println("[-] Empty staff account database loaded.");
        }
    }

    /**
     * Write updated file to database
     */
    public static void write() {
        DatabaseLoader.writeDb(filename, STAFF_ACCOUNTS);
    }
}
