package GP.src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Yum Restaurant

public class Test {
    public static void main(String args[]) {

    	
        // creates restaurant and bookilist
        Restaurant yumLimerick = new Restaurant();
        BookingsList Bookings = yumLimerick.addBookingsList();

        //Creates CSV file class and date
        BillCSV write = new BillCSV();
        
        //Reads CSV file data
        write.readFromCSV("CSV files/PaymentRecords.csv");

        CustomerInformationCSV readCI = new CustomerInformationCSV();
        readCI.readFromCSV("CSV files/Bookings.csv", Bookings);

        TableCSV readTable = new TableCSV();
        readTable.readFromCSV("CSV files/Tables.csv", yumLimerick);

        System.out.println(yumLimerick.getSeatLayout());
        //takes walkin booking
        Bookings.addBooking(Bookings.takeWalkIn("5"));
        //System.out.println(Bookings);

        //assigns bookings to tables
        for(int i = 0; i < Bookings.getBookingList().size(); i++ ){
            TableAssignment assign = new TableAssignment(yumLimerick, Bookings.getBookingList().get(i), 11);
        }

        yumLimerick.checkTablesAvailability();
       

        //-------------------------------------------------------------------------------------------------

        //new MenuCreation(yumLimerick);
        //yumLimerick.getMenu(0).showFullMenu(yumLimerick, 0);

        //take order
        Order order = new Order();
        order.takeOrder(yumLimerick.getTable(0), yumLimerick.getMenu(0));
        
        
//        Bill a = new Bill("Card", order);
//        write.addBills(a);
//        write.writeToCsv("CSV files/PaymentRecords.csv");
       
        //write.readFromCSV("CSV files/PaymentRecords.csv");

      
        //Payment payment = new Payment();
        //payment.pay(yumLimerick.getSeatLayout().get(0), yumLimerick.getMenus().get(0));
        StaffLogin login = new StaffLogin();
        login.addStaff(new Manager("Eoin", 222, "Manager49"));
        login.system();
    }
    }

