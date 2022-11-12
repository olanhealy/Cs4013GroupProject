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

        //Reads CSV file to create bookings
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

        yumLimerick.getCourse(0,1).addMenuItem(new MenuItem("Steak",5.00));
        yumLimerick.getCourse(0,1).addMenuItem(new MenuItem("Chicken",5.00));

        yumLimerick.getCourse(0,2).addMenuItem(new MenuItem("Brownie",5.00));
        yumLimerick.getCourse(0,2).addMenuItem(new MenuItem("Sundae",5.00));

        yumLimerick.getCourse(0,3).addMenuItem(new MenuItem("Guiness",5.00));
        yumLimerick.getCourse(0,3).addMenuItem(new MenuItem("Rioja",5.00));

        //shows menu
        yumLimerick.getMenus().get(0).getCourses().get(0).showMenu();
        yumLimerick.getMenus().get(0).getCourses().get(1).showMenu();
        yumLimerick.getMenus().get(0).getCourses().get(2).showMenu();
        yumLimerick.getMenus().get(0).getCourses().get(3).showMenu();

        Order order = new Order();
        order.takeOrder(yumLimerick.getSeatLayout().get(0), yumLimerick.getMenus().get(0));

        System.out.println(order.toString());
        //Payment payment = new Payment();
        //payment.pay(yumLimerick.getSeatLayout().get(0), yumLimerick.getMenus().get(0));

    }

        //StaffLogin login = new StaffLogin();
        //login.system();

    }

