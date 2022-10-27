package GP.src;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class CustomerInformationTest {

    public static void main(String args[]) {
        //ArrayList<CustomerInformation> customers = new ArrayList<>();

        CustomerInformation booking1 = new CustomerInformation("John Francis", "0873416741", 2, "Birthday", "Wheat", "None");
        CustomerInformation booking2 = new CustomerInformation("Mary Richards", "0871234567", 5, "Date Night", "None", "Wedding ring");
        CustomerInformation booking3 = new CustomerInformation("Hugh B. Pipen", "0869395333", 12, "None", "None", "Window Seat");

        BookingsList burgerMacBookings = new BookingsList();

        burgerMacBookings.addBooking(booking1);
        burgerMacBookings.addBooking(booking2);
        burgerMacBookings.addBooking(booking3);

        System.out.println(burgerMacBookings);
    }




}