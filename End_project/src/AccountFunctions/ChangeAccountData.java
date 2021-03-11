package AccountFunctions;

import Updater.Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ChangeAccountData {
    static PreparedStatement pstmt = null;
    static Scanner vvod = new Scanner(System.in);
    public static void UpdateAccountData(String login) throws SQLException
    {
        int choice = -1;
        while (choice!=0)
        {
            System.out.println("What do you want to update?");
            System.out.println("1. Password");
            System.out.println("2. Name");
            System.out.println("3. Phone number");
            System.out.println("4. Card number");
            System.out.println("0. Return");
            choice = vvod.nextInt();
            switch (choice)
            {
                case 0: break;
                case 1: Update.UpdatePassword(login); break;
                case 2: Update.UpdateName(login); break;
                case 3: Update.UpdatePhone(login);break;
                case 4: Update.UpdateCard(login);break;
                default: choice=0; break;
            }
        }
    }
}
