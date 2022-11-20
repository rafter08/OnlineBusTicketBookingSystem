package Users.Administration;

import DatabaseSystem.AdminDb;
import Users.User;

public class Admin extends User{
    
    private static AdminDb adminDb = new AdminDb();
    
    public Admin(String mobileNumber, String password, int age, String gender, String type, String loginStatus) {
        super(mobileNumber, password, age, gender, type, loginStatus);
    }

    @Override
    public boolean userLogin(String email,String password) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean userLogout() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
