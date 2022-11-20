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
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<MenuItem> orderItems = new ArrayList<MenuItem>();


    //getters
    //TODO add orders to order array/ have it viewable/ have it added to when order created and removed when order is complete
    public ArrayList getOrderItems() { return orderItems; }

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

        //for amount of seats at table
        for (int i = 0; i < table.getNumberOfSeats(); i++){
            System.out.println(" \n Guest " + (i+1) + " Order: ");
            //for amount of courses
            for (int j = 0; j < courseAmt; j++){
                //prints course name
                System.out.println("Order: " + menu.getCourses().get(j).getName());
                try {
                    //seaches for item in course
                    String itemSearch = scanner.next();
                    //returns item index in course
                    int check = menu.getCourses().get(j).getMenuItemPos(itemSearch);
                    //adds item to order array
                    MenuItem clone = getMenuItem(menu, j, check);
                    orderItems.add(clone);//getOrderItems().add(menu.getCourses().get(j).getItems().get(check));
                } catch (NullPointerException ne){
                    System.out.println("Item not in menu");
                    j--;
                }
            }
        }

    }

    public MenuItem getMenuItem(Menu menu , int j, int item){
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
                status = setStatus.ORDERED; //OLAN: sets status to ordered as food is being shown as ordered
            }
        }
    }

    /**
     *
     * @return
     */

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < this.table.getNumberOfSeats(); i++) {
            for (int j = 0; j < this.menu.getCourses().size(); j++) {
                total += this.menu.getCourses().get(j).getItems().get(i).getPrice();
            }
        }
        return total;
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
        String value = "Order: ";
        //int size = getOrderItems().size();
        for(MenuItem item: orderItems){
            String newVal = "\n     " + item.getName();
            value = value + newVal;
        }
        return value;
    }
}