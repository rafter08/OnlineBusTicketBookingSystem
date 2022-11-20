package Users.Customer;

public class Ticket {
    private String ticketID;
    private String busID;
    private String customerMobileNumber;
    private String journeyDate;
    
    public Ticket(String ticketID, String busID, String customerMobileNumber, String journeyDate) {
        this.ticketID = ticketID;
        this.busID = busID;
        this.customerMobileNumber = customerMobileNumber;
        this.journeyDate = journeyDate;
    }
    public String getTicketID() {
        return ticketID;
    }
    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }
    public String getBusID() {
        return busID;
    }
    public void setBusID(String busID) {
        this.busID = busID;
    }
    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }
    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }
    public String getJourneyDate() {
        return journeyDate;
    }
    public void setJourneyDate(String journeyDate) {
        this.journeyDate = journeyDate;
    }
    
}
