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

        Scanner scannerMain = new Scanner(System.in);;

        System.out.println(restaurant.getStaff());
        System.out.println("Enter your id");
        int id = scannerMain.nextInt();
        System.out.println("Enter your password");
        String password = scannerMain.next();

        Staff worker = restaurant.getStaff().get(restaurant.validStaff(id, password));
        String placeHolder = null;
        if (worker.getStaffType() == "Manager") {
            placeHolder = "You have access to: R)evise Staff B)ookings, T)ables, O)rder, P)ayment Records, E)xit ";
        } else if (worker.getStaffType() == "Waiter") {
            placeHolder = "You have access to: B)ookings, T)ables, O)rder, E)xit ";
        } else {
            placeHolder = "You have access to: O)rder, E)xit ";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Welcome, " + worker.getName() + " role: " + worker.getStaffType());
        System.out.println(sb + "\n" + placeHolder);

        while (more) {


            System.out.println("R)evise Staff B)ookings, T)ables, O)rder, P)ayment Records, E)xit");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();


            /**
             * Bookings
             */
            if (input.equals("R") && worker instanceof Manager) {
                System.out.println("A)dd staff V)iew staff R)emove staff");
                input = scanner.nextLine();
                if (input.equals("A")) {
                    System.out.println("Enter name");
                    String name = scanner.nextLine();
                    System.out.println("Enter id");
                    int id1 = scanner.nextInt();
                    System.out.println("Enter password");
                    String password1 = scanner.next();
                    System.out.println("Enter role: W)aiter, C)hef, M)anager");
                    String choice = scanner.next();
                    if (choice.equals("W")) {
                        restaurant.getStaff().add(new Waiter(name, id1, password1));
                    } else if (choice.equals("C")) {
                        restaurant.getStaff().add(new Chef(name, id1, password1));
                    } else if (choice.equals("M")) {
                        restaurant.getStaff().add(new Manager(name, id1, password1));
                    }

                } else if (input.equals("V")) {
                    System.out.println(restaurant.getStaff());
                } else if (input.equals("R")) {
                    System.out.println("Enter name");
                    String name = scanner.next();
                    System.out.println("Enter password");
                    String password1 = scanner.next();
                    restaurant.removeStaff(name, password1);
                }

            }

            /**
             * Bookings
             */

            else if (input.equals("B") && (worker instanceof Waiter || worker instanceof Manager)
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

                    CustomerInformation customer = new CustomerInformation(name, phoneNumber, time, numberOfGuests, occasion, allergies, requests);
                    bookings.addBooking(customer);
                    restaurant.getCustomerTable().writeToCsv("CSV files/Bookings.csv", customer);

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
                    bookings.addBooking(bookings.takeWalkIn(numberOfGuests));
                }

                /**
                 * Tables
                 */
            } else if (input.equals("T") && (worker instanceof Manager || worker instanceof Waiter)) {

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

                    Table table = new Table(tableNumber, tableCapacity);
                    restaurant.addTable(tableNumber, tableCapacity);
                    restaurant.getTablesTable().writeToCsv("CSV files/Tables.csv", table);

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
                    System.out.println("Enter Time of Arrival: ");
                    int timeOfArrival = scanner.nextInt();

                    //assigns bookings to tables
                    TableAssignment assign = new TableAssignment(restaurant, bookings.getBookingList().get(pos), timeOfArrival);
                    /**
                     * Display all Table Availability
                     */
                } else if (input.equals("D")) {
                    restaurant.checkAllAvailability();
                }

                /**
                 * Order
                 */
            } else if (input.equals("O") ) {


                //TODO add Menu.showFullMenu access
                //TODO OLAN? add all payment method accesses
                //TODO OLAN? add removal of order from order list when bill is paid
                //TODO OLAN? add check status on Orders

                System.out.println("S)how Menu, T)ake Order, V)iew Order, P)ay Bill, C)heck Status");
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
                    System.out.println("Enter number of Guests: ");
                    int numberOfGuests = scanner.nextInt();

                    order.takeOrder(restaurant.getTable(tableNumber), restaurant.getMenu(menuId), numberOfGuests);
                    restaurant.getOrderList().addOrder(order, tableNumber);

                    Bill a = new Bill(order);
                    restaurant.getBillTable().addBills(a);
                    restaurant.getBillTable().writeToCsv("CSV files/PaymentRecords.csv");

                    /**
                     * View Order
                     */
                } else if (input.equals("V")) {
                    System.out.println("Enter table number: ");
                    int tableNumber = scanner.nextInt();
                    if (restaurant.getOrderList().getOrder(tableNumber) == null) {
                        System.out.println("No orders for this table");
                    } else {
                        System.out.println(restaurant.getOrderList().getOrder(tableNumber).toString());
                    }


                }  else if (input.equals("S")) {
                    System.out.println("Enter menuId: ");

                    int i = scanner.nextInt();
                    restaurant.getMenu(i).showFullMenu();

                } else if (input.equals("P")) {
                    System.out.println("Enter Table Number: ");
                    int tableNumber = scanner.nextInt();
                    if (restaurant.getOrderList().getOrder(tableNumber) == null) {
                        System.out.println("No orders filed for this table");
                    } else {
                        System.out.println("Enter Payment Method:  (Cash/Card) ");
                        String paymentMethod = scanner.next();
                        if (paymentMethod.equals("Cash") || paymentMethod.equals("Card")) {
                            Bill bill = new Bill(restaurant.getOrderList().getOrder(tableNumber));
                            System.out.println(bill);
                            System.out.println("Enter Amount Paid: ");
                            double amountPaid = scanner.nextDouble();
                            bill.pay(amountPaid);
                            billTable.addBills(bill);
                            if (amountPaid >= bill.getTotalPrice()) {
                                restaurant.getOrderList().removeOrder(tableNumber);
                            }
                            billTable.writeToCsv("CSV files/PaymentRecords.csv");
                        } else {
                            System.out.println("Invalid Payment Method");
                        }
                    }

                    }else if(input.equals("C")) {
                    System.out.println("Enter Table Number: ");
                    int tableNumber = scanner.nextInt();
                    if (restaurant.getOrderList().getOrder(tableNumber) == null) {
                        System.out.println("No orders filed for this table");
                    } else {
                        System.out.println(restaurant.getOrderList().getOrder(tableNumber).getStatus());
                    }

                }



                /**
                 * Exit
                 */
            }else if(input.equals("P") && (worker instanceof Manager)) {
                System.out.println("A) for all records or D) for record on specified date");
                input = scanner.nextLine();
                if(input.equals("A")) {
                    BillCSV read = new BillCSV();
                    read.displayCSV("CSV files/PaymentRecords.csv");
                }else if(input.equals("D")) {
                    BillCSV read = new BillCSV();
                    System.out.println("Press Enter to continue");
                    read.readFromCSVByDate("CSV files/PaymentRecords.csv");
                }
            } else if (input.equals("E")) {

                more = false;

            } else {
                System.out.println("You do not have access, contact your manager");
            }
        }
    }
}

