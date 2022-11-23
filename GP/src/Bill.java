package GP.src;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 
 * @author seanc
 *
 */
public class Bill {

	private Order order;

	private Restaurant restaurant;
	private static final DecimalFormat df = new DecimalFormat("0.00");


	private double total;

	/**
	 * @param paymentMethod Method of payment for Order, takes cash or card
	 * @param order
	 */
	public Bill(Order order) {

		this.order = order;
		this.total = order.getTotal();
	}

	/**
	 * @return Total value of the order
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * String representation
	 */


//	public void pay(String paymentMethod, double tender) {
//
//		if (paymentMethod == "Cash") {
//			total = total - tender;
//			if (total < 0) {
//				//Customer change
//				total = -total;
//				System.out.println(" Customer change " + total);
//
//
//			} else if (total == 0) {
//				System.out.println(" No change required");
//			} else {
//				System.out.println(" Insufficent Cash");
//			}
//		}
//		//Card Payment
//		if (paymentMethod == "Card" && total < tender) {
//			System.out.println("\n Payment complete");
//			payed();
//		} else if (paymentMethod == "Card" && total > tender) {
//			System.out.println("\n Card declined");
//		} else {
//			if (paymentMethod != "Card" || paymentMethod != "Cash") {
//				System.out.println("Invalid payment method");
//			}
//		}
//	}
	public String toString() {
		return "Bill total= " + total;
	}

	public void pay(double amountPaid) {
		Scanner Scanner = new Scanner(System.in);
		boolean run = true;

		if (amountPaid < total) {
			System.out.println("Insufficient funds");

		} else {
			System.out.println("Payment complete");
			if (amountPaid > total) {
				System.out.println("Change: " + df.format(amountPaid - total));
			}

			double placeholder = 0;
			double change = 0;
			double tipAmt = 0;
			amountPaid = placeholder;

			change = amountPaid - total;

			while (run) {
				System.out.println("Did the customer leave a tip? (Y/N)");
				String tip = Scanner.next();
				if (tip.equals("Y")) {
					System.out.println("How much did they tip?");
					tipAmt = Scanner.nextDouble();
					System.out.println("Tip of " + tipAmt + " added to bill");
						run = false;

				} else if (tip.equals("N")) {
					run = false;
				} else {
					System.out.println("Invalid input");
				}
			}
		}
	}




	public double getTotalPrice() {
		return total;
	}
}


	


