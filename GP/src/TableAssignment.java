package GP.src;

import java.time.LocalDateTime;

public class TableAssignment {

    private int time;

    public int getTime() {
        return time;
    }

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


    public void seatTable(CustomerInformation customer, Table table) {
        if (table.getAvailability() == true && table.getNumberOfSeats() >= customer.getNumberOfGuests()){
            table.setTableFull();
            System.out.println(customer.getName()+ " has been seated on table " + table.getTableNumber() );

        }else{
            System.out.println("Table not available");
        }
    }
}