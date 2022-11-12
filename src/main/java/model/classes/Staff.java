package model.classes;

import java.io.Serializable;

/**
 * Admin account for cineplex workers.
 */
public class Staff implements Serializable, User {
    private final String username;
    private final String password;

    /**
     * Constructor for Staff class
     * @param username username for staff
     * @param password password for staff
     */
    public Staff(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Overrides User interface getUsername
     * @return username
     */
    @Override
    public String getUsername() { return username; }

    /**
     * Checks if the password provided is correct
     * @param password User input password
     * @return Whether password correct or not
     */
    public boolean isCorrectPassword(String password) { return password.equals(this.password); }
}
