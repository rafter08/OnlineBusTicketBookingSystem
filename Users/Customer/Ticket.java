package Users.Customer;

public class Ticket {
    private String ticketID;
    private Customer customer;
    private String boardingPoint;
    private String departingPoint;
    private String journeyDate;
    private String boardingTime;
    private String departureTime;
    private String busID;
    private int price;
    
   
    public Ticket(String ticketID, Customer customer, String boardingPoint, String departingPoint, String journeyDate,
            String boardingTime, String departureTime, String busID, int price) {
        this.ticketID = ticketID;
        this.customer = customer;
        this.boardingPoint = boardingPoint;
        this.departingPoint = departingPoint;
        this.journeyDate = journeyDate;
        this.boardingTime = boardingTime;
        this.departureTime = departureTime;
        this.busID = busID;
        this.price = price;
    }
    public String getTicketID() {
        return ticketID;
    }
    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public String getBoardingPoint() {
        return boardingPoint;
    }
    public void setBoardingPoint(String boardingPoint) {
        this.boardingPoint = boardingPoint;
    }
    public String getDepartingPoint() {
        return departingPoint;
    }
    public void setDepartingPoint(String departingPoint) {
        this.departingPoint = departingPoint;
    }
    public String getJourneyDate() {
        return journeyDate;
    }
    public void setJourneyDate(String journeyDate) {
        this.journeyDate = journeyDate;
    }
    public String getBoardingTime() {
        return boardingTime;
    }
    public void setBoardingTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }
    public String getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public String getBusID() {
        return busID;
    }
    public void setBusID(String busID) {
        this.busID = busID;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    
}
