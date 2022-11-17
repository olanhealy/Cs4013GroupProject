package GP.src;
import javax.swing.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The class that holds CustomerInformation in a List of Bookings
 * <p>
 *     Class can add, check and cancel bookings
 * </p>
 * <p>
 *     Class can take WalkIn as CustomerInformation Object
 * </p>
 * @author Kevin Collins
 */
public class BookingsList {


    private ArrayList<CustomerInformation> customers;

    // default constructor to create new Arraylist
    //stores Customer information object

    /**
     * default constructor
     */
    public BookingsList() {
        customers = new ArrayList<CustomerInformation>();
    }

    /**
     * @return the list of bookings
     */
    public ArrayList<CustomerInformation> getBookingList() {
        return customers;
    }

    /**
     * adds a booking to BookingList arrayList
     * @param booking object of CustomerInformation
     */
    //adds a booking (CustomerInformation Object)
    public void addBooking(CustomerInformation booking) {
        customers.add(booking);
    }

    /**
     * checks if the booking is within the Array list (Name , Phone Number)
     * @param inputName name of customer
     * @param inputPhoneNumber phone number of guest
     * @return if booking exists return true else false
     */
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

    /**
     * removes booking from BookingList
     * @param inputName customer's name
     */
    public void cancelBooking(String inputName) {
        for (int i = 0; i < customers.size(); i++) {
            CustomerInformation t = customers.get(i);
            if (t.getName().equals(inputName)) {
                customers.remove(i);
            }
        }
    }

    /**
     * creates CustomerInformation object
     * <p>
     *     used for non-bookings. Uses default values for all not got in walk-ins
     * </p>
     * @param numberOfGuests
     * @return Customer Information object that holds time and number of guests
     */
    public CustomerInformation takeWalkIn(String numberOfGuests){

        int time = LocalDateTime.now().getHour();
        CustomerInformation customer = new CustomerInformation("WalkIn","N/A", Integer.toString(time) , numberOfGuests, "N/A", "N/A","N/A");
        return customer;
    }

    @Override
    public String toString() {
        return customers.toString();
    }
}
