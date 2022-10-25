import javax.swing.*;
import java.util.ArrayList;

public class BookingsList {
    private ArrayList<CustomerInformation> customers;

    public BookingsList() {
        customers = new ArrayList<CustomerInformation>();
    }

    public void addBooking(CustomerInformation booking) {
        customers.add(booking);
    }

    public boolean checkBooking(String inputName, String inputPhoneNumber) {
        boolean value = false;
        for(int i = 0; i < customers.size(); i++) {
            CustomerInformation booking = customers.get(i);

            if (booking.getName().equals(inputName) && booking.getPhoneNumber().equals(inputPhoneNumber))
                value = true;
        }
        return value;
    }

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
