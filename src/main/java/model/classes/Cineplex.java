package model.classes;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class Cineplex {


    private String[] location_arr = {"AMK HUB","DOWNTOWN EAST","CAUSEWAY POINT"};
    private int cineplexID;


    private final ArrayList<Cinema> cinemaList;

    Cineplex(int cineplexID) {
        this.cineplexID = cineplexID;
        cinemaList = new ArrayList<>();
    }

    Cineplex(int cineplexID, ArrayList<Cinema> cinemaList) {
        this.cineplexID = cineplexID;

        this.cinemaList = cinemaList;
    }

    public ArrayList<Cinema> getCinemaList() { return this.cinemaList; }
    public int getCineplexID() { return cineplexID; }

    public void setCineplexID(int cineplexID) { this.cineplexID = cineplexID; }

    public String getLocation(){
        return location_arr[cineplexID];
    }
}
