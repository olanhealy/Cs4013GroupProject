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
    private OrderList orderList = new OrderList();
    private BillCSV billTable = new BillCSV();
    private CustomerInformationCSV customerTable = new CustomerInformationCSV();
    private TableCSV tablesTable = new TableCSV();
    private RestaurantInterface restaurantInterface = new RestaurantInterface();

    //Different Accessors to access from restaurant object
    public ArrayList<Table> getSeatLayout() { return seatLayout; }
    public ArrayList<Menu> getMenus() { return menus; }
    public Menu getMenu (int menuId){ return getMenus().get(menuId); }
    public Course getCourse (int menuId, int courseID){ return getMenus().get(menuId).getCourses().get(courseID); }
    public MenuItem getMenuItem (int menuId, int courseID, int menuItemID){ return getMenus().get(menuId).getCourses().get(courseID).getItems().get(menuItemID); }
    public ArrayList<Course> getCourselist (int menuId){ return getMenus().get(menuId).getCourses();}
    public ArrayList<MenuItem> getMenuItemList (int menuId, int courseID){ return getMenus().get(menuId).getCourses().get(courseID).getItems(); }
    public Table getTable (int TableNo){ return getSeatLayout().get(TableNo); }
    public OrderList getOrderList() {return orderList; }
    public BillCSV getBillTable() { return billTable; }
    public CustomerInformationCSV getCustomerTable() { return customerTable; }
    public TableCSV getTablesTable() { return tablesTable; }
    public RestaurantInterface getRestaurantInterface() { return restaurantInterface; }

    public void setBillTable(BillCSV billTable) { this.billTable = billTable; }
    public void setCustomerTable(CustomerInformationCSV customerTable) { this.customerTable = customerTable; }
    public void setTablesTable(TableCSV tablesTable) { this.tablesTable = tablesTable; }
    public void setRestaurantInterface(RestaurantInterface restaurantInterface) { this.restaurantInterface = restaurantInterface; }

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
    public boolean validStaff(int id, String password, ArrayList<Staff> staffList) {
        for (Staff staff : staffList) {
            if ((staff.getId() == id) && (staff.getPassword().equals(password))) {
                return true;
            }
        }
        return false;
    }


    public void addStaff(ArrayList<Staff> staffList) {

        staffList.add(new Waiter("Billy", 13, "Helt23"));
        staffList.add(new Chef("Sally", 8, "Yu564"));
        staffList.add(new Manager("Bobby", 1, "Y"));

    }

    public ArrayList<Staff> getStaff() {
        return staff;
    }

    public void checkAllAvailability(){
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
