package Users.Customer;

import Users.User;

public class Customer extends User {
    private String address;
    private String paymentMethod;
    private String preference;
    private String rating;
    public Customer(String userName, String password, String email, String mobileNumber, String age, String gender,
            String address, String paymentMethod, String preference, String rating) {
        super(userName, password, email, mobileNumber, age, gender);
        this.address = address;
        this.paymentMethod = paymentMethod;
        this.preference = preference;
        this.rating = rating;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public String getPreference() {
        return preference;
    }
    public void setPreference(String preference) {
        this.preference = preference;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
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
