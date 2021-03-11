package AccountFunctions;

import checkerForBooking.TrainBookChecker;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookTrain {
    static Scanner vvod = new Scanner(System.in);
    public static void BookingTrainTicket(String login) throws SQLException, ClassNotFoundException {
        System.out.println("Train booking system..." + "\n" + "From:");
        String from = vvod.next();
        System.out.println("To:");
        String to = vvod.next();
        if(TrainBookChecker.FromCheck(from) && TrainBookChecker.ToCheck(to)) BookedTickets.AddTrainTickets(from, to);
        else System.out.println("There is no such route");
    }
}
