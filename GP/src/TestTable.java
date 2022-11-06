package GP.src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class TestTable {
    public static void main(String args[]) {
        Restaurant restaurant = new Restaurant(10);
        BookingsList Bookings = new BookingsList();

        String path = "CSV files/Bookings.csv";
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line = br.readLine()) != null) {

                String[] values = line.split(",");
                CustomerInformation booking = new CustomerInformation(values[0],values[1],values[2],values[3],values[4],values[5],values[6]);
                Bookings.addBooking(booking);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        //CustomerInformation booking1 = new CustomerInformation("John Francis", "0873416741", "12:00","2", "Birthday", "Wheat", "None");
        //CustomerInformation booking2 = new CustomerInformation("Mary Richards", "0871234567", "13:30","4", "Date Night", "None", "Wedding ring");
        //CustomerInformation booking3 = new CustomerInformation("Hugh B. Pipen", "0869395333", "14:00","6", "None", "None", "Window Seat");

        //Bookings.addBooking(booking1);
        //Bookings.addBooking(booking2);
        //Bookings.addBooking(booking3);

        System.out.println(Bookings);

        for(int i = 0; i < Bookings.getBookingList().size(); i++ ){
            TableAssignment assign = new TableAssignment(restaurant, Bookings.getBookingList().get(i));
        }

        //TableAssignment assign = new TableAssignment(restaurant, booking1);

        System.out.println(restaurant);

        restaurant.getSeatLayout().get(3).setTableEmpty();

        System.out.println(restaurant);


    }
}
