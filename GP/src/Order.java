package GP.src;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {

    private Course course;
    private Table table;
    private Menu menu;
    private ArrayList<String> orderItems = new ArrayList();

    public ArrayList getOrderItems() {
        return orderItems;
    }

    public Course getCourse() {
        return course;
    }

    public Table getTable() {
        return table;
    }

    public Menu getMenu() {
        return menu;
    }

    public Order(){
    }

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
                    menu.getCourses().get(j).getMenuItemPos(itemSearch);
                    getOrderItems().add(itemSearch);
                } catch (NullPointerException ne){
                    System.out.println("Item not in menu");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderItems=" + orderItems +
                '}';
    }
}