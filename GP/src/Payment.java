//
//
//public class Payment{
//
//	private MenuItem item;
//
//	private Table table;
//
//	private String paymentMethod;
//
//	private double total;
//
//	private double cash;
//
//	public Payment(Table table, String paymentMethod) {
//		this.table = table;
//		this.paymentMethod = paymentMethod;
//	}
//
//	public double PaymentProcess(String paymentMethod) {
//		if(paymentMethod == "Cash") {
//			total = total - cash;
//			if(total < 0) {
//				//Customer change
//				System.out.print("Customer change " + total);
//				return total;
//
//				}else if(total == 0) {
//					return 0;
//				}else {
//					System.out.print("Insufficent Cash");
//				}
//			}
//		//Card Payment
//		else if(paymentMethod == "Card"){
//			System.out.print("Payment complete");
//		}
//		return 0;
//	}
//
//	public void calculateTotal() {
//		for(int i = 0; i < FoodOrder.getOrder().size(); i++) {
//			item = FoodOrder.getMenuItem(i);
//			total = total + item.getPrice();
//		}
//	}
//
//}


//TODO If I put in a constructor, I get an error in trying to run the class in test, Ive tried ways of initalizing
//TODO order variables but wont work, need to find way to solve this as if can get price to show payment is pretty mich done
package GP.src;

import java.util.Scanner;

public class Payment {
    private Order order; //order that is being paid for
    private String paymentMethod; //payment paymentMethod
    private double amount;//amount tendered
    Course course;
    MenuItem item;
    Scanner in = new Scanner(System.in);

    Waiter waiter;
    private double getTotal;


    public void setGetTotal(double getTotal) {
        this.getTotal = getTotal;
    }
   private double getTotal() {
        double total = 0;
        for (int i = 0; i < course.getItems().size(); i++) {
            item = course.getItems().get(i);
           // total = total + item.getPrice();
        }
        return total;
    }






    /**
     * This method checks if waiter has drop food, if its true then it means the pay class
     * can be instantiated
     *
     * @author: Olan Healy
     */
    public void makePayment() {
        if (waiter.getDropFood() == true) {
            //pay();
        }
    }



    public void pay(Table table, Menu menu) {
        double collectAmount = 0;
        double change = 0;

        System.out.println("Bill is $" + order.getTotal());
        System.out.println("Customer paid by card? (y/n)");
        String card = in.nextLine();
        if (card.equals("y")) {
            System.out.println("Enter amount tendered");
            double tender = in.nextDouble();
            if (tender == getTotal) {
                System.out.println("Payment complete");
                collectAmount = tender;
            } else if (tender < getTotal) {
                System.out.println("Insufficient funds, try again");
            }
        } else if (card.equals("n")) {
            System.out.println("Customer paid with cash");
            System.out.println("Enter amount tendered");
            double tender = in.nextDouble();
            if (tender == getTotal) {
                System.out.println("Payment complete");
                collectAmount = tender;
            } else if (tender > getTotal) {
                change = tender - getTotal;
                collectAmount = tender - change;
                System.out.println("Customer is due change of $" + change);
            } else if (tender < getTotal) {
                System.out.println("Insufficient funds");
            } else {
                System.out.println("Payment complete");
            }
        }

    }


}

      /** public void printReceipt() {
            System.out.println("Receipt");
            System.out.println("Table number: " + order.getTable().getTableNumber());
            System.out.println("Payment method: " + paymentMethod);
            System.out.println("Total: " + getTotal);
            System.out.println("Amount tendered: " + amount);
            System.out.println("Change: " + (amount - getTotal));
        } */


