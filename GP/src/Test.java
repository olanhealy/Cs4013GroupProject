package GP.src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//Yum Restaurant

public class Test {
        public static void main(String args[]) {

//                // creates restaurant and bookingList
//                Restaurant yumLimerick = new Restaurant();
//                BookingsList bookings = yumLimerick.addBookingsList();
//                new MenuCreation(yumLimerick);
//
//                //Creates CSV file class and date
//                yumLimerick.setBillTable(new BillCSV());
//                BillCSV billTable = yumLimerick.getBillTable();
//                billTable.readFromCSV("CSV files/PaymentRecords.csv");
//
//                yumLimerick.setCustomerTable(new CustomerInformationCSV());
//                CustomerInformationCSV customerTable = yumLimerick.getCustomerTable();
//                customerTable.readFromCSV("CSV files/Bookings.csv", bookings);
//
//                yumLimerick.setTablesTable(new TableCSV());
//                TableCSV tablesTable = yumLimerick.getTablesTable();
//                tablesTable.readFromCSV("CSV files/Tables.csv", yumLimerick);
//
//                yumLimerick.setRestaurantInterface(new RestaurantInterface());
//                RestaurantInterface yum = yumLimerick.getRestaurantInterface();
//
//                yumLimerick.addStaff(yumLimerick.getStaff());
//
//                yum.run(yumLimerick, bookings, "CSV files/PaymentRecords.csv", "CSV files/Bookings.csv", "CSV files/Tables.csv");

                //----------------------------------------------------------------------------------

                // creates restaurant and bookingList
                Restaurant yumGalway = new Restaurant();
                BookingsList bookings2 = yumGalway.addBookingsList();
                new MenuCreation(yumGalway);

                //Creates CSV file class and date
                yumGalway.setBillTable(new BillCSV());
                BillCSV billTable2 = yumGalway.getBillTable();

                yumGalway.setCustomerTable(new CustomerInformationCSV());
                CustomerInformationCSV customerTable2 = yumGalway.getCustomerTable();
                customerTable2.readFromCSV("CSV files/BookingsGalway.csv", bookings2);

                yumGalway.setTablesTable(new TableCSV());
                TableCSV tablesTable2 = yumGalway.getTablesTable();
                tablesTable2.readFromCSV("CSV files/TablesGalway.csv", yumGalway);

                yumGalway.setRestaurantInterface(new RestaurantInterface());
                RestaurantInterface yum2 = yumGalway.getRestaurantInterface();

                yumGalway.addStaff(yumGalway.getStaff());

                yum2.run(yumGalway, bookings2, "CSV files/PaymentRecordsGalway.csv", "CSV files/BookingsGalway.csv", "CSV files/TablesGalway.csv");

        }
}