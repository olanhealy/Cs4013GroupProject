package GP.src;

public class Table {
    private int tableNumber;
    private int numberOfSeats;
    private boolean available;


    public  Table(int tableNumber, int numberOfSeats, boolean available) {
        this.tableNumber = tableNumber;
        this.numberOfSeats = numberOfSeats;
        this.available = false;

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

    public void tableAvailable() {
        available = true;
    }
    public void tableNotAvailable() {
        available = false;
    }

}
