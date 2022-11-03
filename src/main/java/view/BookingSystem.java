package view;
import java.io.IOException;
import java.util.*;

import controller.DatabaseController;
import model.classes.*;
import model.enums.CinemaType;
import model.enums.DayType;

public class BookingSystem {

    private static MovieGoer movieGoer ;
    private static Movie movie;


    public static void purchaseTicket() throws IOException {

        // INIT moviegoer
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Your ID so i can identify u thru the database");
        String movieGoerid = sc.next();

        System.out.println("Please Enter Your Name so i know whos name is going to be on my wedding ring");
        String name = sc.next();

        System.out.println("Please Enter Your Mobile Number So i can call u later tonight xoxo <3");
        int mobile = sc.nextInt();

        System.out.println("Please Enter Your Age so i dont go to jail ;)");
        int age = sc.nextInt();

        System.out.println("Are you a student?\n1) Yes\n2) No");
        int student = sc.nextInt();
        boolean isStudent;
        if(student == 1){
            isStudent = true;
        }else{
            isStudent = false;
        }

        System.out.println("Please Enter Your Email");
        String email = sc.next();

        movieGoer = new MovieGoer(movieGoerid, name, mobile, age, email);
        //INIT movieTickets
        ArrayList<MovieTicket> movieTickets = new ArrayList<>();
        //INIT Movie choice
        ArrayList<Movie> movies = DatabaseController.loadMovieData();
        String seatChoice;
        System.out.println("Please Enter The Movie You would like to watch!!");
        String movieChoice = sc.next();
        Movie movieChosen = null;
        while (movieChosen == null) {
            for (Movie m : movies) {
                if (movieChoice.toUpperCase().replaceAll("\\s+", "") == m.getMovieTitle().toUpperCase().replaceAll("\\s+", "")) {
                    movieChosen = m;
                } else {
                    System.out.println("No such Movie exists! Please Try Again.");
                    System.out.println("Please Enter The Movie You would like to watch!!");
                    movieChoice = sc.next();
                }

            }
        }



        /// init cinema THIS PART IS EXTREMELY INCOMPLETE. ALOT OF HARD CODED FOR TESTING
        System.out.println("Please Choose your Cinema Type");
        CinemaType  cinemaType = CinemaType.getType(sc.next());
        int timeOfMovie ; /// *Time format used to store movie timings have not been set as of when this code was written. please review.
        timeOfMovie = sc.nextInt();
        Cinema cinemaChosen = new Cinema(01,movieChosen,cinemaType, new int[2]); /// TESTING ONLY
        for (int j = 0 ; j <5 ; j++){
            System.out.println("loop thru the cinema lists to match TIME and movie NAME and CINEMA TYPE. After finding cinema then save it as a variable");
        }




        // Since movieGoer might want to book more than one ticket , theres a loop here.
        int choice;
        do {
            System.out.println("Dear "+name+", You Have Chosen To Buy A Ticket For "+ movieChosen.getMovieTitle()+" with a "+cinemaType+ "experience.");
            System.out.println("Please Choose your seat. Eg : A1 ");
            seatChoice = sc.next();

            //INIT MOVIE TICKET AND ADDING TO MOVIE TICK LIST
            movieTickets.add(new MovieTicket(movieChosen,cinemaType,
                    age, DayType.getType("01-01-2022"),isStudent));    ///hard coded date here for testing
            System.out.println("Please Enter 1 if you would like to buy another ticket or enter anything else if you wish to stop.");
            choice = sc.nextInt();
        } while (choice == 1);


        //Updating Booking History
        //Booking booking = new Booking("test", movieGoer, "01-01-2022",movieTickets,new Transaction("100",));
        //DatabaseController.saveBookings(booking);





    }
}
