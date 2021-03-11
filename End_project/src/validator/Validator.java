package validator;

import java.sql.*;
import java.util.Scanner;

public class Validator
{
    public boolean exists = false;
    public Validator(String login, String pass) throws SQLException, ClassNotFoundException
    {
        String connectionUrl = "jdbc:postgresql://localhost:5432/endterm_java"; //connecting to DB...again
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;

        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(connectionUrl, "postgres","victoria");
        try
        {
            String zapros = "Select * from users"; //preparing query
            stmt = con.createStatement();
            rs = stmt.executeQuery(zapros); //execute query
            while (rs.next())
            {
                if(login.equals(rs.getString("login")))
                {
                    if (pass.equals(rs.getString("password"))) {
                        exists = true;
                        break;
                    }
                    else System.out.println("Incorrect Password");
                }
                else System.out.println("This user doesn't exists");
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
    }
}
