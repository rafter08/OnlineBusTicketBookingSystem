package Users.Administration;

import DatabaseSystem.AdminDb;
import Users.User;
import java.io.FileReader;  
import java.io.IOException;
import java.sql.SQLException;

import com.opencsv.CSVReader;  

public class Admin extends User{
    
    private static AdminDb adminDb = new AdminDb();
    
    public Admin(String mobileNumber, String password, String age, String gender, String type, String loginStatus) {
        super(mobileNumber, password, age, gender, type, loginStatus);
    }

    public Admin() {
        super(null,null,null,null,null,null);
    }

    public static boolean addBus(String pathCSV){
        CSVReader reader = null;  
        try  
        {  
        reader = new CSVReader(new FileReader(pathCSV));    
        String [] nL;  
        reader.readNext();
        //read one line at a time  
            while ((nL = reader.readNext()) != null)  
            {  
               Bus bus = new Bus(nL[0],nL[1],nL[2],nL[3],nL[4],nL[5]);
               if(adminDb.getBusRecord(bus.getBusID())==null){
                adminDb.insertBusRecord(bus);
               }else
                adminDb.updateBusRecord(bus);
               
            }
            return true; 
        }  
        catch (Exception e)   
        {  
        e.printStackTrace(); 
        return false ;
        }  

    }

    @Override
    public boolean userLogin(String mobileNumber,String password) throws SQLException {
        String userPassword = adminDb.getUserPassword(mobileNumber);
        if(userPassword.equals(password)){
         this.setLoginStatus("true");
         adminDb.updateUserLoginStatus(getMobileNumber(), getLoginStatus());
         return true;
     }
        else return false;
    }

    @Override
    public boolean userLogout(String mobileNumber) throws SQLException {
        this.setLoginStatus("false");
        return adminDb.updateUserLoginStatus(mobileNumber, "false");
    }

    @Override
    public boolean userRegister(String csvPath) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
    
}
