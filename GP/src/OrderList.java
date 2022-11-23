package GP.src;

import java.util.ArrayList;

public class OrderList {

    private Order[] orders = new Order[100];

    public OrderList() {
        this.orders = orders;
    }

    public Order[] getOrders() {
        return orders;
    }

    public Order getOrder(int tableId) {
        return orders[tableId];
    }


    public void addOrder(Order order, int tableId) {
        getOrders()[tableId] = order;
    }
    public void removeOrder( int tableId) {
        getOrders()[tableId]  = null;
    }

    @Override
    public String toString() {
        return "Orders: \n" + orders + '\n';
    }
}