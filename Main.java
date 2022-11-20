import java.sql.SQLException;
import java.util.Scanner;

import DatabaseSystem.UserDb;
import Users.User;

public class Main {
    private static UserDb userDb = new UserDb();
    private static User user;
    public static void main(String[] args) throws SQLException {
       
    }

    public static void executeCommandLineArguments(String[] args) throws SQLException{
        String function = commandArgs(args);
        switch(function){
            case "login" : {
                login(args[1],args[2]);
                break;
            }
            case "logout" : {
                logout(args[1]);
                break;
            }
        }
    }

    public static void login(String mobileNumber,String password) throws SQLException{
        user = userDb.getUser(mobileNumber);
                if(user.userLogin(mobileNumber, password))System.out.println("Login success");
                else System.out.println("Login failed");
    }

    public static void logout(String mobileNumber){
        
    }

    public static String commandArgs(String[] args){
        if(args.length == 0)return null;
        else if(args.length == 1){
            if(args[0].toLowerCase().equals("help"))return "help";
            else if(args[0].toLowerCase().equals("viewjobs"))return "viewjobs";
        }
        else if(args.length == 2){
            if(args[0].toLowerCase().equals("login"))return "login1";
            if(args[0].toLowerCase().equals("logout"))return "logout";
        }
        else if(args.length==3){
            if(args[0].toLowerCase().equals("login"))return "login";
        }
        return null;
    }
}

class userInput{
    private static Scanner scanner = new Scanner(System.in);

    public static String scanPassword(){
        System.out.print("Enter Password : ");
        String Password = scanner.next();
        return Password;
    }
}
