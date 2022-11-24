package GP.src;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * This class deals with the bill of the order
 * <p>
 *     Class calculates the total price of the order
 *     Class pays order
 *     Class removes order from array
 * </p>
 * @author Sean Caplis & Olan Healy
 *
 */
public class Bill {

	private Order order;
	private Restaurant restaurant;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	private double tip;
	private double total;

	/**
	 * Creates Bill Object
	 * @param order Order Object
	 */
	public Bill(Order order) {

		this.order = order;
		this.total = order.getTotal();
	}

	/**
	 * Pays the order
	 * @param amountPaid Amount paid by customer
	 */
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
					this.tip = tipAmt;
					System.out.println("Tip of $" + tipAmt + " added to bill amount for sotring records");
						run = false;

				} else if (tip.equals("N")) {
					run = false;
				} else {
					System.out.println("Invalid input");
				}
			}
		}
	}

	/**
	 * gets the total of the order
	 * @return total
	 */
	public double getTotalPrice() {
		return total;
	}

	public String toString() {
		return "Bill: $" +  total ;
	}
	public String toStringForFile() {
		return " " + (total  + tip) + ", " + tip ;
	}
}


	


