package GP.src;

import java.util.ArrayList;

public class OrderList {

    private ArrayList<Order> orders = new ArrayList();

    public OrderList() {
        this.orders = orders;
    }

    public ArrayList<Order> getOrders() {
        return orders;

    }

    public Order getOrder(int tableId) {
        return orders.get(tableId);
    }


    public void addOrder(Order order, int tableId) {
        getOrders().add(tableId, order);
    }

    @Override
    public String toString() {
        return "Orders: \n" + orders + '\n';
    }
}
