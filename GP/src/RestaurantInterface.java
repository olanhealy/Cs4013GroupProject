package GP.src;

import java.util.Scanner;

public class RestaurantInterface {

    public void run (Restaurant restaurant, BookingsList bookings, BillCSV write){
            boolean more = true;

            while (more)
            {

        Scanner scanner = new Scanner(System.in);
        System.out.println("B)ookings, T)ables, O)rder, E)xit");

        String input = scanner.nextLine();

        if (input.equals("B")) {

            System.out.println("A)dd Booking, V)iew Booking, C)ancel Booking, T)ake Walk-in");
            input = scanner.nextLine();

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
                //readCI.writeToCsv("CSV files/Bookings.csv", Bookings);
            } else if (input.equals("V")) {
                System.out.println("Name of Customer: ");
                String name = scanner.nextLine();
                System.out.println("Phone Number of Customer: ");
                String phoneNumber = scanner.nextLine();

                bookings.checkBooking(name, phoneNumber);
            } else if (input.equals("C")) {
                System.out.println("Name of Customer: ");
                String name = scanner.nextLine();
                System.out.println("Phone Number of Customer: ");
                String phoneNumber = scanner.nextLine();
                bookings.cancelBooking(name, phoneNumber);
            } else if (input.equals("T")) {
                System.out.println("Enter number of guests: ");
                String numberOfGuests = scanner.nextLine();
                bookings.takeWalkIn(numberOfGuests);
            }

        } else if (input.equals("T")) {

            System.out.println("A)dd Table, S)eat Table, C)hange Table Availability, D)isplay all Table Availability");

            input = scanner.nextLine();
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
                String name = scanner.nextLine();
                int pos = bookings.getBooking(name);
                System.out.println("Enter Time of Arrival: ");
                int timeOfArrival = scanner.nextInt();

                //assigns bookings to tables
                TableAssignment assign = new TableAssignment(restaurant, bookings.getBookingList().get(pos), timeOfArrival);

            } else if (input.equals("D")) {
                restaurant.checkAllAvailability();
            }

        } else if (input.equals("O")) {

            System.out.println("T)ake Order, V)iew Order");
            input = scanner.nextLine();

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
    }
}
