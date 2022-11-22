package GP.src;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * This class assigns customers to tables based on the number of guests and time
 * @author Kevin Collins
 */
public class TableAssignment {

    private int time;

    //getters
    public int getTime() { return time;}

    /**
     * Assigns guest to a table
     * <p>
     *     If the current time equals time of booking then assigns table
     * </p>
     * @param restaurant restaurant in which takes place
     * @param customer customer that's being seated info
     */
    public TableAssignment(Restaurant restaurant, CustomerInformation customer) {
        Scanner scanner = new Scanner(System.in);
        boolean tableFound = false;
        this.time = LocalDateTime.now().getHour();

        if (getTime() == customer.getTimeOfArrival()) {
            for (int i = 0; i < restaurant.getSeatLayout().size(); i++) {
                if (customer.getNumberOfGuests() == restaurant.getSeatLayout().get(i).getNumberOfSeats() && restaurant.getSeatLayout().get(i).getAvailability()) {
                    seatTable(customer, restaurant.getSeatLayout().get(i));
                    tableFound = true;
                    break;
                }
            }

            if (!tableFound) {

            System.out.println("No tables available for " + customer.getNumberOfGuests() + " guests");
            System.out.println("Search other size tables? (Y/N)");

            if (scanner.nextLine().equalsIgnoreCase("y")) {
                for (int i = 0; i < restaurant.getSeatLayout().size(); i++) {
                    if (restaurant.getSeatLayout().get(i).getNumberOfSeats() > customer.getNumberOfGuests()) {
                        System.out.println("Table " + restaurant.getSeatLayout().get(i).getTableNumber() + " is available");
                    }
                }
                System.out.println("Would you like to be seated at a larger table? (Y/N)");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    System.out.println("Which table would you like to be seated at?");
                    int tableNo = scanner.nextInt();
                    for (int i = 0; i < restaurant.getSeatLayout().size(); i++) {
                        if (restaurant.getSeatLayout().get(i).getTableNumber() == tableNo) {
                            seatTable(customer, restaurant.getSeatLayout().get(i));
                            break;
                        }
                    }
                }

                }
            }

        }
    }



    /**
     * Has additional functionality if time is required to be manually added (pre-seat) for testing and example
     * @param restaurant restaurant in which takes place
     * @param customer customer that's being seated info
     * @param time manual time inputted inb
     */
    public TableAssignment(Restaurant restaurant,CustomerInformation customer,int time){
        Scanner scanner = new Scanner(System.in);
        boolean tableFound = false;
        this.time = time;
            if (getTime() == customer.getTimeOfArrival()) {
                for (int i = 0; i < restaurant.getSeatLayout().size(); i++) {
                    if (customer.getNumberOfGuests() == restaurant.getSeatLayout().get(i).getNumberOfSeats()){
                        seatTable(customer, restaurant.getSeatLayout().get(i));
                        break;
                    }
                }
            }
        if (!tableFound) {

            System.out.println("No tables available for " + customer.getNumberOfGuests() + " guests");
            System.out.println("Search other size tables? (Y/N)");

            if (scanner.nextLine().equalsIgnoreCase("y")) {
                for (int i = 0; i < restaurant.getSeatLayout().size(); i++) {
                    if (restaurant.getSeatLayout().get(i).getNumberOfSeats() > customer.getNumberOfGuests()) {
                        System.out.println("Table " + restaurant.getSeatLayout().get(i).getTableNumber() + " is available");
                    }
                }
                System.out.println("Would you like to be seated at a larger table? (Y/N)");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    System.out.println("Which table would you like to be seated at?");
                    int tableNo = scanner.nextInt();
                    for (int i = 0; i < restaurant.getSeatLayout().size(); i++) {
                        if (restaurant.getSeatLayout().get(i).getTableNumber() == tableNo) {
                            seatTable(customer, restaurant.getSeatLayout().get(i));
                            break;
                        }
                    }
                }

            }
        }
        }

    /**
     * Seats table if available  and guests can fit
     * @param customer customer being seated
     * @param table table at which being seated
     */
    public void seatTable(CustomerInformation customer, Table table) {
        if (table.getAvailability() && table.getNumberOfSeats() >= customer.getNumberOfGuests()){
            table.setTableFull();
            System.out.println(customer.getName()+ " has been seated on table " + table.getTableNumber() );

        }else{
            System.out.println("Table not available");
        }
    }
}