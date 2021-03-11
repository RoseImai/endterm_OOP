package AccountFunctions;

import java.sql.*;
import java.util.ArrayList;

public class BookedTickets {
    static ArrayList<String> fromTrainArr = new ArrayList<>();
    static ArrayList<String> toTrainArr = new ArrayList<>();
    static ArrayList<String> fromPlaneArr = new ArrayList<>();
    static ArrayList<String> toPlaneArr = new ArrayList<>();
    static int trainCounter = -1;
    static int planeCounter = -1;
    public static void MyBookedTicketsForTrain() throws ClassNotFoundException, SQLException {
        if (trainCounter==-1) System.out.println("You didn't book any tickets for train");
        else
            for (int i=0; i<=trainCounter; i++)
        {
            String connectionUrl = "jdbc:postgresql://localhost:5432/endterm_java";
            Connection con = null;
            ResultSet rs = null;
            Statement stmt = null;

            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres","victoria");
            try
            {
                String zapros = "Select * from train where departure_city = '" + fromTrainArr.get(i) +"' and arrival_city = '" + toTrainArr.get(i) + "';"; //preparing query
                stmt = con.createStatement();
                rs = stmt.executeQuery(zapros); //execute query
                while (rs.next())
                    System.out.println(rs.getInt("train_num")
                            + " || " + rs.getString("departure_city") + " || "
                            + rs.getString("departure_time") + " || " + rs.getString("arrival_city") + " || "
                            + rs.getString("arrival_time") + " || " + rs.getString("train_type") + " || "
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

    public static void MyBookedTicketsForPlane() throws ClassNotFoundException, SQLException {
        if (planeCounter==-1) System.out.println("You didn't book any tickets for plane");
        else
            for (int i=0; i<=planeCounter; i++)
            {
                String connectionUrl = "jdbc:postgresql://localhost:5432/endterm_java";
                Connection con = null;
                ResultSet rs = null;
                Statement stmt = null;

                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection(connectionUrl, "postgres","victoria");
                try
                {
                    String zapros = "Select * from plane where departure_city = '" + fromPlaneArr.get(i) +"' and arrival_city = '" + toPlaneArr.get(i) + "';"; //preparing query
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(zapros); //execute query
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

    public static void AddTrainTickets(String from, String to)
    {
        fromTrainArr.add(from);
        toTrainArr.add(to);
        trainCounter++;
        System.out.println("Ordered!");
    }

    public static void AddPlaneTickets(String from, String to)
    {
        fromPlaneArr.add(from);
        toPlaneArr.add(to);
        planeCounter++;
        System.out.println("Ordered!");
    }

    public static void MyBookedTickets() throws SQLException, ClassNotFoundException {
        MyBookedTicketsForTrain();
        MyBookedTicketsForPlane();
    }
}
