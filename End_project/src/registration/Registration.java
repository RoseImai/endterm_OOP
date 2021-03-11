package registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration
{
    static Scanner vvod = new Scanner(System.in);
    static PreparedStatement pstmt = null; //to prepare statement for sql
    public static void Register() throws SQLException, ClassNotFoundException
    {
        String connectionUrl = "jdbc:postgresql://localhost:5432/endterm_java"; //connecting to DB
        Connection con = null;

        System.out.println("****************************************");
        System.out.println("Please enter your login: ");
        String login = vvod.next();
        System.out.println("Please enter your password: ");
        String password = vvod.next();
        System.out.println("Please enter your name: ");
        String name = vvod.next();
        System.out.println("Please enter your phone: ");
        String phone = vvod.next();
        System.out.println("Please enter your card_num: ");
        String card_num = vvod.next();
        System.out.println("****************************************");

        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(connectionUrl, "postgres","victoria"); //log in
        try
        {
            String query = "insert into users (login, password, name, phone, card_num) values(?, ?, ?, ?, ?);"; //preparing query
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            pstmt.setString(3, name);
            pstmt.setString(4, phone);
            pstmt.setString(5, card_num);
            pstmt.execute(); //execute query
            System.out.println("Success! Now you can log in");
        }
        catch (Exception e)
        {
            System.out.println("Error"); //Otherwise it will be error
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }
    }
}
