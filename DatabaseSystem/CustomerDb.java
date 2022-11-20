package DatabaseSystem;

import java.sql.SQLException;

import Users.Customer.Customer;
import Users.Customer.Ticket;

public class CustomerDb extends UserDb{
    public boolean addCustomerRecord(Customer customer) throws SQLException{
        String Query = "insert into customer values('"+customer.getMobileNumber()+"','"+customer.getUserName()+"','"+customer.getPaymentMethod()+"')";
        return statement.execute(Query);
    }

    public boolean deleteCustomerRecord(String mobileNumber) throws SQLException{
        String Query = "delete from customer where mobileNumber = "+mobileNumber;
        return statement.execute(Query);
    }

    public boolean addTicket(Ticket ticket) throws SQLException{
        String Query = "insert into ticket values('"+ticket.getTicketID()+"','"+ticket.getCustomerMobileNumber()+"','"+ticket.getBoardingTime()+"','"+ticket.getDepartureTime()+"','"+ticket.getBoardingPoint()+"','"+ticket.getBoardingPoint()+"','"+ticket.getJourneyDate()+"','"+ticket.getBusID()+"','"+ticket.getPrice()+"')";
        return statement.execute(Query);
        
    }
}
