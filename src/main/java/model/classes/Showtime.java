package model.classes;

import java.io.Serializable;

public class Showtime implements Serializable {
    private String movie;

    private String[] time_arr = {"09:00", "14:00", "21:00"};
    private int time_int;

    public Showtime(String movie, int time_int) {
        this.movie = movie;
        this.time_int = time_int;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String[] getTime_arr() {
        return time_arr;
    }

    public void setTime_arr(String[] time_arr) {
        this.time_arr = time_arr;
    }

    public int getTime_int() {
        return time_int;
    }

    public void setTime_int(int time_int) {
        this.time_int = time_int;
    }
}
