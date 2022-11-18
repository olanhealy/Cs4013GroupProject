package GP.src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Yum Restaurant

public class Test {
    public static void main(String args[]) {

    	
        // creates restaurant and bookilist
        Restaurant yumLimerick = new Restaurant(4);
        BookingsList Bookings = yumLimerick.addBookingsList();

        //Creates CSV file class and date
        BillCSV write = new BillCSV();
        
        //Reads CSV file data
        write.readFromCSV("CSV files/PaymentRecords.csv");
        System.out.println();

        CustomerInformationCSV readCI = new CustomerInformationCSV();
        readCI.readFromCSV("CSV files/Bookings.csv", Bookings);

        TableCSV readTable = new TableCSV();
        readTable.readFromCSV("CSV files/Tables.csv", yumLimerick);

        System.out.println(yumLimerick.getSeatLayout());
        //takes walkin booking
        Bookings.addBooking(Bookings.takeWalkIn("5"));
        System.out.println(Bookings);

        //assigns bookings to tables
        for(int i = 0; i < Bookings.getBookingList().size(); i++ ){
            TableAssignment assign = new TableAssignment(yumLimerick, Bookings.getBookingList().get(i));
        }


       

        //-------------------------------------------------------------------------------------------------

        //adds menu
        yumLimerick.addMenu("Al la Carte");

        //adds course
        yumLimerick.getMenus().get(0).addCourse("Starters");
        yumLimerick.getMenus().get(0).addCourse("Mains");
        yumLimerick.getMenus().get(0).addCourse("Desserts");
        yumLimerick.getMenus().get(0).addCourse("Drinks");

        //adds foodItems
        yumLimerick.getCourse(0,0).addMenuItem(new MenuItem("Soup",3.00 ));
        yumLimerick.getCourse(0,0).addMenuItem(new MenuItem("Prawns",5.00));

        yumLimerick.getCourse(0,1).addMenuItem(new MenuItem("Steak",22.00));
        yumLimerick.getCourse(0,1).addMenuItem(new MenuItem("Chicken",16.00));

        yumLimerick.getCourse(0,2).addMenuItem(new MenuItem("Brownie",6.00));
        yumLimerick.getCourse(0,2).addMenuItem(new MenuItem("Sundae",5.00));

        yumLimerick.getCourse(0,3).addMenuItem(new MenuItem("Guiness",5.00));
        yumLimerick.getCourse(0,3).addMenuItem(new MenuItem("Rioja",6.50));

        //shows menu
//        yumLimerick.getMenus().get(0).getCourses().get(0).showMenu();
//        yumLimerick.getMenus().get(0).getCourses().get(1).showMenu();
//        yumLimerick.getMenus().get(0).getCourses().get(2).showMenu();
//        yumLimerick.getMenus().get(0).getCourses().get(3).showMenu();

        //take order
//        Order order = new Order();
//        order.takeOrder(yumLimerick.getSeatLayout().get(0), yumLimerick.getMenus().get(0));
        
        
//        Bill a = new Bill("Card", order);
//        write.addBills(a);
//        write.writeToCsv("CSV files/PaymentRecords.csv");
       
        //write.readFromCSV("CSV files/PaymentRecords.csv");

      
        //Payment payment = new Payment();
        //payment.pay(yumLimerick.getSeatLayout().get(0), yumLimerick.getMenus().get(0));

    }

        //StaffLogin login = new StaffLogin();
        //login.system();

    }

