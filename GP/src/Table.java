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



    public Table(int tableNo, int numberOfSeats) {
        this.tableNo = tableNo;
        this.numberOfSeats = numberOfSeats;
        this.available = true;
    }

    //getters
    public int getTableNumber() { return this.tableNo; }
    public int getNumberOfSeats() { return this.numberOfSeats; }
    public boolean getAvailability() {return this.available;}

    //setters
    public void setTableNumber(int tableNo) { this.tableNo = tableNo; }
    public void setNumberOfSeats(int numberOfSeats) { this.numberOfSeats = numberOfSeats; }
    public void setAvailable(boolean available) { this.available = available; }

    /**
     * Used to mark a table as full
     */
    public void setTableFull() {this.available = false; }

    /**
     * Used to mark a table as empty
     */
    public void setTableEmpty() { this.available = true; }
    public Order getOrder() {

        return order;
    }

    @Override
    public String toString() {
        return "\n Table{" +
                "tableNo=" + tableNo +
                ", numberOfSeats=" + numberOfSeats +
                ", available=" + available + "}";
    }


}