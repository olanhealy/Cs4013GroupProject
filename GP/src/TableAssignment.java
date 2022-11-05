public class TableAssignment {

    public TableAssignment(Restaurant restaurant, CustomerInformation customer){ //TODO create way of seating party of 4 of 5 table if no 4s available
        for (int i = 0; i <  restaurant.getSeatLayout().size(); i++){
            if (customer.getNumberOfGuests() == restaurant.getSeatLayout().get(i).getNumberOfSeats()){
                seatTable(customer, restaurant.getSeatLayout().get(i));
                break;
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