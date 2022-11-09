import java.time.LocalDate;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Payment{

	private MenuItem item;
	
	private Table table;
	
	private String paymentMethod;
	
	private double total;
	
	private LocalDate date;
	
	public Payment(Table table, String paymentMethod, int year, int month, int day) {
		this.table = table;
		this.paymentMethod = paymentMethod;
		this.date = LocalDate.of(year, month, month);
	}
	
	public double calculateTotal() {
		for(int i = 0; i < Course.getItems().size(); i++) {
			item = Course.getItems().get(i);
			total = total + item.getPrice();
		}
		
		return total;
	}
	
	public double PaymentProcess(double tender) {
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
			System.out.println(" Payment complete");
		}else if(paymentMethod == "Card" && total > tender){
			System.out.println("Card declined");
		}
		return 0;
	}
	
}

