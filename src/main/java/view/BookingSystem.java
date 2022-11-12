package view;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import controller.*;
import model.classes.*;
import model.enums.CinemaType;
import model.enums.DayType;
import model.enums.MovieStatus;
import model.enums.TransactionType;

import static model.Main.SC;
import static model.Main.VIEW_STATE;

public class BookingSystem {


    private static Movie movie;


    public static void display()  {
        //INIT Total price
        double totalPrice = 0 ;
        // INIT DATE and time
        long millis = System.currentTimeMillis();
        double currentTime = (millis/ 1000.0 ) / 60/60;
        SimpleDateFormat sdf = new SimpleDateFormat(
                "dd-MM-yyyy");
        String todaysDate = sdf.format(new java.sql.Date(millis));
        DayType dayType = DayType.getType(todaysDate);
        MovieGoer movieGoer = (MovieGoer) VIEW_STATE.getCurrUser();
        //INIT movieTickets
        ArrayList<MovieTicket> movieTickets = new ArrayList<>();
        //INIT Movie choice and cineplex
        System.out.println("""
                Please Enter the name of the Cineplex You are at!!
                - AMK HUB
                - DOWNTOWN EAST
                - CAUSEWAY POINT
                """);
        Cineplex currentCineplex = CineplexController.CINEPLEXES.get(SC.nextLine()); ///hmm feels weird not to list all movies before typing movie name but nvm lifestyle stuff fix ltr

        MovieController.MOVIES.forEach((k,v) ->{
            var isStaff =  VIEW_STATE.getCurrUser() instanceof Staff;
            if(!isStaff){
                if(v.getMovieStatus() == MovieStatus.END_OF_SHOWING){
                    return;
                }

            }
            System.out.println(v);


        });
        System.out.println();

        System.out.println("Please Enter The name of the Movie You would like to watch!!");
        String movieChoice = SC.nextLine();
        Movie movieChosen = MovieController.MOVIES.get(movieChoice);
        Cinema cinemaChosen = null;

        if (movieChosen != null) {
            System.out.println("Please Choose your Cinema Type");
            System.out.println("Platinum, Economy, IMAX");
            CinemaType cinemaType = CinemaType.getType(SC.nextLine());

            System.out.println("At which time do you want to watch it?");
            System.out.println("""
                 1) 0800
                 2) 0900
                 3) 1000
                 4) 1100
                 5) 1200
                 6) 1300
                 7) 1400
                 8) 1500
                 9) 1600
                10) 1700
                11) 1800
                12) 1900
                13) 2000
                14) 2100
                15) 2200
                16) 2300
                17) 2400
                """);
            int showtimeChoice = SC.nextInt();
            String showTimeChosen = new Showtime().TIME[showtimeChoice];

            //Find suitable cinema based on time and movie given.
            for (Cinema cinema: currentCineplex.getCinemaList()){
                if ( cinema.getCinemaClass()==cinemaType){
                    for(Movie m : cinema.getMoviesShown()){
                        if ( movieChosen == m){
                            cinemaChosen = cinema;
                            break;
                        }
                    }
                }
            }
            //Initial display
            assert cinemaChosen != null;
            // Repeated booking loop
            int choice;
            do {
                System.out.println("Dear "+VIEW_STATE.getCurrUser().getUsername()+", You Have Chosen To Buy A Ticket For "+ movieChosen.getMovieTitle()+" with a "+cinemaType+ " experience.");
                System.out.println("Please Choose your seat. Eg : row 1 col 1 ");
                cinemaChosen.display();
                System.out.println("Row:");
                int row = SC.nextInt();
                System.out.println("Col");
                int col = SC.nextInt();

                cinemaChosen.bookSeating(row, col);
                System.out.println("Student?\n1) Yes\n2) No");
                int student = SC.nextInt();
                boolean isStudent;
                boolean isElderly = false;
                isStudent = student == 1;
                System.out.println("Elderly?\n1) Yes\n2) No");
                int elderly = SC.nextInt();
                isElderly = elderly == 1;

                //INIT MOVIE TICKET AND ADDING TO MOVIE TICK LIST
                MovieTicket currentMovieTicket = new MovieTicket(movieChosen,cinemaType,dayType, isStudent,isElderly, row,col,cinemaChosen.getCinemaCode());
                totalPrice += PricingController.getPrice( currentMovieTicket,currentTime);
                movieTickets.add(currentMovieTicket);
                System.out.println("Please Enter 1 if you would like to buy another ticket or enter anything else if you wish to stop.");
                choice = SC.nextInt();
            } while (choice == 1);
            System.out.println("You have Finished Purchasing Tickets!");
            System.out.println("""
                Please Enter what Transaction Type you would like to pay with.
                - DEBITCARD
                - CREDITCARD
                - CASH
                """);
            String transactionChoice = SC.nextLine();
            //UPDATE USERDATABASE update transaction choice
            UserController.USER_DATABASE.get(VIEW_STATE.getCurrUser().getUsername()).updateBookings(new Booking(UUID.randomUUID().toString(),movieGoer,todaysDate,movieTickets,new Transaction(UUID.randomUUID().toString(),totalPrice,todaysDate,TransactionType.getTransactionType(transactionChoice))));
        } else {
            System.out.println("No such Movie exists! Please Try Again.");
            VIEW_STATE.setCurrState(ViewState.State.BookingSystemView);
        }

        // Since movieGoer might want to book more than one ticket , theres a loop here.



////        Updating Booking HistoryT
       // Booking booking = new Booking("test", movieGoer, todaysDate,movieTickets, new Transaction(1234,12,todaysDate, TransactionType.getType(), new ArrayList<>())); //HARD CODED TRANSACTION ARGUMENTS
        //DatabaseController.saveBookings(booking);




    }
}
