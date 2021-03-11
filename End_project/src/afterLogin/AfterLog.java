package afterLogin;

import AccountFunctions.*;

import java.sql.SQLException;
import java.util.Scanner;

public class AfterLog {
    static Scanner vvod = new Scanner(System.in);
    static String choice2;
    public static void MainPage(String login) throws SQLException, ClassNotFoundException {
        int choice = -1;
        while (choice!=0)
        {
            System.out.println("****************************************");
            System.out.println("1. Book affordable train tickets");
            System.out.println("2. Book affordable plane tickets");
            System.out.println("3. Show train schedule");
            System.out.println("4. Show aircraft schedule");
            System.out.println("5. Show your data");
            System.out.println("6. Change your data");
            System.out.println("7. My tickets");
            System.out.println("0. Log out");
            System.out.println("****************************************");
            System.out.println("Your choice: ");
            choice = vvod.nextInt();
            switch (choice)
            {
                case 0:
                    System.out.println("See you soon! Good luck!");
                    break;

                case 1:
                    BookTrain.BookingTrainTicket(login);
                    System.out.println("Do you want to see list of function or exit?");
                    System.out.println("list/exit");
                    choice2 = vvod.next();
                    if(choice2.equals("list")) choice = -1;
                    else choice = 0;
                    break;

                case 2:
                    BookPlane.BookingPlaneTicket(login);
                    System.out.println("Do you want to see list of function or exit?");
                    System.out.println("list/exit");
                    choice2 = vvod.next();
                    if(choice2.equals("list")) choice = -1;
                    else choice = 0;
                    break;

                case 3:
                    ShowTrain.TrainSchedule();
                    System.out.println("Do you want to see list of function or exit?");
                    System.out.println("list/exit");
                    choice2 = vvod.next();
                    if(choice2.equals("list")) choice = -1;
                    else choice = 0;
                    break;

                case 4:
                    ShowPlane.PlaneSchedule();
                    System.out.println("Do you want to see list of function or exit?");
                    System.out.println("list/exit");
                    choice2 = vvod.next();
                    if(choice2.equals("list")) choice = -1;
                    else choice = 0;
                    break;

                case 5:
                    ShowAccount.AccountData(login);
                    System.out.println("Do you want to see list of function or exit?");
                    System.out.println("list/exit");
                    choice2 = vvod.next();
                    if(choice2.equals("list")) choice = -1;
                    else choice = 0;
                    break;

                case 6:
                    ChangeAccountData.UpdateAccountData(login);
                    System.out.println("Do you want to see list of function or exit?");
                    System.out.println("list/exit");
                    choice2 = vvod.next();
                    if(choice2.equals("list")) choice = -1;
                    else choice = 0;
                    break;

                case 7:
                    BookedTickets.MyBookedTickets();
                    System.out.println("Do you want to see list of function or exit?");
                    System.out.println("list/exit");
                    choice2 = vvod.next();
                    if(choice2.equals("list")) choice = -1;
                    else choice = 0;
                    break;

                default:
                    choice = -1;
                    System.out.println("You inputed incorrect number. Please retry :-)");
            }
        }
    }
}
