
public class Payment{

	private MenuItem item;
	
	private Table table;
	
	private String paymentMethod;
	
	private double total;
	
	private double cash;
	
	public Payment(Table table, String paymentMethod) {
		this.table = table;
		this.paymentMethod = paymentMethod;
	}
	
	public void calculateTotal() {
		for(int i = 0; i < Course.getItems().size(); i++) {
			item = Course.getItems().get(i);
			total = total + item.getPrice();
		}
	}
	
	public double getTotal() {
		return total;
	}

	
	public double PaymentProcess(String paymentMethod) {
		if(paymentMethod == "Cash") {
			total = total - cash;
			if(total < 0) {
				//Customer change
				System.out.print("Customer change " + total);
				return total;
				
				}else if(total == 0) {
					return 0;
				}else {
					System.out.print("Insufficent Cash");
				}
			}
		//Card Payment
		else if(paymentMethod == "Card"){
			System.out.print("Payment complete");
		}
		return 0;
	}
}

