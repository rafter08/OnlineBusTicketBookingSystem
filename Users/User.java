package Users;

public abstract class User {
    private String userName;
    private String password;
    private String email;
    private String mobileNumber;
    private String age;
    private String gender;
    public User(String userName, String password, String email, String mobileNumber, String age, String gender) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.gender = gender;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public abstract boolean userLogin();
    public abstract boolean userLogout();


}
