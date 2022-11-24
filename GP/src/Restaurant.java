package GP.src;
import GP.src.Table;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class creates restaurant (used for multiple restaurants in a chain)
 * <p>
 *  Class used to add and remove different aspects of the restaurant (staff, table)
 * </p>
 * @author Kevin Collins && Olan Healy
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

    //setters
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
    public String menuIDsToString(){
        String menuIDs = "";
        for(int i = 0; i < getMenus().size(); i++){
            menuIDs += "MenuID:" + i + " Menu Name: " + getMenus().get(i).getName() + "\n";
        }
        return menuIDs;
    }

    /**
     * adds a list of bookings to the restaurant
     * @return list of bookings
     */
    public BookingsList addBookingsList(){
        BookingsList booking = new BookingsList();
        return booking;
    }

    /**
     * check if password and id are correct for staff memeber
     * @param id staff id
     * @param password staff password
     * @return position of staff member in staff arraylist
     */
    public int validStaff(int id, String password) {
        for (Staff staff : getStaff()) {
            if ((staff.getId() == id) && (staff.getPassword().equals(password))) {
                int pos = getStaff().indexOf(staff);
                return pos;
            }
        }
        return -1;
    }

    /**
     * Adds staff to Limerick restaurant
     * @param staffList list of staff
     */
    public void addLimerickStaff(ArrayList<Staff> staffList) {

        staffList.add(new Waiter("Billy", 13, "2023"));
        staffList.add(new Chef("Sally", 8, "Yu564"));
        staffList.add(new Manager("Bobby", 1, "Y"));

    }

    /**
     * Adds staff to Galway restaurant
     * @param staffList staff list
     */
    public void addGalwayStaff(ArrayList<Staff> staffList) {

        staffList.add(new Waiter("John", 13, "RedRose"));
        staffList.add(new Chef("Mary", 8, "Choco"));
        staffList.add(new Manager("Jay", 1, "4321"));
    }

    /**
     *
     * @return list of staff
     */
    public ArrayList<Staff> getStaff() {
        return staff;
    }

    /**
     * Prints out table id and availability for each table
     */
    public void checkAllAvailability(){
        for (Table table : getSeatLayout()) {
            System.out.println(table.getTableNumber() + ":" + table.getAvailability());
        }
    }

    /**
     * Removes staff
     * @param name staff name
     * @param passwordRem staff password
     */
    public void removeStaff(String name, String passwordRem) {
        for (Staff staff : getStaff()) {
            if ((staff.getName().equals(name) ) && (staff.getPassword().equals(passwordRem))) {
                getStaff().remove(staff);
            }
        }
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "seatLayout=" + seatLayout +
                '}';
    }
}