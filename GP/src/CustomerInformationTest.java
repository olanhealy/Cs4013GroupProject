package GP.src;
import java.util.ArrayList;

public class CustomerInformationTest {

    public static void main(String args[]) {
        //ArrayList<CustomerInformation> customers = new ArrayList<>();

        BookingsList burgerMacBookings = new BookingsList();

        System.out.println(burgerMacBookings);


        System.out.println(burgerMacBookings.checkBooking("John Francis", "0873416741"));

        burgerMacBookings.cancelBooking("John Francis");
        System.out.println();

        System.out.println(burgerMacBookings);

        System.out.println(burgerMacBookings.checkBooking("John Francis", "0873416741"));





    }
}

       /** Menu menu1 = new Menu();
        Menu food1 = new Food(40, "Toast", "Starter");
        Menu food2 = new Food(40, "burger", "Main Course");
        Menu food3 = new Food(40, "Ice cream", "Desert");
        Menu drinks1 = new Drinks(3, "water", 200);
        Menu drinks2 = new Drinks(5, "Coke", 250);

        menu1.addFood((Food) food1);
        menu1.addFood((Food) food2);
        menu1.addFood((Food) food3);

        menu1.addDrinks((Drinks) drinks1);
        menu1.addDrinks((Drinks) drinks2);


        menu1.showMenu();
    }




} */

