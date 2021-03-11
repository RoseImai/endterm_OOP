package Updater;

import welcome.WelcomePage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {
    static PreparedStatement pstmt = null;
    static Scanner vvod = new Scanner(System.in);

    public static void UpdatePassword(String login) throws SQLException
    {
        String connectionUrl = "jdbc:postgresql://localhost:5432/endterm_java";
        Connection con = null;

        System.out.println("Update password: ");
        String pass = vvod.next();
        try
        {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres","victoria");
            String zapros = "update users set password = ? where login='" + login +"';";
            pstmt = con.prepareStatement(zapros);
            pstmt.setString(1, pass);
            pstmt.executeUpdate();
            System.out.println("Password Changed");
        }
        catch (Exception e)
        {
            System.out.println("Error");
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

    public static void UpdateName(String login) throws SQLException
    {
        String connectionUrl = "jdbc:postgresql://localhost:5432/endterm_java";
        Connection con = null;

        System.out.println("Update name: ");
        String name = vvod.next();
        try
        {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres","victoria");
            String zapros = "update users set name = ? where login='" + login +"';";
            pstmt = con.prepareStatement(zapros);
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("Name Changed");
        }
        catch (Exception e)
        {
            System.out.println("Error");
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

    public static void UpdatePhone(String login) throws SQLException
    {
        String connectionUrl = "jdbc:postgresql://localhost:5432/endterm_java";
        Connection con = null;

        System.out.println("Update phone: ");
        String phone = vvod.next();
        try
        {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres","victoria");
            String zapros = "update users set phone = ? where login='" + login +"';";
            pstmt = con.prepareStatement(zapros);
            pstmt.setString(1, phone);
            pstmt.executeUpdate();
            System.out.println("Phone Changed");
        }
        catch (Exception e)
        {
            System.out.println("Error");
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

    public static void UpdateCard(String login) throws SQLException
    {
        String connectionUrl = "jdbc:postgresql://localhost:5432/endterm_java";
        Connection con = null;

        System.out.println("Update card: ");
        String card = vvod.next();
        try
        {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres","victoria");
            String zapros = "update users set card_num = ? where login='" + login +"';";
            pstmt = con.prepareStatement(zapros);
            pstmt.setString(1, card);
            pstmt.executeUpdate();
            System.out.println("Card Changed");
        }
        catch (Exception e)
        {
            System.out.println("Error");
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
