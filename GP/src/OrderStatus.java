import java.util.ArrayList;

public class OrderStatus extends FoodOrder {

	private String status;
	
	public OrderStatus(String status) {
		super(getOrder(), getTableNum());
		this.status = status;
	}
	
	@Override
	public String toString() {
		return super.toString() + status;
	}
}
