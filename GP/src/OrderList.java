package GP.src;

/**
 * Creates a place to store orders and remove them when complete
 */
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

    /**
     * adds the order to the order list at the table
     * @param order the order to be added
     * @param tableId the table id
     */
    public void addOrder(Order order, int tableId) {
        getOrders()[tableId] = order;
    }

    /**
     * removes the order from the order list at the table
     * @param tableId the table id
     */
    public void removeOrder(int tableId) {
        getOrders()[tableId]  = null;
    }

    @Override
    public String toString() {
        return "Orders: \n" + orders + '\n';
    }
}