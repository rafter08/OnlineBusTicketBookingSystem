package DatabaseSystem;

import java.sql.*;

import Users.User;
import Users.Administration.Admin;
import Users.Customer.Customer;

public class UserDb {
    private  Connection connection;
    private  Database database;
    protected  Statement statement;
    protected   ResultSet rs;

    public UserDb() {
        database = new Database();
        
       try {
       
        connection = DriverManager.getConnection(database.getDbURL(),database.getDbUserName(),database.getDbPassword());
         statement = connection.createStatement();
        } catch (SQLException e) {
       
            e.printStackTrace();
        }
    }

    public   boolean addUserRecord(User user) throws SQLException{
        String Query = "insert into user values('"+user.getMobileNumber()+"','"+user.getPassword()+"','"+user.getAge()+"','"+user.getGender()+"','"+user.getType()+"','"+user.getLoginStatus()+"')";
        return statement.execute(Query);
    }
     
    public  boolean deleteUserRecord(User user) throws SQLException{
        String Query = "delete from user where mobileNumber="+user.getMobileNumber();
        return statement.execute(Query);
    }

    public String getUserPassword(String mobileNumber) throws SQLException{
        String Query = "select password from user where mobileNumber = "+mobileNumber;
        rs = statement.executeQuery(Query);
        if(rs.next())return rs.getString("password");
        else return null;
    }

    public  boolean updateUserLoginStatus(String mobileNumber,String status) throws SQLException{
        String Query = "update user set loginstatus ='"+status+"' where mobileNumber = '"+mobileNumber+"'";
        return statement.execute(Query);
    }

    public User getUser(String mobileNumber) throws SQLException{
        String Query = "select * from user where mobileNumber = '"+mobileNumber+"'";
        rs = statement.executeQuery(Query);
        User user = null;
        if(rs.next()){
            String type = rs.getString("type");
            if(type.toLowerCase().equals("customer")){
                
                user = new Customer(rs.getString("mobileNumber"),rs.getString("password"),rs.getInt("age"),rs.getString("gender"),rs.getString("type"),rs.getString("loginStatus"));
            }
            else if(type.toLowerCase().equals("admin")){
                user = new Admin(rs.getString(0),rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5));
            
            }
        }
        return user;
    }
}
