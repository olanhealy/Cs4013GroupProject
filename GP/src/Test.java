package GP.src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//Yum Restaurant

public class Test {
    public static void main(String args[]) {

        // creates restaurant and bookilist
        Restaurant yumLimerick = new Restaurant();
        BookingsList bookings = yumLimerick.addBookingsList();
        Staff staff = new Staff("Olan", 11, "2");
        new MenuCreation(yumLimerick);

        //Creates CSV file class and date
        BillCSV write = new BillCSV();
        //Reads CSV file data
        //write.readFromCSV("CSV files/PaymentRecords.csv");

        CustomerInformationCSV readCI = new CustomerInformationCSV();
        readCI.readFromCSV("CSV files/Bookings.csv", bookings);

        TableCSV readTable = new TableCSV();
        readTable.readFromCSV("CSV files/Tables.csv", yumLimerick);

        RestaurantInterface yum = new RestaurantInterface();

        //yum.staffLogin(staff);
       // yum.run(staff, yumLimerick, bookings, write);

        yum.run(staff, yumLimerick, bookings, write);


//        StaffLogin login = new StaffLogin();
//        login.addStaff(new Manager("Eoin", 222, "Manager49"));
//        login.system();

    }
}
