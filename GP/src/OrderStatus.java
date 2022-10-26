import java.util.ArrayList;

public class OrderStatus extends FoodOrder {

	private String status;
	
	public OrderStatus(String status, int tableNum, ArrayList<String> Order) {
		super(Order, tableNum);
		this.status = status;
	}
	
	@Override
	public String toString() {
		return super.toString() + status;
	}
}
