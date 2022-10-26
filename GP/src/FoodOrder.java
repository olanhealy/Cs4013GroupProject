import java.util.ArrayList;

public class FoodOrder {
	
	private ArrayList<String> Order = new ArrayList<String>();
	
	private int tableNum;
	
	public FoodOrder(ArrayList<String> Order , int tableNum) {
		this.Order = Order;
		this.tableNum = tableNum;
	}
	
	public String getOrder(ArrayList<String> Order) {
		return Order.toString();
	}
	
	public int getTableNum(int tableNum) {
		return tableNum;
	}
	
	public void setTableNum(int tableNum){
		this.tableNum = tableNum;
	}
	
	public String toString() {
		return Order.toString() + tableNum;
	}
}


