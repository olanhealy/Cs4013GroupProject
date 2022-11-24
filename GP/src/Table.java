package GP.src;
import java.util.Scanner;

/**
 * This class deals with the creation of tables in a restaurant
 * @author Kevin Collins
 */
public class Table {

    private int tableNo, numberOfSeats;
    private boolean available;
    private Order order;

    //getters
    public int getTableNumber() { return this.tableNo; }
    public int getNumberOfSeats() { return this.numberOfSeats; }
    public boolean getAvailability() {return this.available;}
    public Order getOrder() {return order;}

    //setters
    public void setTableNumber(int tableNo) { this.tableNo = tableNo; }
    public void setNumberOfSeats(int numberOfSeats) { this.numberOfSeats = numberOfSeats; }
    public void setAvailable(boolean available) { this.available = available; }


    /**
     * Constructor for the table class
     * @param tableNo table number
     * @param numberOfSeats number of seats at the table
     */
    public Table(int tableNo, int numberOfSeats) {
        this.tableNo = tableNo;
        this.numberOfSeats = numberOfSeats;
        this.available = true;
    }

    /**
     * Used to mark a table as full
     */
    public void setTableFull() {this.available = false; }

    /**
     * Used to mark a table as empty
     */
    public void setTableEmpty() { this.available = true; }


    @Override
    public String toString() {
        return "\n Table{" +
                "tableNo=" + tableNo +
                ", numberOfSeats=" + numberOfSeats +
                ", available=" + available + "}";
    }

    public String toStringForFile() {
        return tableNo + "," + numberOfSeats;
    }


}