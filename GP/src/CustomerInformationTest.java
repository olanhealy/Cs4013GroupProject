import java.util.ArrayList;

public class CustomerInformationTest {

    public static void main(String args[]) {
        //ArrayList<CustomerInformation> customers = new ArrayList<>();

        CustomerInformation booking1 = new CustomerInformation("John Francis", "0873416741", "12:00",2, "Birthday", "Wheat", "None");
        CustomerInformation booking2 = new CustomerInformation("Mary Richards", "0871234567", "13:30",5, "Date Night", "None", "Wedding ring");
        CustomerInformation booking3 = new CustomerInformation("Hugh B. Pipen", "0869395333", "14:00",12, "None", "None", "Window Seat");

        BookingsList burgerMacBookings = new BookingsList();
        burgerMacBookings.addBooking(booking1);
        burgerMacBookings.addBooking(booking2);
        burgerMacBookings.addBooking(booking3);

        System.out.println(burgerMacBookings);
<<<<<<< HEAD

        System.out.println(burgerMacBookings.checkBooking("John Francis", "0873416741"));

        burgerMacBookings.cancelBooking("John Francis");
        System.out.println();

        System.out.println(burgerMacBookings);

        System.out.println(burgerMacBookings.checkBooking("John Francis", "0873416741"));


    }
}
=======
        Menu menu = new Menu();
        MenuItem hello = new MenuItem("garlic bread", 8.0, "starters");
        MenuItem hello1 = new MenuItem("burger and chips", 16.50, "mains");
        MenuItem hello2 = new MenuItem("ice-cream", 5.05, "desert");

        menu.addMenuItem(hello);
        menu.addMenuItem(hello1);
        menu.addMenuItem(hello2);
        System.out.println(menu);
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
>>>>>>> fb6c74de85ebfcefb92454753b9f09d938bee43f
