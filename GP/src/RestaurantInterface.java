package GP.src;

import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantInterface {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Staff> staffList;

    public void staffLogin(Staff staff) {
        boolean runStaff = true;
        staff.addStaff(staff.getStaffList());
        System.out.println(staff.getStaffList());
        while (runStaff) {
            System.out.println("Enter your id");
            int id = scanner.nextInt();
            System.out.println("Enter your password");
            String password = scanner.next();
            if (staff.validStaff(id, password, staff.getStaffList())) {
                Staff restaurantStaff;
                int index = 0;
                for (Staff s : staff.getStaffList()) {
                    if (s.getId() == id) {
                        index = staff.getStaffList().indexOf(s);
                        break;
                    }
                }

                restaurantStaff = staff.getStaffList().get(index);
                runStaff = run(restaurantStaff);

            } else if (!staff.validStaff(id, password, staff.getStaffList())) {
                System.out.println("Invalid login");
                runStaff = false;
            }

        }

    }

    private boolean run(Staff restaurantStaff) {
        boolean run = true;
        while (run)
            if (restaurantStaff instanceof Waiter) {
                System.out.println("Hello, " + restaurantStaff.getName() + "|| ROLE: " + restaurantStaff.getClass().getSimpleName());
                System.out.println("T)ables, O)rder,  E)xit");
                String input = scanner.next();
                run = waiterInput(input, (Waiter) restaurantStaff);
            } else if (restaurantStaff instanceof Chef) {
                System.out.println("Hello, " + restaurantStaff.getName() + " || ROLE: " + restaurantStaff.getClass().getSimpleName());
                System.out.println("O)rder,  E)xit");
                String input = scanner.next();
                run = chefInput(input, (Chef) restaurantStaff);
            } else if (restaurantStaff instanceof Manager) {
                System.out.println("Hello, " + restaurantStaff.getName() + "|| ROLE: " + restaurantStaff.getClass().getSimpleName());
                System.out.println("B)ookings, T)ables, O)rder,  E)xit");
                String input = scanner.next();

                run = managerInput(input, (Manager) restaurantStaff);
            }
        return run;
    }

    private boolean managerInput(String input, Manager restaurantStaff) { //TODO add in restaraunt bill etc here getting error
        boolean runManager = true;
        Restaurant restaurant = new Restaurant();
        BookingsList bookings = new BookingsList();
        BillCSV write = new BillCSV();

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

            runManager = false;
        }
        return runManager;
    }





    private boolean chefInput(String input, Chef restaurantStaff) {
        boolean runChef = true;
        Restaurant restaurant = new Restaurant();
        BookingsList bookings = new BookingsList();

        BillCSV write = new BillCSV();

        //TODO add all payment method accesses

        //TODO add Menu.showFullMenu access
        //TODO add get Orders to get arraylist of orders
        //TODO add Order complete method to remove it from order array
        //TODO add check status on Order
        while (runChef)
            if (input.equals("O")) {
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
                    runChef = false;

                }
            }
        return runChef;
    }









        private boolean waiterInput (String input, Waiter restaurantStaff){
            boolean runWaiter = true;
            Restaurant restaurant = new Restaurant();
            BookingsList bookings = new BookingsList();
            BillCSV write = new BillCSV();
            while (runWaiter)
                switch (input) {
                    case "B":
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

                        break;
                    case "T":

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

                        break;
                    case "O":
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
                        break;
                    case "E":
                        runWaiter = false;
                        break;
            }
            return runWaiter;
        }

    }






