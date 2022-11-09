import java.time.LocalDate;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Bill{
	
	private Course course;
	
	private MenuItem item;
	
	private Table table;
	
	private String paymentMethod;
	
	private double total;
	
	public Bill(Table table, String paymentMethod) {
		this.table = table;
		this.paymentMethod = paymentMethod;
		for(int i = 0; i < course.getItems().size(); i++) {
			item = course.getItems().get(i);
			total = total + item.getPrice();
		}
	}
	
	public double getTotal() {
		return total;
	}
	
	public String toString() {
		return table.toString() +" "+ paymentMethod + " $" + total;
	}
	
	public double Pay(double tender) {
		if(paymentMethod == "Cash") {
			total = total - tender;
			if(total < 0) {
				//Customer change
				total = -total;
				System.out.println(" Customer change " + total);
				return total;
				
				}else if(total == 0) {
					return 0;
				}else {
					System.out.println(" Insufficent Cash");
				}
			}
		//Card Payment
		if(paymentMethod == "Card" && total < tender){
			System.out.println("\n Payment complete");
		}else if(paymentMethod == "Card" && total > tender){
			System.out.println("\n Card declined");
		}
		return 0;
	}
	
}

