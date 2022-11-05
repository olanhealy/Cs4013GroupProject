import java.util.ArrayList;
import java.util.Random;

public class Restaurant {

    private ArrayList<Table> seatLayout = new ArrayList<>();

    public ArrayList<Table> getSeatLayout() {
        return seatLayout;
    }

    public Restaurant(int numberOfTables) {

        Random rand = new Random();//instance of random class
        int upperbound = 8;


        for(int i = 1; i <= numberOfTables; i++){
            int int_random = (rand.nextInt(upperbound)) + 1;
            addTable(i, int_random ); //TODO generate multiple size tables
        }
    }

    public void addTable(int tableNo, int numberOfSeats) {
        seatLayout.add(new Table (tableNo, numberOfSeats));
    }


    @Override
    public String toString() {
        return "Restaurant{" +
                "seatLayout=" + seatLayout +
                '}';
    }
}
