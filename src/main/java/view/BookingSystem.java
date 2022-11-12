package view;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import controller.DatabaseController;
import controller.PricingController;
import model.classes.*;
import model.enums.CinemaType;
import model.enums.DayType;
import model.enums.TransactionType;

import static model.Main.SC;
import static model.Main.VIEW_STATE;

public class BookingSystem {


    private static Movie movie;


    public static void display()  {
        // INIT DATE

        long millis = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat(
                "dd-MM-yyyy");

        String todaysDate = sdf.format(new java.sql.Date(millis));

        MovieGoer movieGoer = (MovieGoer) VIEW_STATE.getCurrUser();
        //INIT movieTickets
        ArrayList<MovieTicket> movieTickets = new ArrayList<>();
        //INIT Movie choice
        ArrayList<Movie> movies = DatabaseController.loadMovieData();
        String seatChoice;
        System.out.println("Please Enter The Movie You would like to watch!!");
        String movieChoice = SC.nextLine();
        Movie movieChosen = null;
        int choice = SC.nextInt();
        for (Movie m : movies) {
            System.out.println(m.getMovieTitle());
            if (movieChoice.replaceAll("\\s+", "").toUpperCase().equals(m.getMovieTitle().replaceAll("\\s+", "").toUpperCase()) ) {
                movieChosen = m;
            } else {
                System.out.println("No such Movie exists! Please Try Again.");
                System.out.println("Please Enter The Movie You would like to watch!!");
                movieChoice = sc.next();
            }
        }




        /// init cinema THIS PART IS EXTREMELY INCOMPLETE. ALOT OF HARD CODED FOR TESTING
        System.out.println("Please Choose your Cinema Type");
        System.out.println("Platinum, Economy, IMAX");
        CinemaType  cinemaType = CinemaType.getType(sc.next());
//        int timeOfMovie ; /// *Time format used to store movie timings have not been set as of when this code was written. please review.
//        timeOfMovie = sc.nextInt();
        System.out.println("At which time do you want to watch it?");
        System.out.println("1) 09:00,2) 14:00,3) 21:00");
        int showtimeChoice = sc.nextInt();
        Showtime showtime = new Showtime(movieChoice,showtimeChoice-1);

        Cinema cinemaChosen = new Cinema(01,movieChosen,cinemaType, showtime); /// TESTING ONLY
        for (int j = 0 ; j <5 ; j++){
            System.out.println("loop thru the cinema lists to match TIME and movie NAME and CINEMA TYPE. After finding cinema then save it as a variable");
        }




        // Since movieGoer might want to book more than one ticket , theres a loop here.
        int choice;
        do {
            System.out.println("Dear "+name+", You Have Chosen To Buy A Ticket For "+ movieChosen.getMovieTitle()+" with a "+cinemaType+ "experience.");
            System.out.println("Please Choose your seat. Eg : row 1 col 1 ");
            cinemaChosen.printSeatingLayout();
            System.out.println("Row:");
            int row = sc.nextInt();
            System.out.println("Col");
            int col = sc.nextInt();
            //Seating layout not complete
            cinemaChosen.bookSeating(row, col);
            Seating[][] seatingLayout = cinemaChosen.getSeatingLayout();




            System.out.println("Student?\n1) Yes\n2) No");
            int student = sc.nextInt();
            boolean isStudent;
            boolean isElderly = false;
            if(student == 1){
                isStudent = true;
            }else{
                isStudent = false;
            }


            System.out.println("Elderly?\n1) Yes\n2) No");
            int elderly = sc.nextInt();
            if(elderly == 1){
                isElderly = true;
            }
            else{
                isElderly = false;
            }

            //INIT MOVIE TICKET AND ADDING TO MOVIE TICK LIST
            movieTickets.add(new MovieTicket(movieChosen,cinemaType,
                    age, DayType.getType(todaysDate),isStudent,isElderly,seatingLayout[row][col], cinemaChosen.getCinemaCode()));    ///hard coded date here for testing
            System.out.println("Please Enter 1 if you would like to buy another ticket or enter anything else if you wish to stop.");
            choice = sc.nextInt();
        } while (choice == 1);


        System.out.println("Input the time now:");
        double time = sc.nextDouble();
        double totalPrice = 0;
        String ticketType = new String();
        for(MovieTicket mt : movieTickets){
            if(!mt.isStudent()){
                if(!mt.isElderly()){
                    ticketType = "adult";
                }
                else{
                    ticketType = "elderly";
                }
            }else{
                ticketType = "student";
            }
            Double price = PricingController.getPrice(mt,time);
            ReceiptItem receiptItems = new ReceiptItem(ticketType, price, mt.getMovie().getMovieTag());
            totalPrice += price;

        }
        System.out.println(totalPrice);

        System.out.println("How do you want to pay by? (CreditCard, DebitCard, Cash)");
        String typeChoice = SC.next();
        TransactionType transactionType = TransactionType.getTransactionType(typeChoice);

////        Updating Booking HistoryT
       // Booking booking = new Booking("test", movieGoer, todaysDate,movieTickets, new Transaction(1234,12,todaysDate, TransactionType.getType(), new ArrayList<>())); //HARD CODED TRANSACTION ARGUMENTS
        //DatabaseController.saveBookings(booking);




    }
}
