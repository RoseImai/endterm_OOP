package welcome;
import afterLogin.AfterLog;
import registration.Registration;
import validator.Validator;

import java.sql.SQLException;
import java.util.Scanner;


public class WelcomePage
{
    static Scanner vvod = new Scanner(System.in);
    public static void Welcome() throws SQLException, ClassNotFoundException {
        int choice = -1;
        String login;
        String pass;
        System.out.println("****************************************");
        System.out.println("Welcome to Victoria application");
        while(choice!=0)
        {
            System.out.println("****************************************");
            System.out.println("1.Log in");
            System.out.println("2.Registration");
            System.out.println("0.Close app");
            System.out.println("****************************************");
            System.out.println("Your choice: ");
            choice = vvod.nextInt();

            if(choice == 1)
            {
                System.out.println("Login: ");
                login = vvod.next(); //enter login
                System.out.println("Password: ");
                pass = vvod.next(); //enter password
                Validator user = new Validator(login, pass);
                if(user.exists)
                {
                    System.out.println("Hello " + login);
                    AfterLog.MainPage(login);
                    choice = 0;
                }
            }

            else if (choice == 2)
            {
                Registration.Register();
            }

            else if (choice == 0)
            {
                System.out.println("See you soon! Bye!");
                break;
            }

            else
                {
                    System.out.println("You inputed incorrect number! Would you like to close the program?");
                    System.out.println("y/n");
                    String answer = vvod.next();
                    if (answer.equals("y")) break;
                    else continue;
                }
        }
    }
}
