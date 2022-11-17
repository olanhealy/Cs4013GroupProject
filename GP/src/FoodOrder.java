import java.util.ArrayList;

public class FoodOrder {
	
	public MenuItem item;
	
	public static Table table;
	
	private static ArrayList<MenuItem> Order = new ArrayList<MenuItem>();
	
	public FoodOrder(ArrayList<MenuItem> Order , Table table) {
		this.Order = Order;
		this.table = table;
	}
	
	public String toString() {
		return getOrder().toString() + getTableNum();
	}

	public static ArrayList<MenuItem> getOrder() {
		return Order;
	}
	
	public static MenuItem getMenuItem(int i) {
		return Order.get(i);
	}

	public void setOrder(ArrayList<MenuItem> order) {
		Order = order;
	}

	public static Table getTableNum() {
		return table;
	}
	
}


