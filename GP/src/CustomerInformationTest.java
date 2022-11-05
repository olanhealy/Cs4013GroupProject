import java.util.ArrayList;

public class CustomerInformationTest {

    public static void main(String args[]) {
        //ArrayList<CustomerInformation> customers = new ArrayList<>();

        CustomerInformation booking1 = new CustomerInformation("John Francis", "0873416741", "12:00",2, "Birthday", "Wheat", "None");
        CustomerInformation booking2 = new CustomerInformation("Mary Richards", "0871234567", "13:30",5, "Date Night", "None", "Wedding ring");
        CustomerInformation booking3 = new CustomerInformation("Hugh B. Pipen", "0869395333", "14:00",12, "None", "None", "Window Seat");

        BookingsList burgerMacBookings = new BookingsList();

        burgerMacBookings.addBooking(booking1);
        burgerMacBookings.addBooking(booking2);
        burgerMacBookings.addBooking(booking3);

        System.out.println(burgerMacBookings);

        System.out.println(burgerMacBookings.checkBooking("John Francis", "0873416741"));

        burgerMacBookings.cancelBooking("John Francis");
        System.out.println();

        System.out.println(burgerMacBookings);

        System.out.println(burgerMacBookings.checkBooking("John Francis", "0873416741"));


    }
}