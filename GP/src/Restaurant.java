package GP.src;
import GP.src.Table;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class creates restaurant (used for multiple restaurants in a chain)
 * <p>
 *
 * </p>
 * @author Kevin Collins
 */
public class Restaurant {

    private ArrayList<Table> seatLayout = new ArrayList<>();
    private ArrayList<Menu> menus = new ArrayList<>();
    private ArrayList<Staff> staff = new ArrayList<>();

    //Different Accessors to access from restaurant object
    public ArrayList<Table> getSeatLayout() { return seatLayout; }
    public ArrayList<Menu> getMenus() { return menus; }
    public Menu getMenu (int menuId){ return getMenus().get(menuId); }
    public Course getCourse (int menuId, int courseID){ return getMenus().get(menuId).getCourses().get(courseID); }
    public MenuItem getMenuItem (int menuId, int courseID, int menuItemID){ return getMenus().get(menuId).getCourses().get(courseID).getItems().get(menuItemID); }
    public ArrayList<Course> getCourselist (int menuId){ return getMenus().get(menuId).getCourses();}
    public ArrayList<MenuItem> getMenuItemList (int menuId, int courseID){ return getMenus().get(menuId).getCourses().get(courseID).getItems(); }

    //TODO method to create tables as needed
    /**
     * Creates restaurant object
     * @param numberOfTables tables needed for restaurant
     */
    public Restaurant(int numberOfTables) {

        /*Random rand = new Random();//instance of random class
        int upperbound = 8;

        for(int i = 1; i <= numberOfTables; i++){
            int int_random = (rand.nextInt(upperbound)) + 1;
            addTable(i, int_random );
        }*/

        //temp tables for testing
//        addTable(1, 1);
//        addTable(2, 2);
//        addTable(3, 3);
//        addTable(4, 4);
//        addTable(5, 5);
    }

    /**
     * add tables with x number of seats to the Seat layout
     * @param tableNo number of tables with x number of deats
     * @param numberOfSeats x number of seats
     */
    public void addTable(int tableNo, int numberOfSeats) {
        seatLayout.add(new Table(tableNo, numberOfSeats));
    }

    /**
     * adds menu to the restaurant
     * @param name menu name
     */

    public void addMenu(String name) {
        getMenus().add(new Menu(name));
    }

    /**
     * adds a list of bookings to the restaurant
     * @return list of bookings
     */
    public BookingsList addBookingsList(){
        BookingsList booking = new BookingsList();
        return booking;
    }

    public ArrayList<Staff> getStaff() {
        return staff;
    }

    public void checkTablesAvailability(){
        for (Table table : getSeatLayout()) {
            System.out.println(table.getTableNumber() + ":" + table.getAvailability());
        }
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "seatLayout=" + seatLayout +
                '}';
    }
}
