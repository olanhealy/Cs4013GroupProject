package GP.src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

        System.out.println(Bookings);

        for(int i = 0; i < Bookings.getBookingList().size(); i++ ){
            TableAssignment assign = new TableAssignment(restaurant, Bookings.getBookingList().get(i));
        }

        System.out.println(restaurant);
        restaurant.getSeatLayout().get(3).setTableEmpty();
        System.out.println(restaurant);

        //-------------------------------------------------------------------------------------------------

        Menu menu = new Menu();
        menu.addCourse("Starters");
        System.out.println(menu.getCourses().get(0).getItems());
        menu.getCourses().get(0).addMenuItem(new MenuItem("Soup",3.00 ));
        menu.getCourses().get(0).addMenuItem(new MenuItem("Prawns",5.00));
        menu.getCourses().get(0).showMenu();
    }
}
