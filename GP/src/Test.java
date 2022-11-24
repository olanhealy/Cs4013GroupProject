package GP.src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//Yum Restaurant

public class Test {
        public static void main(String args[]) {

                Scanner scanner = new Scanner(System.in);

                System.out.println("Which Yum Restaurant would you like to access?");
                System.out.println("1. Yum Limerick, 2. Yum Galway");
                String input = scanner.nextLine();
                if(input.equals("1")){

                        // creates restaurant and bookingList
                        Restaurant yumLimerick = new Restaurant();
                        BookingsList bookings = yumLimerick.addBookingsList();
                        new MenuCreation(yumLimerick);

                        //Creates CSV file class and date
                        yumLimerick.setBillTable(new BillCSV());
                        BillCSV billTable = yumLimerick.getBillTable();
                        billTable.readFromCSV ("CSV files/PaymentRecords.csv");

                        yumLimerick.setCustomerTable(new CustomerInformationCSV());
                        CustomerInformationCSV customerTable = yumLimerick.getCustomerTable();
                        customerTable.readFromCSV("CSV files/Bookings.csv", bookings);

                        yumLimerick.setTablesTable(new TableCSV());
                        TableCSV tablesTable = yumLimerick.getTablesTable();
                        tablesTable.readFromCSV("CSV files/Tables.csv", yumLimerick);

                        yumLimerick.setRestaurantInterface(new RestaurantInterface());
                        RestaurantInterface yum = yumLimerick.getRestaurantInterface();

                        yumLimerick.addLimerickStaff(yumLimerick.getStaff());

                        yum.run(yumLimerick, bookings, "CSV files/BookingsGalway.csv", "CSV files/PaymentRecordsGalway.csv", "CSV files/TablesGalway.csv");



                } else if ( input.equals("2")){
                // creates restaurant and bookingList
                Restaurant yumGalway = new Restaurant();
                BookingsList bookings2 = yumGalway.addBookingsList();
                new MenuCreation(yumGalway);

                //Creates CSV file class and date
                BillCSV billTable2 = yumGalway.getBillTable();
                yumGalway.setBillTable(billTable2);
                billTable2.readFromCSV("CSV files/PaymentRecordsGalway.csv");

                yumGalway.setCustomerTable(new CustomerInformationCSV());
                CustomerInformationCSV customerTable = yumGalway.getCustomerTable();
                customerTable.readFromCSV("CSV files/BookingsGalway.csv", bookings2);

                yumGalway.setTablesTable(new TableCSV());
                TableCSV tablesTable2 = yumGalway.getTablesTable();
                tablesTable2.readFromCSV("CSV files/TablesGalway.csv", yumGalway);

                yumGalway.setRestaurantInterface(new RestaurantInterface());
                RestaurantInterface yum2 = yumGalway.getRestaurantInterface();

                yumGalway.addGalwayStaff(yumGalway.getStaff());


                yum2.run(yumGalway, bookings2, "CSV files/BookingsGalway.csv","CSV files/PaymentRecordsGalway.csv", "CSV files/TablesGalway.csv");

        }
}
}