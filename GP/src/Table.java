package GP.src;
import java.util.Scanner;

public class Table {

    private int tableNo, numberOfSeats;
    private boolean available;

    Scanner scanner = new Scanner(System.in);

    public Table(int tableNo, int numberOfSeats) {
        this.tableNo = tableNo;
        this.numberOfSeats = numberOfSeats;
        this.available = true;
    }

    //getters
    public int getTableNumber() {
        return this.tableNo;
    }
    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }
    public boolean getAvailability() {return this.available;}

    //setters
    public void setTableNumber(int tableNo) {
        this.tableNo = tableNo;
    }
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }


    public void setTableFull() {
        this.available = false;
    }
    public void setTableEmpty() { this.available = true; }

    @Override
    public String toString() {
        return "\n Table{" +
                "tableNo=" + tableNo +
                ", numberOfSeats=" + numberOfSeats +
                ", available=" + available + "}";
    }
}