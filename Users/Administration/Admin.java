package Users.Administration;

import Users.User;

public class Admin extends User{
    private String adminID;

    public Admin(String userName, String password, String email, String mobileNumber, String age, String gender,
            String adminID) {
        super(userName, password, email, mobileNumber, age, gender);
        this.adminID = adminID;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    @Override
    public boolean userLogin() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean userLogout() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
