package model;
import model.enums.DayType;
import view.MovieCreation;
import controller.DatabaseController;
import view.UserLogin;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(DayType.getType("2022-01-01"));
        UserLogin.login();
    }}