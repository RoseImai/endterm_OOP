package AccountFunctions;

import java.sql.*;
import java.util.Scanner;

public class ShowAccount {
    public static void AccountData(String login) throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/endterm_java";
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;

        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(connectionUrl, "postgres","victoria");
        try
        {
            String zapros = "Select * from users where login = '" + login + "';";
            stmt = con.createStatement();
            rs = stmt.executeQuery(zapros);
            while (rs.next())
                System.out.println("Your name: " + rs.getString("name") + "\n" +
                        "Your phone: " + rs.getString("phone") + "\n" +
                        "Your card: " + rs.getString("card_num"));

        }
        catch (Exception e)
        {
            System.out.println("Error");
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
    }
}
