package GP.src;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {

    private Table table;
    MenuItem[][] customerOrders;

    public Order(Table table, Menu menu){
        int j = 0;
        boolean order = true;
        this.table = table;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i <= table.getTableNumber(); i++){
            System.out.println("Please Input Customer "+ i + "'s Order");
            while(order = true){
                System.out.println("Enter Menu Number followed by Item Number");
                int course = scanner.nextInt();
                int item = scanner.nextInt();
                customerOrders[i][j] = menu.getCourses().get(course).getItems().get(item); //TODO Fix error - Null point exception
                j += 1;
                System.out.println("Order Complete? (Y/N)");
                String answer = scanner.next();
                if(answer == "Y") {
                    order = false;
                }
            }
            j = 0;
        }
    }
}