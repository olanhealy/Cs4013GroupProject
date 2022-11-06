package GP.src;
import java.util.ArrayList;
public class Order {
    private ArrayList<MenuItem> ordered = new ArrayList<>();
    private CustomerInformation test;

    public Order(CustomerInformation test) {
        this.test = test;
    }
}