//public class RestaurantInterface {
//
//    /**
//     * This class is the main interface for the restaurant
//     *
//     * @param restaurant
//     * @param bookings
//     * @param billTable
//     */
//    public void run(Restaurant restaurant, BookingsList bookings, BillCSV billTable) {
//        boolean more = true;
//
//        Scanner scannerMain = new Scanner(System.in);
//
//
//        System.out.println(restaurant.getStaff());
//        System.out.println("Enter your id");
//        int id = scannerMain.nextInt();
//        System.out.println("Enter your password");
//        String password = scannerMain.next();
//
//
//        Staff worker = restaurant.getStaff().get(restaurant.validStaff(id, password));
//        String placeHolder = null;
//        if (worker.getStaffType() == "Manager") {
//            placeHolder = "You have access to: R)evise Staff B)ookings, T)ables, O)rder, P)ayment Records, E)xit ";
//        } else if (worker.getStaffType() == "Waiter") {
//            placeHolder = "You have access to: B)ookings, T)ables, O)rder, E)xit ";
//        } else if (worker.getStaffType() == "Chef") {
//            placeHolder = "You have access to: O)rder, E)xit ";
//        }
//
//
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("Welcome, " + worker.getName() + " role: " + worker.getStaffType());
//        System.out.println(sb);
//        System.out.println(placeHolder);
//
//        while (more) {
//            /**
//             * This is the main running for the restaurant
//             */
//
//            System.out.println("R)evise Staff B)ookings, T)ables, O)rder, P)ayment Records, E)xit");
//            Scanner scanner = new Scanner(System.in);
//            String input = scanner.nextLine();
//
//            /**
//             * Olan: allows to add, remove or view staff of the restaurant
//             */
//            if (input.equals("R") && worker instanceof Manager) {
//                System.out.println("A)dd staff V)iew staff R)emove staff");
//                input = scanner.nextLine();
//                if (input.equals("A")) {
//                    System.out.println("Enter name");
//                    String name = scanner.nextLine();
//                    System.out.println("Enter id");
//                    int id1 = scanner.nextInt();
//                    System.out.println("Enter password");
//                    String password1 = scanner.next();
//                    System.out.println("Enter role: W)aiter, C)hef, M)anager");
//                    String choice = scanner.next();
//                    if (choice.equals("W")) {
//                        restaurant.getStaff().add(new Waiter(name, id1, password1));
//                    } else if (choice.equals("C")) {
//                        restaurant.getStaff().add(new Chef(name, id1, password1));
//                    } else if (choice.equals("M")) {
//                        restaurant.getStaff().add(new Manager(name, id1, password1));
//                    }
//
//                } else if (input.equals("V")) {
//                    System.out.println(restaurant.getStaff());
//                } else if (input.equals("R")) {
//                    System.out.println("Enter name");
//                    String name = scanner.next();
//                    System.out.println("Enter password");
//                    String password1 = scanner.next();
//                    restaurant.removeStaff(name, password1);
//                }
//
//            }
//
//            /**
//             * Bookings
//             */
//
//            else if (input.equals("B") && (worker instanceof Waiter || worker instanceof Manager)) {
//
//                //TODO add booking to CSV file
//                System.out.println("A)dd Booking, V)iew Booking, S)how all bookings, C)ancel Booking, T)ake Walk-in");
//                input = scanner.nextLine();
//
//                /**
//                 * Add Booking
//                 */
//                if (input.equals("A")) {
//                    System.out.println("Enter Customer Name: ");
//                    String name = scanner.nextLine();
//                    System.out.println("Enter Customer Phone Number: ");
//                    String phoneNumber = scanner.nextLine();
//                    System.out.println("Time of Arrival: ");
//                    String time = scanner.nextLine();
//                    System.out.println("Enter Customer Number of Guests: ");
//                    String numberOfGuests = scanner.nextLine();
//                    System.out.println("Enter Occasion: ");
//                    String occasion = scanner.nextLine();
//                    System.out.println("Enter Allergies: ");
//                    String allergies = scanner.nextLine();
//                    System.out.println("Enter Special Requests: ");
//                    String requests = scanner.nextLine();
//
//                    bookings.addBooking(new CustomerInformation(name, phoneNumber, time, numberOfGuests, occasion, allergies, requests));
//
//
//                    /**
//                     * View Booking
//                     */
//                } else if (input.equals("V")) {
//                    System.out.println("Name of Customer: ");
//                    String name = scanner.nextLine();
//                    System.out.println("Phone Number of Customer: ");
//                    String phoneNumber = scanner.nextLine();
//
//                    bookings.checkBooking(name, phoneNumber);
//
//                    //TODO remove booking from CSV file
//
//                    /**
//                     * Show all bookings
//                     */
//                } else if (input.equals("S")) {
//                    System.out.println(bookings.getBookingList().toString());
//
//                    /**
//                     * Cancel Booking
//                     */
//                } else if (input.equals("C")) {
//                    System.out.println("Name of Customer: ");
//                    String name = scanner.nextLine();
//                    System.out.println("Phone Number of Customer: ");
//                    String phoneNumber = scanner.nextLine();
//                    bookings.cancelBooking(name, phoneNumber);
//
//                    /**
//                     * Take Walk-in
//                     */
//                } else if (input.equals("T")) {
//                    System.out.println("Enter number of guests: ");
//                    String numberOfGuests = scanner.nextLine();
//                    bookings.takeWalkIn(numberOfGuests);
//                }
//
//                /**
//                 * Tables
//                 */
//            } else if (input.equals("T") && (worker instanceof Manager)) {
//
//                System.out.println("A)dd Table, S)eat Table, C)hange Table Availability, D)isplay all Table Availability");
//                input = scanner.nextLine();
//
//                /**
//                 * Add Table
//                 */
//                if (input.equals("A")) {
//                    System.out.println("Enter Table Number: ");
//                    int tableNumber = scanner.nextInt();
//                    System.out.println("Enter Table Capacity: ");
//                    int tableCapacity = scanner.nextInt();
//
//                    restaurant.addTable(tableNumber, tableCapacity);
//
//
//                    /**
//                     * Change Table Availability
//                     */
//                } else if (input.equals("C")) {
//                    System.out.println("Enter Table Number: ");
//                    int tableNumber = scanner.nextInt();
//                    System.out.println("Enter Table Availability: true/false");
//                    Boolean tableAvailability = scanner.nextBoolean();
//                    restaurant.getTable(tableNumber - 1).setAvailable(tableAvailability); //
//
//
//                    /**
//                     * Seat Table
//                     */
//                } else if (input.equals("S")) {
//
//                    System.out.println("Enter Customer Name: ");
//                    String name = scanner.nextLine();
//                    int pos = bookings.getBooking(name);
//                    System.out.println("Enter Time of Arrival: ");
//                    int timeOfArrival = scanner.nextInt();
//
//                    //assigns bookings to tables
//                    TableAssignment assign = new TableAssignment(restaurant, bookings.getBookingList().get(pos), timeOfArrival);
//
//                    /**
//                     * Display all Table Availability
//                     */
//                } else if (input.equals("D")) {
//                    restaurant.checkAllAvailability();
//                }
//
//                /**
//                 * Order
//                 */
//            } else if (input.equals("O") && worker instanceof Waiter || worker instanceof Manager || worker instanceof Chef) {
//
//
//                //TODO add Menu.showFullMenu access
//                //TODO OLAN? add all payment method accesses
//                //TODO OLAN? add removal of order from order list when bill is paid
//                //TODO OLAN? add check status on Orders
//
//                System.out.println("S)how Menu, T)ake Order, V)iew Order, P)ay Bill, C)heck Status");
//                input = scanner.nextLine();
//
//                /**
//                 * Take Order
//                 */
//                if (input.equals("T")) {
//                    //take order
//
//                    Order order = new Order();
//                    System.out.println("Enter table number: ");
//                    int tableNumber = scanner.nextInt();
//                    System.out.println("Enter menuId: ");
//                    int menuId = scanner.nextInt();
//                    System.out.println("Enter number of Guests: ");
//                    int numberOfGuests = scanner.nextInt();
//
//                    order.takeOrder(restaurant.getTable(tableNumber), restaurant.getMenu(menuId), numberOfGuests);
//                    restaurant.getOrderList().addOrder(order, tableNumber);
//
//                    Bill a = new Bill(order);
//                    billTable.addBills(a);
//                    billTable.writeToCsv("CSV files/PaymentRecords.csv");
//
//                    /**
//                     * View Order
//                     */
//                } else if (input.equals("V")) {
//                    System.out.println("Enter table number: ");
//                    int tableNumber = scanner.nextInt();
//                    if (restaurant.getOrderList().getOrder(tableNumber) == null) {
//                        System.out.println("No orders for this table");
//                    } else {
//                        System.out.println(restaurant.getOrderList().getOrder(tableNumber).toString());
//                    }
//
//                } else if (input.equals("S")) {
//                    System.out.println("Enter menuId: ");
//                    int i = scanner.nextInt();
//                    restaurant.getMenu(i).showFullMenu();
//                } else if (input.equals("P")) {
//                    System.out.println("Enter Table Number: ");
//                    int tableNumber = scanner.nextInt();
//                    if (restaurant.getOrderList().getOrder(tableNumber) == null) {
//                        System.out.println("No orders filed for this table");
//                    } else {
//                        System.out.println("Enter Payment Method:  (Cash/Card) ");
//                        String paymentMethod = scanner.next();
//                        if (paymentMethod.equals("Cash") || paymentMethod.equals("Card")) {
//                            Bill bill = new Bill(restaurant.getOrderList().getOrder(tableNumber));
//                            System.out.println(bill);
//                            System.out.println("Enter Amount Paid: ");
//                            double amountPaid = scanner.nextDouble();
//                            bill.pay(amountPaid);
//                            billTable.addBills(bill);
//                            if (amountPaid >= bill.getTotalPrice()) {
//                                restaurant.getOrderList().removeOrder(tableNumber);
//                            }
//                            billTable.writeToCsv("CSV files/PaymentRecords.csv");
//                        } else {
//                            System.out.println("Invalid Payment Method");
//                        }
//                    }
//                } else if (input.equals("C")) {
//                    System.out.println("Enter Table Number: ");
//                    int tableNumber = scanner.nextInt();
//                    System.out.println(restaurant.getOrderList().getOrder(tableNumber).checkStatusChef("Chef"));
//                }
//                /**
//                 * Exit
//                 */
//            } else if  (input.equals("P") && (worker instanceof Manager)) {
//                System.out.println("A) for all records or D) for record on specified date");
//                input = scanner.nextLine();
//                if (input.equals("A")) {
//                    BillCSV read = new BillCSV();
//                    read.displayCSV("CSV files/PaymentRecords.csv");
//                } else if (input.equals("D")) {
//                    BillCSV read = new BillCSV();
//                    System.out.println("Press Enter to continue");
//                    read.readFromCSVByDate("CSV files/PaymentRecords.csv");
//                }
//            } else if (input.equals("E")) {
//                more = false;
//
//            } else {
//                System.out.println("You do not have access, contact your manager");
//            }
//        }
//    }
//}
