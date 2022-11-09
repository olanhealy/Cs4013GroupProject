package GP.src;
import javax.print.attribute.SetOfIntegerSyntax;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class deals with taking Orders and checking on order status
 * @author Kevin Collins
 */
public class Order {

    private Course course;
    private Table table;
    private Menu menu;
    private setStatus status; //OLAN: used for setting order status

    private ArrayList<MenuItem> orderItems = new ArrayList<MenuItem>();


    //getters
    public ArrayList getOrderItems() { return orderItems; }
    public ArrayList<MenuItem> getOrders(){ return getOrders(); }

    //TODO decide on system of inputting/passing orders
    //TODO make system to add passed orders to Arraylist
    /**
     * Takes an order of MenuItems for each seat at the table
     * @param table Table at which order is being taken
     * @param menu Menu in which order taken from
     */
    public void takeOrder(Table table, Menu menu){
        this.table = table;
        this.menu = menu;

        int courseAmt = menu.getCourses().size();
        MenuItem[][] customerOrders = new MenuItem[table.getNumberOfSeats()][courseAmt];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < table.getNumberOfSeats(); i++){
            for (int j = 0; j < courseAmt; j++){
                System.out.println("Order: " + menu.getCourses().get(j).getName());
                try {
                    String itemSearch = scanner.next();
                    int check = menu.getCourses().get(j).getMenuItemPos(itemSearch);
                    orderItems.add(getMenuItem(menu, i, j, check));

                    //getOrderItems().add(menu.getCourses().get(j).getItems().get(check));
                } catch (NullPointerException ne){
                    System.out.println("Item not in menu");
                    j--;
                }
            }
        }

    }

    //TODO check implementation in takeOrder method
    public MenuItem getMenuItem(Menu menu ,int i, int j, int item){
        MenuItem menuItem = menu.getCourses().get(j).getItems().get(item);
        return menuItem;
    }

    //TODO check if valid after class is finalized
    /**
     * Shows the Order for the table
     */
    public void showOrder() {
        System.out.println("Order for table " + this.table.getTableNumber());
        for (int i = 0; i < this.table.getNumberOfSeats(); i++) {
            for (int j = 0; j < this.menu.getCourses().size(); j++) {
                System.out.println(this.menu.getCourses().get(j).getName());
                System.out.println(this.menu.getCourses().get(j).getItems().get(i));
                status = setStatus.ORDERED;
            }
        }
    }

    /**
     *enum used as these variables are unchangeable and are used to set the status of the order
     *@author Olan Healy
     */
    public enum setStatus {
        ORDERED, READY, SERVED
    }
    /**
     * Sets the status of the order
     * @author Olan Healy
     */
    public setStatus getStatus() {
        return status;
    }


    /**
     *
     * @param status
     * @return status for chef to know to start cooking food
     *@author Olan Healy
     */

    public boolean checkStatusChef(String status) {
        return(status.equals("ORDERED")); //links to chef
    }
    /**
     *
     * @param status
     * @return status for waiter to know to serve food
     *@author Olan Healy
     */

    public boolean setStatus(String status) {
        return(status.equals("READY"));
    }



    @Override
    public String toString() {
        String value = "Order{" +
                "orderItems=" ;
        int size = getOrderItems().size();
        for(int i = 0 ; i < size; i++){
            String newVal = orderItems.get(i).getName();
            value = value + newVal;
        }
        return value;
    }
}