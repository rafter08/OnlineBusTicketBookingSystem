import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DatabaseSystem.AdminDb;
import DatabaseSystem.CustomerDb;
import DatabaseSystem.UserDb;
import Users.User;
import Users.Administration.Admin;
import Users.Administration.Bus;
import Users.Customer.Customer;
import Users.Customer.Ticket;

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
            case "searchbus" : {
                searchBus();
                break;
            }
            case "bookticket" : {
                bookTicket(args[1], args[2], args[3]);
                break;
            }
            case "addbuses" : {
                addBuses(args[1], args[2]);
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
        user = userDb.getUser(mobileNumber);
       if(user!=null && user.userLogout(mobileNumber))System.out.println("You're loged out");
    }

    public static void searchBus() throws SQLException{
        ArrayList<Bus> buses = userDb.getAllBus();
        for(Bus bus : buses)bus.printBusDetails();
    }

    public static void bookTicket(String busID,String mobileNumber,String journeyDate) throws SQLException{
        user  = userDb.getUser(mobileNumber);
        if(user==null){
            System.out.println("Booking Failed! No user found with "+mobileNumber);
            System.out.println("Please register to continue");
        }
        else if(user.getLoginStatus().equalsIgnoreCase("true") ){
            customer = (Customer)user;
           customer.bookTicket(busID, mobileNumber, journeyDate);
        }
        else System.out.println("Please Login to continue!");
        

    }

    public static void addBuses(String mobileNumber,String csvPath) throws SQLException{
        user = userDb.getUser(mobileNumber);
        if(user==null){
            System.out.println("Try Again!");
            return;
        }
        else if(user.getType().equalsIgnoreCase("admin")){
            if(user.getLoginStatus().equalsIgnoreCase("true")){
                admin = (Admin)user;
                Admin.addBus(csvPath);
            }else{
                System.out.println("please login to continue");
                return;
            }
        }
        else if(user.getType().equalsIgnoreCase("customer")){
            System.out.println("You are not authorized to perform this operation");
            return;
        }
    }

    public static String commandArgs(String[] args){
        if(args.length == 0)return null;
        else if(args.length == 1){
            if(args[0].toLowerCase().equals("help"))return "help";
            else if(args[0].toLowerCase().equals("viewjobs"))return "viewjobs";
            else if(args[0].equalsIgnoreCase("searchbus"))return "searchbus";
        }
        else if(args.length == 2){
            if(args[0].toLowerCase().equals("login"))return "login1";
            else if(args[0].toLowerCase().equals("logout"))return "logout";
            else if(args[0].toLowerCase().equals("register"))return "register";
          
        }
        else if(args.length==3){
            if(args[0].toLowerCase().equals("login"))return "login";
            if(args[0].equalsIgnoreCase("addbuses"))return "addbuses";
        }
        else if(args.length==4){
            if(args[0].equalsIgnoreCase("bookticket"))return "bookticket";
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
