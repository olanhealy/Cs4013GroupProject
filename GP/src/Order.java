package GP.src;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {

    private Course course;
    private Table table;
    int i=0;
    int j= 0;

    public Order(Table table, Menu menu){

        int courseAmt = menu.getCourses().size();
        boolean order = true;
        this.table = table;

        MenuItem[][] customerOrders = new MenuItem[table.getNumberOfSeats()][courseAmt];

        Scanner scanner = new Scanner(System.in);
        for (i = 1; i <= table.getTableNumber(); i++){
            for (j = 1; j < courseAmt; j++){
                getMenuItem();
            }
        }
    }

    public MenuItem getMenuItem(Course course){
        this.course = course;
        course.getItems()
    }
}