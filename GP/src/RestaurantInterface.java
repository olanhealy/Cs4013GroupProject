package GP.src;

import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantInterface {

    /**
     * This class is the main interface for the restaurant
     *
     * @param restaurant
     * @param bookings
     * @param billTable
     */
    public void run(Restaurant restaurant, BookingsList bookings, BillCSV billTable) {
        boolean more = true;
//        Scanner scannerMain = new Scanner(System.in);
//        staff.addStaff(staff.getStaffList());
//        System.out.println(staff.getStaffList());
//        System.out.println("Enter your id");
//        int id = scannerMain.nextInt();
//        System.out.println("Enter your password");
//        String password = scannerMain.next();
//
//
//        if (staff.validStaff(id, password, staff.getStaffList())) {
//            for (Staff s : staff.getStaffList()) {
//                if (s.getId() == id) {
//                    System.out.println("Welcome, " + s.getName());
//                    more = true;
//                    break;
//
//                }
//            }
//        }



        while (more) {


            System.out.println("B)ookings, T)ables, O)rder, E)xit");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            /**
             * Bookings
             */
            if (input.equals("B")
 //                   && (staff instanceof Waiter || staff instanceof Manager)
            ) {

                //TODO add booking to CSV file
                System.out.println("A)dd Booking, V)iew Booking, S)how all bookings, C)ancel Booking, T)ake Walk-in");
                input = scanner.nextLine();

                /**
                 * Add Booking
                 */
                if (input.equals("A")) {
                    System.out.println("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter Customer Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Time of Arrival: ");
                    String time = scanner.nextLine();
                    System.out.println("Enter Customer Number of Guests: ");
                    String numberOfGuests = scanner.nextLine();
                    System.out.println("Enter Occasion: ");
                    String occasion = scanner.nextLine();
                    System.out.println("Enter Allergies: ");
                    String allergies = scanner.nextLine();
                    System.out.println("Enter Special Requests: ");
                    String requests = scanner.nextLine();

                    bookings.addBooking(new CustomerInformation(name, phoneNumber, time, numberOfGuests, occasion, allergies, requests));


                    /**
                     * View Booking
                     */
                } else if (input.equals("V")) {
                    System.out.println("Name of Customer: ");
                    String name = scanner.nextLine();
                    System.out.println("Phone Number of Customer: ");
                    String phoneNumber = scanner.nextLine();

                    bookings.checkBooking(name, phoneNumber);

                    //TODO remove booking from CSV file

                    /**
                     * Show all bookings
                     */
                }else if(input.equals("S")){
                    System.out.println(bookings.getBookingList().toString());

                    /**
                     * Cancel Booking
                     */
                } else if (input.equals("C")) {
                    System.out.println("Name of Customer: ");
                    String name = scanner.nextLine();
                    System.out.println("Phone Number of Customer: ");
                    String phoneNumber = scanner.nextLine();
                    bookings.cancelBooking(name, phoneNumber);

                    /**
                     * Take Walk-in
                     */
                } else if (input.equals("T")) {
                    System.out.println("Enter number of guests: ");
                    String numberOfGuests = scanner.nextLine();
                    bookings.takeWalkIn(numberOfGuests);
                }

                /**
                 * Tables
                 */
            } else if (input.equals("T")
                    //&& (staff instanceof Manager)
             ) {

                System.out.println("A)dd Table, S)eat Table, C)hange Table Availability, D)isplay all Table Availability");
                input = scanner.nextLine();

                /**
                 * Add Table
                 */
                if (input.equals("A")) {
                    System.out.println("Enter Table Number: ");
                    int tableNumber = scanner.nextInt();
                    System.out.println("Enter Table Capacity: ");
                    int tableCapacity = scanner.nextInt();

                    restaurant.addTable(tableNumber, tableCapacity);


                    /**
                     * Change Table Availability
                     */
                } else if (input.equals("C")) {
                    System.out.println("Enter Table Number: ");
                    int tableNumber = scanner.nextInt();
                    System.out.println("Enter Table Availability: true/false");
                    Boolean tableAvailability = scanner.nextBoolean();
                    restaurant.getTable(tableNumber - 1).setAvailable(tableAvailability); //


                    /**
                     * Seat Table
                     */
                } else if (input.equals("S")) {

                    System.out.println("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    int pos = bookings.getBooking(name);
//                    System.out.println("Enter Time of Arrival: ");
//                    int timeOfArrival = scanner.nextInt();

                    //assigns bookings to tables
                    TableAssignment assign = new TableAssignment(restaurant, bookings.getBookingList().get(pos));

                    /**
                     * Display all Table Availability
                     */
                } else if (input.equals("D")) {
                    restaurant.checkAllAvailability();
                }

                /**
                 * Order
                 */
            } else if (input.equals("O")) {


                //TODO add Menu.showFullMenu access
                //TODO OLAN? add all payment method accesses
                //TODO OLAN? add removal of order from order list when bill is paid
                //TODO OLAN? add check status on Orders

                System.out.println("S)how Menu, T)ake Order, V)iew Order");
                input = scanner.nextLine();

                /**
                 * Take Order
                 */
                if (input.equals("T")) {
                    //take order
                    Order order = new Order();
                    System.out.println("Enter table number: ");
                    int tableNumber = scanner.nextInt();
                    System.out.println("Enter menuId: ");
                    int menuId = scanner.nextInt();
                    order.takeOrder(restaurant.getTable(tableNumber), restaurant.getMenu(menuId));
                    restaurant.getOrderList().addOrder(order, tableNumber);

                    Bill a = new Bill("Card", order);
                    billTable.addBills(a);
                    billTable.writeToCsv("CSV files/PaymentRecords.csv");

                    /**
                     * View Order
                     */
                } else if (input.equals("V")) {
                    System.out.println("Enter table number: ");
                    int tableNumber = scanner.nextInt();
                    System.out.println(restaurant.getOrderList().getOrder(tableNumber).toString());
                } else if (input.equals("S")) {
                    System.out.println("Enter menuId: ");
                    int i = scanner.nextInt();
                    restaurant.getMenu(i).showFullMenu();
                }

                /**
                 * Exit
                 */
            } else if (input.equals("E")) {

                more = false;

//            } else {
//                System.out.println("Access is not allowed. Request access from your manager");
            }
        }
    }
}