import java.sql.SQLException;
import java.util.Scanner;

import DatabaseSystem.AdminDb;
import DatabaseSystem.CustomerDb;
import DatabaseSystem.UserDb;
import Users.User;
import Users.Administration.Admin;
import Users.Customer.Customer;

public class Main {
    private static UserDb userDb = new UserDb();
    private static CustomerDb customerDb  = new CustomerDb();
    private static Admin admin = new Admin();
    private static User user;
    private static Customer customer;
    public static void main(String[] args) throws SQLException {
        if(args.length>0)executeCommandLineArguments(args);
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
            case "register" : {
                register(args[1]);
                break;
            }
        }
    }

    public static void register(String csvPath) throws SQLException{
        customer = new Customer();
        if(customer.userRegister(csvPath)){
            if(customerDb.addCustomerRecord(customer))
            System.out.println("Registration successfull!");
        }
        else System.out.println("Registration failed");
    }

    public static void login(String mobileNumber,String password) throws SQLException{
        user = userDb.getUser(mobileNumber);
                if(user==null)return;
                if(user.userLogin(mobileNumber, password))System.out.println("Login success");
                else System.out.println("Login failed");
    }

    public static void logout(String mobileNumber) throws SQLException{
       if(user!=null && user.userLogout(mobileNumber))System.out.println("You're loged out");
    }

    public static String commandArgs(String[] args){
        if(args.length == 0)return null;
        else if(args.length == 1){
            if(args[0].toLowerCase().equals("help"))return "help";
            else if(args[0].toLowerCase().equals("viewjobs"))return "viewjobs";
        }
        else if(args.length == 2){
            if(args[0].toLowerCase().equals("login"))return "login1";
            else if(args[0].toLowerCase().equals("logout"))return "logout";
            else if(args[0].toLowerCase().equals("register"))return "register";
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
