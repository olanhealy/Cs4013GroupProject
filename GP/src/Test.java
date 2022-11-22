package GP.src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//Yum Restaurant

public class Test {
    public static void main(String args[]) {

            // creates restaurant and bookingList
            Restaurant yumLimerick = new Restaurant();
            BookingsList bookings = yumLimerick.addBookingsList();
            new MenuCreation(yumLimerick);

            //Creates CSV file class and date
            yumLimerick.setBillTable(new BillCSV());
            BillCSV billTable = yumLimerick.getBillTable();
        //    billTable.readFromCSV("CSV files/PaymentRecords.csv");

            yumLimerick.setCustomerTable(new CustomerInformationCSV());
            CustomerInformationCSV customerTable = yumLimerick.getCustomerTable();
            customerTable.readFromCSV("CSV files/Bookings.csv", bookings);

            yumLimerick.setTablesTable(new TableCSV());
            TableCSV tablesTable = yumLimerick.getTablesTable();
            tablesTable.readFromCSV("CSV files/Tables.csv", yumLimerick);

            yumLimerick.setRestaurantInterface(new RestaurantInterface());
            RestaurantInterface yum = yumLimerick.getRestaurantInterface();

            yumLimerick.addStaff(yumLimerick.getStaff());

            //yum.staffLogin(staff);
            // yum.run(staff, yumLimerick, bookings, write);
            yum.run(yumLimerick, bookings, billTable);
//        StaffLogin login = new StaffLogin();
//        login.addStaff(new Manager("Eoin", 222, "Manager49"));
//        login.system();
        }
    }

