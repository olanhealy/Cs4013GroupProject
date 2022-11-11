package GP.src;
import javafx.scene.control.Tab;

import java.util.ArrayList;
import java.util.Scanner;
public class StaffLogin {
    Table t; //same as order
    Menu m; //same as order
    Order o; // not sure if needed but for viewing orders use .showOrder()??
    BookingsList b; //same as Order object
    Scanner staff = new Scanner(System.in);
    ArrayList<Staff> staffList = new ArrayList<Staff>(); //Olan had this as just as 'ArrayList<Staff> stafflist' but was getting
    // a null point exception error. changed it to  'ArrayList<Staff> staffList = new ArrayList<Staff>();' need to figure out why



    public StaffLogin(ArrayList<Staff> staffList) {
        this.staffList = staffList;

    }

    public void addStaff(Staff staff) {
        staffList.add(staff);
        staffList.add(new Waiter("Kevin", 13, "imcool"));
        staffList.add(new Chef("Olan", 8, "githubmerchant"));
    }

    public StaffLogin() {

    }

    /**
     *
     * @param id
     * @param password
     * @param staffList
     * @return true or false whether or not the staff id and password are correct
     * @author: Olan Healy
     */
    public boolean valid(String id, String password, ArrayList<Staff> staffList){
        for(Staff staff : staffList){
            if(staff.getName() == id && staff.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    /**
     * This method is used to login to the system with staff Id and password (added above in addStaff)
     * TODO: need to look at a way of having preset staff in the array already, not logical to add staff as you go
     *
     *
     *
     */

    public void system() {
        System.out.println("Please enter your staff ID");
        int id = staff.nextInt();
        System.out.println("Please enter your password");
        String password = staff.next();
        for (Staff staff : staffList) {
            if (staff.getId() == id && staff.getPassword().equals(password)) {
                System.out.println("Welcome " + staff.getName()); //TODO: code is not getting to this line, stops after enter password
            } else {
                System.out.println("Incorrect password or ID");

               /** if (staff instanceof Waiter) { //if staff is instance of waiter go to this
                    System.out.println("A)dd order, V)iew order T)ake booking, S)ee bookings, P)ayment, Q)uit");
                    String input = staff.next(); //why is this not working?
                    switch (input) {
                        case "A":
                            System.out.println("Add order");
                            System.out.println(o.takeOrder(Table t, Menu m)); //TODO: need to figure out how to get order to work
                            break;
                        case "V":
                            System.out.println("View order");
                            System.out.println(o.getOrders());
                            break;
                        case "T":
                            System.out.println("Take booking");
                            break;
                        case "S":
                            System.out.println("See bookings"); //Hopefully combine this with going to JavaFx of tables
                            System.out.println(b.getBookingList());
                        case "P":
                            System.out.println("Payment");
                            break;
                        case "Q":
                            System.out.println("Quit");
                            break;
                        default:
                            System.out.println("Invalid input");
                    }


                } else if (staff instanceof Chef) {
                    System.out.println("V)iew order, S)et order status, Q)uit");
                    String input = staff.next();
                    switch (input) {
                        case "V":
                            System.out.println("View order");
                            System.out.println(o.getOrders());
                            break;
                        case "S":
                            System.out.println("Set order status");
                            break;
                        case "Q":
                            System.out.println("Quit");
                            break;
                        default:
                            System.out.println("Invalid input");
                    }


                }

                }
        }
    } */
    }
        }
    }
}










    /** auto generated code just left here incase will need it later????
     if (staff instanceof Waiter) {
    Waiter waiter = (Waiter) staff;
     System.out.println("You are a waiter");
     System.out.println("Please enter the table number");
     int tableNumber = staff.nextInt();
     System.out.println("Please enter the order number");
     int orderNumber = staff.nextInt();
     System.out.println("Please enter the course number");
     int courseNumber = staff.nextInt();
     System.out.println("Please enter the food number");
     int foodNumber = staff.nextInt();
     System.out.println("Please enter the quantity");
     int quantity = staff.nextInt();
     System.out.println("Please enter the status");
     String status = staff.next();
     Order order = new Order(tableNumber, orderNumber, courseNumber, foodNumber, quantity, status);
     System.out.println("Order added");
     System.out.println("Please enter the course number");
     int courseNumber2 = staff.nextInt();
     System.out.println("Please enter the food number");
     int foodNumber2 = staff.nextInt();
     System.out.println("Please enter the quantity");
     int quantity2 = staff.nextInt();
     System.out.println("Please enter the status");
     String status2 = staff.next();
     Order order2 = new Order(tableNumber, orderNumber, courseNumber2, foodNumber2, quantity2, status2);
     System.out.println("Order added");
     System.out.println("Please enter the course number");
     int courseNumber3 = staff.nextInt();
     System.out.println("Please enter the food number");
     int foodNumber3 = staff.nextInt();
     System.out.println("Please enter the quantity");
     int quantity3 = staff.nextInt();
     System.out.println("Please enter the status");
     String status3 = staff.next();
     Order order3 = new Order(tableNumber, orderNumber, courseNumber3, foodNumber3, quantity3, status3);
     System.out.println("Order added");
     System.out.println("Please enter the course number");
     int courseNumber4 = staff.nextInt();
     System.out.println("Please enter the food number");
     int foodNumber4 = staff.nextInt();
     System.out.println("Please enter the quantity");
     int quantity4 = staff.nextInt();
     System.out.println("Please enter the status");
     String status4 = staff.next();
     Order order4 = new Order(tableNumber, orderNumber, courseNumber4, foodNumber4, quantity4, status4);
     System.out.println*/