//    public void test(Restaurant restaurant, BookingsList bookings, BillCSV write){
//            boolean more = true;
//        while (more) {
//
//
//                        if (s instanceof Manager) {
//                            System.out.println("Welcome, " + staff.getName() + ". Logged in as  Manager");
//                            System.out.println("B)ookings, T)ables, O)rder, E)xit");
//                            String input = scanner.next();
//                            if (input.equals("B")) {
//                                //TODO add booking to CSV file
//                                System.out.println("A)dd Booking, V)iew Booking, C)ancel Booking, T)ake Walk-in");
//                                input = scanner.next();
//
//                                if (input.equals("A")) {
//                                    System.out.println("Enter Customer Name: ");
//                                    String name = scanner.next();
//                                    System.out.println("Enter Customer Phone Number: ");
//                                    String phoneNumber = scanner.next();
//                                    System.out.println("Time of Arrival: ");
//                                    String time = scanner.next();
//                                    System.out.println("Enter Customer Number of Guests: ");
//                                    String numberOfGuests = scanner.next();
//                                    System.out.println("Enter Occasion: ");
//                                    String occasion = scanner.next();
//                                    System.out.println("Enter Allergies: ");
//                                    String allergies = scanner.next();
//                                    System.out.println("Enter Special Requests: ");
//                                    String requests = scanner.next();
//
//                                    bookings.addBooking(new CustomerInformation(name, phoneNumber, time, numberOfGuests, occasion, allergies, requests));
//                                    //readCI.writeToCsv("CSV files/Bookings.csv", Bookings);
//                                } else if (input.equals("V")) {
//
//                                    System.out.println("Name of Customer: ");
//                                    String name = scanner.next();
//                                    System.out.println("Phone Number of Customer: ");
//                                    String phoneNumber = scanner.next();
//                                    //TODO remove booking from CSV file
//
//                                    bookings.checkBooking(name, phoneNumber);
//                                } else if (input.equals("C")) {
//                                    System.out.println("Name of Customer: ");
//                                    String name = scanner.next();
//                                    System.out.println("Phone Number of Customer: ");
//                                    String phoneNumber = scanner.next();
//                                    bookings.cancelBooking(name, phoneNumber);
//                                } else if (input.equals("T")) {
//                                    System.out.println("Enter number of guests: ");
//                                    String numberOfGuests = scanner.next();
//                                    bookings.takeWalkIn(numberOfGuests);
//                                }
//
//                            } else if (input.equals("T")) {
//
//                                System.out.println("A)dd Table, S)eat Table, C)hange Table Availability, D)isplay all Table Availability");
//
//                                input = scanner.next();
//                                if (input.equals("A")) {
//                                    System.out.println("Enter Table Number: ");
//                                    int tableNumber = scanner.nextInt();
//                                    System.out.println("Enter Table Capacity: ");
//                                    int tableCapacity = scanner.nextInt();
//
//                                    restaurant.addTable(tableNumber, tableCapacity);
//
//                                } else if (input.equals("C")) {
//                                    System.out.println("Enter Table Number: ");
//                                    int tableNumber = scanner.nextInt();
//                                    System.out.println("Enter Table Availability: true/false");
//                                    Boolean tableAvailability = scanner.nextBoolean();
//                                    restaurant.getTable(tableNumber).setAvailable(tableAvailability);
//
//
//                                } else if (input.equals("S")) {
//
//                                    System.out.println("Enter Customer Name: ");
//                                    String name = scanner.next();
//                                    int pos = bookings.getBooking(name);
//                                    System.out.println("Enter Time of Arrival: ");
//                                    int timeOfArrival = scanner.nextInt();
//
//                                    //assigns bookings to tables
//                                    TableAssignment assign = new TableAssignment(restaurant, bookings.getBookingList().get(pos), timeOfArrival);
//
//                                } else if (input.equals("D")) {
//                                    restaurant.checkAllAvailability();
//                                }
//
//                            } else if (input.equals("O")) {
//                                //TODO add all payment method accesses
//
//                                //TODO add Menu.showFullMenu access
//                                //TODO add get Orders to get arraylist of orders
//                                //TODO add Order complete method to remove it from order array
//                                //TODO add check status on Orders
//
//                                System.out.println("T)ake Order, V)iew Order");
//                                input = scanner.next();
//
//                                if (input.equals("T")) {
//                                    //take order
//                                    Order order = new Order();
//                                    System.out.println("Enter table number: ");
//                                    int tableNumber = scanner.nextInt();
//                                    System.out.println("Enter menuId: ");
//                                    int menuId = scanner.nextInt();
//                                    order.takeOrder(restaurant.getTable(tableNumber), restaurant.getMenu(menuId));
//
//                                    Bill a = new Bill("Card", order);
//                                    write.addBills(a);
//                                    write.writeToCsv("CSV files/PaymentRecords.csv");
//
//                                } else if (input.equals("V")) {
//                                    //view order
//
//                                }
//                            } else if (input.equals("E")) {
//
//                                more = false;
//
//                            }
//                        }
//                        if (s instanceof Waiter) {
//                            System.out.println("Welcome, " + staff.getName() + ". Logged in as  Waiter");
//                            System.out.println("T)ables, O)rder,  E)xit");
//                            String input = scanner.next();
//                            if (input.equals("T")) {
//
//                                System.out.println("A)dd Table, S)eat Table, C)hange Table Availability, D)isplay all Table Availability");
//
//                                input = scanner.next();
//                                if (input.equals("A")) {
//                                    System.out.println("Enter Table Number: ");
//                                    int tableNumber = scanner.nextInt();
//                                    System.out.println("Enter Table Capacity: ");
//                                    int tableCapacity = scanner.nextInt();
//
//                                    restaurant.addTable(tableNumber, tableCapacity);
//
//                                } else if (input.equals("C")) {
//                                    System.out.println("Enter Table Number: ");
//                                    int tableNumber = scanner.nextInt();
//                                    System.out.println("Enter Table Availability: true/false");
//                                    Boolean tableAvailability = scanner.nextBoolean();
//                                    restaurant.getTable(tableNumber).setAvailable(tableAvailability);
//
//
//                                } else if (input.equals("S")) {
//
//                                    System.out.println("Enter Customer Name: ");
//                                    String name = scanner.next();
//                                    int pos = bookings.getBooking(name);
//                                    System.out.println("Enter Time of Arrival: ");
//                                    int timeOfArrival = scanner.nextInt();
//
//                                    //assigns bookings to tables
//                                    TableAssignment assign = new TableAssignment(restaurant, bookings.getBookingList().get(pos), timeOfArrival);
//
//                                } else if (input.equals("D")) {
//                                    restaurant.checkAllAvailability();
//                                }
//                            } else if (input.equals("O")) {
//                                //TODO add all payment method accesses
//
//                                //TODO add Menu.showFullMenu access
//                                //TODO add get Orders to get arraylist of orders
//                                //TODO add Order complete method to remove it from order array
//                                //TODO add check status on Orders
//                                System.out.println("T)ake Order, V)iew Order");
//                                input = scanner.next();
//
//                                if (input.equals("T")) {
//                                    //take order
//                                    Order order = new Order();
//                                    System.out.println("Enter table number: ");
//                                    int tableNumber = scanner.nextInt();
//                                    System.out.println("Enter menuId: ");
//                                    int menuId = scanner.nextInt();
//                                    order.takeOrder(restaurant.getTable(tableNumber), restaurant.getMenu(menuId));
//
//                                    Bill a = new Bill("Card", order);
//                                    write.addBills(a);
//                                    write.writeToCsv("CSV files/PaymentRecords.csv");
//
//                                } else if (input.equals("V")) {
//                                    //view order
//
//                                }
//                            } else if (input.equals("E")) {
//
//                                more = false;
//
//                            }
//                        }
//                        if (s instanceof Chef) {
//                            System.out.println("Welcome, " + staff.getName() + ". Logged in as  Chef");
//                            //TODO add all payment method accesses
//
//                            //TODO add Menu.showFullMenu access
//                            //TODO add get Orders to get arraylist of orders
//                            //TODO add Order complete method to remove it from order array
//                            //TODO add check status on Orders
//                            System.out.println("O)rder, E)xit");
//                            String input = scanner.next();
//                            System.out.println("T)ake Order, V)iew Order");
//                            input = scanner.next();
//
//                            if (input.equals("T")) {
//                                //take order
//                                Order order = new Order();
//                                System.out.println("Enter table number: ");
//                                int tableNumber = scanner.nextInt();
//                                System.out.println("Enter menuId: ");
//                                int menuId = scanner.nextInt();
//                                order.takeOrder(restaurant.getTable(tableNumber), restaurant.getMenu(menuId));
//
//                                Bill a = new Bill("Card", order);
//                                write.addBills(a);
//                                write.writeToCsv("CSV files/PaymentRecords.csv");
//                            } else if (input.equals("V")) {
//                                    //TODO view order
//                                } else if (input.equals("E")) {
//                                more = false;
//
//                            }
//                            //TODO Kev: try run nd u will see like after say manager u add in person it makes u login again,
//                            //TODO need to fix. Also, exit just kills the app so need look at that. Also the getname just always gets
//                            //TODO ur name (lol) so need to fix that. And erm thinking of adding staff csv file for adding staff
//
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
//
//
//
//
