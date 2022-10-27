package GP.src;

public class Table {
    private int tableNumber;
    private int numberOfSeats;

    private String disability;

    private String kidsSeat;

    private  boolean available;



    public  Table(int tableNumber, int numberOfSeats) {
        this.tableNumber = tableNumber;
        this.numberOfSeats = numberOfSeats;
        available = false;
    }



    public int getTableNumber( ) {
        return tableNumber;
    }
    public void  setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }



    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public  String toString() {
        return "Table number: " + getTableNumber() + ", Number of seats: " + getNumberOfSeats() + ", Is there seats available: " + isAvailable() ;
    }
    public void sitTable() {
        available = false;
    }
    public void emptyTable() {
        available = true;
    }


}
