package AccountFunctions;

import java.sql.*;

public class ShowPlane {
    public static void PlaneSchedule() throws ClassNotFoundException, SQLException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/endterm_java";
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;

        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(connectionUrl, "postgres","victoria");
        try
        {
            String zapros = "Select * from plane;"; //preparing query
            stmt = con.createStatement();
            rs = stmt.executeQuery(zapros); //execute query
            System.out.println("flight" + " || " + "departure_city" + " || "
                    + "departure_time" + " || " + "arrival_city" + " || "
                    + "arrival_time" + " || " + "plane_type" + " || "
                    + "cost");
            while (rs.next())
                System.out.println(rs.getString("flight")
                        + " || " + rs.getString("departure_city") + " || "
                        + rs.getString("departure_time") + " || " + rs.getString("arrival_city") + " || "
                        + rs.getString("arrival_time") + " || " + rs.getString("plane_type") + " || "
                        + rs.getInt("cost") + "kzt");
        }
        catch (Exception e)
        {
            System.out.println("error"); //otherwise error
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
