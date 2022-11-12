package controller;

import model.classes.Booking;
import model.classes.Staff;
import utils.DatabaseLoader;

import java.util.HashMap;

public class StaffController {
    private static final String filename = "src/database/staffAccount.ser";

    public static final HashMap<String, Staff> STAFF_ACCOUNTS = new HashMap<>();

    public static void load() {
        HashMap<String, Staff> hm = DatabaseLoader.loadDb(filename);
        if(hm != null) {
            System.out.println("[+] Loaded staff account database!");
            if(hm.size() == 0) {
                STAFF_ACCOUNTS.put("budi", new Staff("budi", "budi123"));
                STAFF_ACCOUNTS.put("admin", new Staff("admin", "admin"));
            }
            STAFF_ACCOUNTS.putAll(hm);
        } else {
            System.out.println("[-] Empty staff account database loaded.");
        }
    }

    public static void write() {
        DatabaseLoader.writeDb(filename, STAFF_ACCOUNTS);
    }
}
