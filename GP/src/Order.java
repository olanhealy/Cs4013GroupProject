package GP.src;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {

    private Course course;
    private Table table;
    private Menu menu;
    private ArrayList<MenuItem> orderItems = new ArrayList<MenuItem>();

    public ArrayList getOrderItems() { return orderItems; }
    public Course getCourse() { return course; }
    public Table getTable() { return table; }
    public Menu getMenu() {return menu; }
    public ArrayList<MenuItem> getOrders(){
        return getOrders();
    }

    public boolean setStatus(String status) {
        return(status.equals("ORDERED"));
    }
    public boolean checkStatusChef(String status) {
        return(status.equals("READY")); //links to chef
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

    public MenuItem getMenuItem(Menu menu ,int i, int j, int item){
        MenuItem menuItem = menu.getCourses().get(j).getItems().get(item);
        return menuItem;
    }

    public enum setStatus {
        ORDERED, READY, SERVED
    }
    //    public setStatus getStatus() {
//        return status;
//    }

    public void showOrder() {
        System.out.println("Order for table " + table.getTableNumber());
        for (int i = 0; i < table.getNumberOfSeats(); i++) {
            for (int j = 0; j < menu.getCourses().size(); j++) {
                System.out.println(menu.getCourses().get(j).getName());
                System.out.println(menu.getCourses().get(j).getItems().get(i));
            }
        }
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