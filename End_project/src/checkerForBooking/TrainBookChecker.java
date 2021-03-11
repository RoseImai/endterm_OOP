package checkerForBooking;

import java.sql.*;

public class TrainBookChecker {
    public static boolean FromCheck(String from) throws ClassNotFoundException, SQLException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/endterm_java";
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        boolean correct = false;
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(connectionUrl, "postgres","victoria");
        try
        {
            String zapros = "Select * from train"; //preparing query
            stmt = con.createStatement();
            rs = stmt.executeQuery(zapros); //execute query
            while (rs.next())
            {
                if(from.equals(rs.getString("departure_city")))
                {
                    correct = true;
                    break;
                }
                else correct = false;
            }

        }
        catch (Exception e)
        {
            System.out.println("Error"); //otherwise error
        }
        finally
        {
            try
            {
                rs.close();
                stmt.close();
                con.close();
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }
        return correct;
    }

    public static boolean ToCheck(String to) throws ClassNotFoundException, SQLException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/endterm_java";
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        boolean correct = false;
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(connectionUrl, "postgres","victoria");
        try
        {
            String zapros = "Select * from train"; //preparing query
            stmt = con.createStatement();
            rs = stmt.executeQuery(zapros); //execute query
            while (rs.next())
            {
                if(to.equals(rs.getString("arrival_city")))
                {
                    correct = true;
                    break;
                }
                else correct = false;
            }

        }
        catch (Exception e)
        {
            System.out.println("Error"); //otherwise error
        }
        finally
        {
            try
            {
                rs.close();
                stmt.close();
                con.close();
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }
        return correct;
    }
}
