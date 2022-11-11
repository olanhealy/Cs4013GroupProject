package GP.src;

public class Payment {
    private Order order; //order that is being paid for
    private String paymentMethod; //payment paymentMethod
    private double amount;//amount tendered
    Course course;

    Waiter waiter;

    public Payment(Order order, String paymentMethod, double amount) {
        this.order = order;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    /**
     * This method checks if waiter has drop food, if its true then it means the pay class
     * can be instantiated
     * @author: Olan Healy
     */
    public void makePayment() {
        if (waiter.getDropFood() == true) {
            pay();
        }
    }

//TODO talk with kev, is this good way of checking so if food has been dropped then the payment
    //TODO can be made
    public double pay() {
        if(paymentMethod.equals("Card")) {
            System.out.println("Payment successful");
            return 0; // may need to change this as what if card doesn't accept
        } else if(paymentMethod.equals("Cash")) {
            double total = order.getTotal();
            if(amount < total) {
                System.out.println("Insufficient cash");
            } else if(amount > total) {
                System.out.println("Payment successful");
                return amount - total;
            } else {
                System.out.println("Payment successful");
                return 0;
            }
        } else {
            System.out.println("Invalid payment paymentMethod");
        }
        return 0;
    }
}
