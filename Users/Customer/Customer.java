package Users.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

import DatabaseSystem.CustomerDb;
import Users.User;

public class Customer extends User {
  
    private String userName;
    private String paymentType;
    private ArrayList<Ticket> previousBookings;
    private static CustomerDb customerDb = new CustomerDb();

    public Customer(String mobileNumber, String password, int age, String gender, String type, String loginStatus) {
    super(mobileNumber, password, age, gender, type, loginStatus);
    
    }

    public Customer(String mobileNumber, String password, int age, String gender, String type, String loginStatus,
            String userName, String paymentType) {
        super(mobileNumber, password, age, gender, type, loginStatus);
        this.userName = userName;
        this.paymentType = paymentType;
    }
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public ArrayList<Ticket> getPreviousBookings() {
        return previousBookings;
    }

    public void setPreviousBookings(ArrayList<Ticket> previousBookings) {
        this.previousBookings = previousBookings;
    }

    @Override
    public boolean userLogin(String mobileNumber, String password) throws SQLException {
        String userPassword = customerDb.getUserPassword(mobileNumber);
        if(userPassword.equals(password)){
         this.setLoginStatus("true");
         customerDb.updateUserLoginStatus(getMobileNumber(), getLoginStatus());
         return true;
     }
        else return false;
         
     }
    
    @Override
    public boolean userLogout() {
        // TODO Auto-generated method stub
        return false;
    }
    
    
}
