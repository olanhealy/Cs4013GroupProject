package GP.src;

import java.util.Scanner;

public class RestaurantInterface {

    public void run(Staff staff, Restaurant restaurant, BookingsList bookings, BillCSV write) {
        boolean more = true;

        while (more) {
            Scanner scanner = new Scanner(System.in);
            staff.addStaff(staff.getStaffList());
            System.out.println(staff.getStaffList());
            System.out.println("Enter staff ID");
            int id = scanner.nextInt();
            System.out.println("Enter password");
            String password = scanner.next();
            if (staff.validStaff(id, password, staff.getStaffList())) {
                for (Staff s : staff.getStaffList()) {
                    if (s.getId() == id) {

                        if (s instanceof Manager) {
                            System.out.println("Welcome, " + staff.getName() + ". Logged in as  Manager");
                            System.out.println("B)ookings, T)ables, O)rder, E)xit");
                            String input = scanner.next();
                            if (input.equals("B")) {
                                //TODO add booking to CSV file
                                System.out.println("A)dd Booking, V)iew Booking, C)ancel Booking, T)ake Walk-in");
                                input = scanner.next();

                                if (input.equals("A")) {
                                    System.out.println("Enter Customer Name: ");
                                    String name = scanner.next();
                                    System.out.println("Enter Customer Phone Number: ");
                                    String phoneNumber = scanner.next();
                                    System.out.println("Time of Arrival: ");
                                    String time = scanner.next();
                                    System.out.println("Enter Customer Number of Guests: ");
                                    String numberOfGuests = scanner.next();
                                    System.out.println("Enter Occasion: ");
                                    String occasion = scanner.next();
                                    System.out.println("Enter Allergies: ");
                                    String allergies = scanner.next();
                                    System.out.println("Enter Special Requests: ");
                                    String requests = scanner.next();

                                    bookings.addBooking(new CustomerInformation(name, phoneNumber, time, numberOfGuests, occasion, allergies, requests));
                                    //readCI.writeToCsv("CSV files/Bookings.csv", Bookings);
                                } else if (input.equals("V")) {

                                    System.out.println("Name of Customer: ");
                                    String name = scanner.next();
                                    System.out.println("Phone Number of Customer: ");
                                    String phoneNumber = scanner.next();
                                    //TODO remove booking from CSV file

                                    bookings.checkBooking(name, phoneNumber);
                                } else if (input.equals("C")) {
                                    System.out.println("Name of Customer: ");
                                    String name = scanner.next();
                                    System.out.println("Phone Number of Customer: ");
                                    String phoneNumber = scanner.next();
                                    bookings.cancelBooking(name, phoneNumber);
                                } else if (input.equals("T")) {
                                    System.out.println("Enter number of guests: ");
                                    String numberOfGuests = scanner.next();
                                    bookings.takeWalkIn(numberOfGuests);
                                }

                            } else if (input.equals("T")) {

                                System.out.println("A)dd Table, S)eat Table, C)hange Table Availability, D)isplay all Table Availability");

                                input = scanner.next();
                                if (input.equals("A")) {
                                    System.out.println("Enter Table Number: ");
                                    int tableNumber = scanner.nextInt();
                                    System.out.println("Enter Table Capacity: ");
                                    int tableCapacity = scanner.nextInt();

                                    restaurant.addTable(tableNumber, tableCapacity);

                                } else if (input.equals("C")) {
                                    System.out.println("Enter Table Number: ");
                                    int tableNumber = scanner.nextInt();
                                    System.out.println("Enter Table Availability: true/false");
                                    Boolean tableAvailability = scanner.nextBoolean();
                                    restaurant.getTable(tableNumber).setAvailable(tableAvailability);


                                } else if (input.equals("S")) {

                                    System.out.println("Enter Customer Name: ");
                                    String name = scanner.next();
                                    int pos = bookings.getBooking(name);
                                    System.out.println("Enter Time of Arrival: ");
                                    int timeOfArrival = scanner.nextInt();

                                    //assigns bookings to tables
                                    TableAssignment assign = new TableAssignment(restaurant, bookings.getBookingList().get(pos), timeOfArrival);

                                } else if (input.equals("D")) {
                                    restaurant.checkAllAvailability();
                                }

                            } else if (input.equals("O")) {
                                //TODO add all payment method accesses

                                //TODO add Menu.showFullMenu access
                                //TODO add get Orders to get arraylist of orders
                                //TODO add Order complete method to remove it from order array
                                //TODO add check status on Orders

                                System.out.println("T)ake Order, V)iew Order");
                                input = scanner.next();

                                if (input.equals("T")) {
                                    //take order
                                    Order order = new Order();
                                    System.out.println("Enter table number: ");
                                    int tableNumber = scanner.nextInt();
                                    System.out.println("Enter menuId: ");
                                    int menuId = scanner.nextInt();
                                    order.takeOrder(restaurant.getTable(tableNumber), restaurant.getMenu(menuId));

                                    Bill a = new Bill("Card", order);
                                    write.addBills(a);
                                    write.writeToCsv("CSV files/PaymentRecords.csv");

                                } else if (input.equals("V")) {
                                    //view order

                                }
                            } else if (input.equals("E")) {

                                more = false;

                            }
                        }
                        if (s instanceof Waiter) {
                            System.out.println("Welcome, " + staff.getName() + ". Logged in as  Waiter");
                            System.out.println("T)ables, O)rder,  E)xit");
                            String input = scanner.next();
                            if (input.equals("T")) {

                                System.out.println("A)dd Table, S)eat Table, C)hange Table Availability, D)isplay all Table Availability");

                                input = scanner.next();
                                if (input.equals("A")) {
                                    System.out.println("Enter Table Number: ");
                                    int tableNumber = scanner.nextInt();
                                    System.out.println("Enter Table Capacity: ");
                                    int tableCapacity = scanner.nextInt();

                                    restaurant.addTable(tableNumber, tableCapacity);

                                } else if (input.equals("C")) {
                                    System.out.println("Enter Table Number: ");
                                    int tableNumber = scanner.nextInt();
                                    System.out.println("Enter Table Availability: true/false");
                                    Boolean tableAvailability = scanner.nextBoolean();
                                    restaurant.getTable(tableNumber).setAvailable(tableAvailability);


                                } else if (input.equals("S")) {

                                    System.out.println("Enter Customer Name: ");
                                    String name = scanner.next();
                                    int pos = bookings.getBooking(name);
                                    System.out.println("Enter Time of Arrival: ");
                                    int timeOfArrival = scanner.nextInt();

                                    //assigns bookings to tables
                                    TableAssignment assign = new TableAssignment(restaurant, bookings.getBookingList().get(pos), timeOfArrival);

                                } else if (input.equals("D")) {
                                    restaurant.checkAllAvailability();
                                }
                            } else if (input.equals("O")) {
                                //TODO add all payment method accesses

                                //TODO add Menu.showFullMenu access
                                //TODO add get Orders to get arraylist of orders
                                //TODO add Order complete method to remove it from order array
                                //TODO add check status on Orders
                                System.out.println("T)ake Order, V)iew Order");
                                input = scanner.next();

                                if (input.equals("T")) {
                                    //take order
                                    Order order = new Order();
                                    System.out.println("Enter table number: ");
                                    int tableNumber = scanner.nextInt();
                                    System.out.println("Enter menuId: ");
                                    int menuId = scanner.nextInt();
                                    order.takeOrder(restaurant.getTable(tableNumber), restaurant.getMenu(menuId));

                                    Bill a = new Bill("Card", order);
                                    write.addBills(a);
                                    write.writeToCsv("CSV files/PaymentRecords.csv");

                                } else if (input.equals("V")) {
                                    //view order

                                }
                            } else if (input.equals("E")) {

                                more = false;

                            }
                        }
                        if (s instanceof Chef) {
                            System.out.println("Welcome, " + staff.getName() + ". Logged in as  Chef");
                            //TODO add all payment method accesses

                            //TODO add Menu.showFullMenu access
                            //TODO add get Orders to get arraylist of orders
                            //TODO add Order complete method to remove it from order array
                            //TODO add check status on Orders
                            System.out.println("O)rder, E)xit");
                            String input = scanner.next();
                            System.out.println("T)ake Order, V)iew Order");
                            input = scanner.next();

                            if (input.equals("T")) {
                                //take order
                                Order order = new Order();
                                System.out.println("Enter table number: ");
                                int tableNumber = scanner.nextInt();
                                System.out.println("Enter menuId: ");
                                int menuId = scanner.nextInt();
                                order.takeOrder(restaurant.getTable(tableNumber), restaurant.getMenu(menuId));

                                Bill a = new Bill("Card", order);
                                write.addBills(a);
                                write.writeToCsv("CSV files/PaymentRecords.csv");
                            } else if (input.equals("V")) {
                                    //TODO view order
                                } else if (input.equals("E")) {
                                more = false;

                            }
                            //TODO Kev: try run nd u will see like after say manager u add in person it makes u login again,
                            //TODO need to fix. Also, exit just kills the app so need look at that. Also the getname just always gets
                            //TODO ur name (lol) so need to fix that. And erm thinking of adding staff csv file for adding staff

                        }
                    }
                }
            }
        }
    }
}





