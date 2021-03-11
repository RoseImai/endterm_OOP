package AccountFunctions;

import checkerForBooking.PlaneBookChecker;
import checkerForBooking.TrainBookChecker;

import java.sql.SQLException;
import java.util.Scanner;

public class BookPlane {
    static Scanner vvod = new Scanner(System.in);
    public static void BookingPlaneTicket(String login) throws SQLException, ClassNotFoundException {
        System.out.println("Train booking system..." + "\n" + "From:");
        String from = vvod.next();
        System.out.println("To:");
        String to = vvod.next();
        if(PlaneBookChecker.FromCheck(from) && PlaneBookChecker.ToCheck(to)) BookedTickets.AddPlaneTickets(from, to);
        else System.out.println("There is no such flight");
    }
}
