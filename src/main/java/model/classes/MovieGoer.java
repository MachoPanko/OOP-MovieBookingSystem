package model.classes;

import java.io.Serializable;
import java.util.ArrayList;


public class MovieGoer implements Serializable, User {
    private String username;

    private int mobile;
    private int age;
    private String email;
    private ArrayList<Booking>bookings;

    /**
     * Constructor for MovieGoer class
     * @param username The username of the movieGoer
     * @param mobile The phone number of the movieGoer
     * @param age The age of the movieGoer
     * @param email The email of the movieGoer
     */
    public MovieGoer(String username,  int mobile, int age, String email) {
        this.username = username;
        this.mobile = mobile;
        this.age = age;
        this.email = email;
        this.bookings = new ArrayList<>();
    }

    public ArrayList<Booking> getBookings() { return bookings; }

    /**
     * Sets array of bookings
     * @param bookings
     */
    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    /**
     * This method update the bookings
     * @param newBooking A new booking that is made
     */
    public void updateBookings (Booking newBooking){ this.bookings.add(newBooking); }

    /**
     * Sets the username of movieGoer
     * @param username movieGoer's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the phone number of movieGoer
     * @return mobile
     */
    public int getMobile() {
        return mobile;
    }

    /**
     * Sets the phone number of the movieGoer
     * @param mobile
     */
    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets the age
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age
     * @param age The age of the movieGoer
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email
     * @param email The email of the movieGoer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Override User interface getUsername
     * @return username
     */
    @Override
    public String getUsername() { return this.username; }
}
