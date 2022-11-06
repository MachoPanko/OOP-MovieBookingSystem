package model;
import model.classes.Cinema;
import model.enums.DayType;
import view.*;
import controller.DatabaseController;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
//        MovieCreation.createMovie();
        MovieConfiguration.configureMovies();
        BookingSystem.purchaseTicket();
    }}