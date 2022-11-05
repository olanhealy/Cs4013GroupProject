package GP.src;
import javax.swing.*;
import java.util.ArrayList;

public class BookingsList {
    private ArrayList<CustomerInformation> customers;

    // default constructor to create new Arraylist
    //stores Customer information object
    public BookingsList() {
        customers = new ArrayList<CustomerInformation>();
    }

    //adds a booking (CustomerInformation Object)
    public void addBooking(CustomerInformation booking) {
        customers.add(booking);
    }

    //checks if the booking is within the Array list (Name , Phone Number)
    public boolean checkBooking(String inputName, String inputPhoneNumber) {
        boolean value = false;
        // if its in array sets value to true and returns
        for(int i = 0; i < customers.size(); i++) {
            CustomerInformation booking = customers.get(i);

            if (booking.getName().equals(inputName) && booking.getPhoneNumber().equals(inputPhoneNumber))
                value = true;
        }
        // returns false if not in array
        return value;
    }

    //cancels booking of name
    public void cancelBooking(String inputName) {
        for (int i = 0; i < customers.size(); i++) {
            CustomerInformation t = customers.get(i);
            if (t.getName().equals(inputName)) {
                customers.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        return customers.toString();
    }
}
