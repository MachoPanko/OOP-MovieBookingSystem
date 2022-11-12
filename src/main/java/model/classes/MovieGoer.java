package model.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class MovieGoer implements Serializable, User {
    private String username;

    private int mobile;
    private int age;
    private String email;
    private ArrayList<Booking>bookings;

    public MovieGoer(String username,  int mobile, int age, String email) {
        this.username = username;
        this.mobile = mobile;
        this.age = age;
        this.email = email;
        this.bookings = new ArrayList<>();
    }

    public ArrayList<Booking> getBookings() { return bookings; }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
    public void updateBookings (Booking newBooking){ this.bookings.add(newBooking); }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getMobile() {
        return mobile;
    }
    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getUsername() { return this.username; }
}
