package GP.src;

/**
 * 
 * @author seanc
 *
 */
public class Bill{
	
	private Order order;
	
	private Restaurant restaurant;
	
	private String paymentMethod;
	
	private double total;
	
	/**
	 * 
	 * @param paymentMethod Method of payment for Order, takes cash or card
	 * @param order
	 */
	public Bill(String paymentMethod, Order order) {
		this.paymentMethod = paymentMethod;
		this.order = order;
		this.total = order.getTotal();
	}
	
	/**
	 * 
	 * @return Total value of the order
	 */
	public double getTotal() {
		return total;
	}
	
	/**
	 * String representation 
	 */
	public String toString() {
		return " "+paymentMethod + ", " + total + ", " +order.getOrderItems();
	}
	
	public void pay(double tender) {

		if(paymentMethod == "Cash") {
			total = total - tender;
			if(total < 0) {
				//Customer change
				total = -total;
				System.out.println(" Customer change " + total);

				
				}else if(total == 0) {
					System.out.println(" No change required");
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

	}

	
}

