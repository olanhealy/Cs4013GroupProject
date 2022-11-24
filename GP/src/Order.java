package GP.src;
import javax.print.attribute.SetOfIntegerSyntax;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class deals with taking Orders and checking on order status
 * @author Kevin Collins & Olan Healy
 */
public class Order {

    private Course course;
    private Table table;
    private Menu menu;
    private setStatus status; //OLAN: used for setting order status
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<MenuItem> orderItems = new ArrayList<MenuItem>();


    //getters
    public ArrayList getOrderItems() { return orderItems; }

    /**
     * Takes an order of MenuItems for each person at the table
     * @param table Table at which order is being taken
     * @param menu Menu in which order taken from
     * @param numberOfGuests Number of guests at the table
     */
    public void takeOrder(Table table, Menu menu,  int numberOfGuests){
        this.table = table;
        this.menu = menu;

        int courseAmt = menu.getCourses().size();
        Scanner scanner = new Scanner(System.in);

        //for amount of seats at table
        for (int i = 0; i < numberOfGuests; i++){
            System.out.println(" \n Guest " + (i+1) + " Order: ");
            //for amount of courses
            for (int j = 0; j < courseAmt; j++){
                //prints course name
                System.out.println("Order: " + menu.getCourses().get(j).getName());
                try {
                    //seaches for item in course
                    String itemSearch = scanner.nextLine();
                    //returns item index in course
                    int check = menu.getCourses().get(j).getMenuItemPos(itemSearch);
                    //adds item to order array
                    MenuItem clone = getMenuItem(menu, j, check);
                    orderItems.add(clone);
                } catch (NullPointerException ne){
                    System.out.println("Item not in menu");
                    j--;
                }
            }
        }
    }

    /**
     * Get menuItem object from menu
     * @param menu Menu to search
     * @param j Course to search
     * @param item Item to search
     * @return MenuItem object
     */
    public MenuItem getMenuItem(Menu menu , int j, int item){
        MenuItem menuItem = menu.getCourses().get(j).getItems().get(item);
        return menuItem;
    }


    /**
     * Gets Total price of order
     * @return Total price of order
     */
    public double getTotal() {
        double total = 0;
        for (MenuItem item : orderItems) {
            total += item.getPrice();
            }
        return total;
    }


    /**
     *enum used as these variables are unchangeable and are used to set the status of the order
     */
    public enum setStatus {ORDERED}

    /**
     * Sets the status of the order
     * @author Olan Healy
     */
    public setStatus getStatus() {
        if (status == null) {
            status = setStatus.ORDERED;
        }
        return status;
    }

    @Override
    public String toString() {
        String value = "Order: ";

        for(MenuItem item: orderItems){
            String newVal = "\n     " + item.getName();
            value = value + newVal;
        }
        return value;
    }
}