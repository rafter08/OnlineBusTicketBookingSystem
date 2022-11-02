package Users.Feedback;

import Users.User;

public class Complaint {
    private String complaintStatement;
    private User user;
    private String complaintID;
    public Complaint(String complaintStatement, User user, String complaintID) {
        this.complaintStatement = complaintStatement;
        this.user = user;
        this.complaintID = complaintID;
    }
    public String getComplaintStatement() {
        return complaintStatement;
    }
    public void setComplaintStatement(String complaintStatement) {
        this.complaintStatement = complaintStatement;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getComplaintID() {
        return complaintID;
    }
    public void setComplaintID(String complaintID) {
        this.complaintID = complaintID;
    }
    
}
