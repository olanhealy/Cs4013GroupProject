package GP.src;

import java.time.LocalDateTime;

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
    public TableAssignment(Restaurant restaurant, CustomerInformation customer) { //TODO create way of seating party of 4 of 5 table if no 4s available
        this.time = LocalDateTime.now().getHour();
        //int time = 16;
        if (getTime() == customer.getTimeOfArrival()) {
            for (int i = 0; i < restaurant.getSeatLayout().size(); i++) {
                if (customer.getNumberOfGuests() == restaurant.getSeatLayout().get(i).getNumberOfSeats()) {
                    seatTable(customer, restaurant.getSeatLayout().get(i));
                    break;
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
            this.time = time;
            if (getTime() == customer.getTimeOfArrival()) {
                for (int i = 0; i < restaurant.getSeatLayout().size(); i++) {
                    if (customer.getNumberOfGuests() == restaurant.getSeatLayout().get(i).getNumberOfSeats()){
                        seatTable(customer, restaurant.getSeatLayout().get(i));
                        break;
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
        if (table.getAvailability() == true && table.getNumberOfSeats() >= customer.getNumberOfGuests()){
            table.setTableFull();
            System.out.println(customer.getName()+ " has been seated on table " + table.getTableNumber() );

        }else{
            System.out.println("Table not available");
        }
    }
}