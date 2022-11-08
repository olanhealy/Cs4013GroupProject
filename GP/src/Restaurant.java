package GP.src;
import GP.src.Table;

import java.util.ArrayList;
import java.util.Random;

public class Restaurant {

    private ArrayList<Table> seatLayout = new ArrayList<>();

    public ArrayList<Table> getSeatLayout() {
        return seatLayout;
    }

    private ArrayList<Menu> menus = new ArrayList<>();

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public Restaurant(int numberOfTables) {

        /*Random rand = new Random();//instance of random class
        int upperbound = 8;

        for(int i = 1; i <= numberOfTables; i++){
            int int_random = (rand.nextInt(upperbound)) + 1;
            addTable(i, int_random ); //TODO generate multiple size tables
        }*/

        addTable(1, 1);
        addTable(2, 2);
        addTable(3, 3);
        addTable(4, 4);
        addTable(5, 5);
    }

    public void addTable(int tableNo, int numberOfSeats) {
        seatLayout.add(new Table(tableNo, numberOfSeats));
    }

    public void addMenu(String name) {
        getMenus().add(new Menu(name));
    }

    public BookingsList addBookingsList(){
        BookingsList booking = new BookingsList();
        return booking;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "seatLayout=" + seatLayout +
                '}';
    }
}
