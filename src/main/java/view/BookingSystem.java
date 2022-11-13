package view;

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

    public static void display() {
        //INIT Total price
        double totalPrice = 0;

        // INIT DATE and time
        long millis = System.currentTimeMillis();
        double currentTime = (millis / 1000.0) / 60 / 60;
        SimpleDateFormat dateformatTID = new SimpleDateFormat("yyyyMMddHHmm");
        String dateformat = dateformatTID.format(new java.sql.Date(millis));

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
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

        String cineplexStr = SC.nextLine();
        Cineplex currentCineplex = CineplexController.CINEPLEXES.get(cineplexStr); ///hmm feels weird not to list all movies before typing movie name but nvm lifestyle stuff fix ltr

        if(currentCineplex == null) {
            System.out.println("We dont have that cineplex! Try again!");
            return;
        }

        for(Movie v: MovieController.getMoviesByCineplex(cineplexStr)) {
            boolean isStaff = VIEW_STATE.getCurrUser() instanceof Staff;
            if (!isStaff) {
                if (v.getMovieStatus() == MovieStatus.END_OF_SHOWING) return;
            }
            System.out.println(v);
        }
        System.out.println();

        System.out.println("Please Enter The name of the Movie You would like to watch!!");
        String movieChoice = SC.nextLine();
        Movie movieChosen = MovieController.MOVIES.get(movieChoice);

        if (movieChosen != null) {
            System.out.println("Please Choose your Cinema Type");
            System.out.println("Platinum, Economy, IMAX");
            CinemaType cinemaType = CinemaType.getType(SC.nextLine());
            Cinema cinemaChosen = null;

            for(Cinema cinema : currentCineplex.getCinemaList()) {
                if(cinema.getCinemaClass() == cinemaType) {
                    cinemaChosen = cinema;
                    break;
                }
            }

            // invalid cinema
            if(cinemaChosen == null) {
                System.out.println("You have chosen an invalid cinemaType!");
                VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);
                return;
            }

            System.out.println("At which time do you want to watch it?");

            boolean haveMovie = false;
            // print out the timings with this movie shown
            for(int i = 0; i < cinemaChosen.getShowTiming().size(); ++i) {
                Movie shown = cinemaChosen.getMoviesShownFiltered().get(i);
                if(shown != null && shown.equals(movieChosen)) {
                    haveMovie = true;
                    System.out.println((i + 1) + ")\t" +cinemaChosen.getShowTiming().TIME[i]);
                }
            }

            if(!haveMovie) {
                System.out.println("We dont have the movie you are looking for, for " + cinemaType + " @ " + currentCineplex.getCineplexName() + "!");
                System.out.println("Please search again");
                VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);
                return;
            }

            int showtimeChoiceIdx = SC.nextInt() - 1;
            SC.nextLine();

            if (cinemaChosen.getMoviesShownFiltered().get(showtimeChoiceIdx) == null) {
                VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);
                return;
            }

            System.out.println("Dear " + movieGoer.getUsername() + ", You Have Chosen To Buy A Ticket For " + movieChosen.getMovieTitle() + " with a " + cinemaType + " experience.");
            // Repeated booking loop
            int choice = 1;
            do {
                System.out.println("Please Choose your seat. Eg : row 0 col 0 ");

                cinemaChosen.display(showtimeChoiceIdx);
                System.out.println("Row:");
                int row = SC.nextInt();
                SC.nextLine();

                System.out.println("Col");
                int col = SC.nextInt();
                SC.nextLine();

                // check if seat alr book
                if(cinemaChosen.getSeatingLayout()[showtimeChoiceIdx][row][col]) {
                    System.out.println("The seat you want is already booked! Try again!");
                    continue;
                }

                System.out.println("Student?\n1) Yes\n2) No");
                int student = SC.nextInt();
                SC.nextLine();

                boolean isStudent = student == 1;
                boolean isElderly = false;

                if(!isStudent) {
                    System.out.println("Elderly?\n1) Yes\n2) No");
                    int elderly = SC.nextInt();
                    SC.nextLine();
                    isElderly = elderly == 1;
                }

                //Seating layout not complete idk who wrote this but tao is fixing this part
                cinemaChosen.bookSeating(showtimeChoiceIdx, row, col);
                //INIT MOVIE TICKET AND ADDING TO MOVIE TICK LIST

                MovieTicket currentMovieTicket = new MovieTicket(movieChosen, cinemaType, dayType, isStudent, isElderly, row, col, cinemaChosen.getCinemaCode());
                totalPrice += PricingController.getPrice(currentMovieTicket, currentTime);
                movieTickets.add(currentMovieTicket);
                movieChosen.increaseTicketSales();

                System.out.println("Please Enter 1 if you would like to buy another ticket or enter any other number else if you wish to stop.");
                choice = SC.nextInt();
                SC.nextLine();
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
            String Tid = cinemaChosen.getCinemaCode()+dateformat;
            movieGoer.updateBookings(new
                    Booking(Tid,
                    movieGoer, todaysDate, movieTickets,
                    new Transaction(Tid, totalPrice, todaysDate,
                            TransactionType.getTransactionType(transactionChoice)), currentCineplex.getCineplexName()));

            VIEW_STATE.setCurrState(ViewState.State.MovieGoerView);
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
