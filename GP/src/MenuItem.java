<<<<<<< HEAD
import java.util.ArrayList;

public class MenuItem {
    private String name;
    private double price;


    private ArrayList<Course> Menu = new ArrayList<>();

=======
package GP.src;

import java.util.ArrayList;

/**
 * This class creates menuItem objects (food or drink)
 * @author Kevin Collins
 */
public class MenuItem {
    private String name;
    private double price;
    private ArrayList<Course> Menu = new ArrayList<>();

    /**
     * Constructor for menuItem objects
     * @param name name of food/drink
     * @param price price of  food/drink
     */
>>>>>>> a6628d2da1b08ac4e6c160c45f38429cfff1b6a7
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

<<<<<<< HEAD
    public String getName() {
        return name;
    }
=======
    //getters
    public String getName() {return name; }
>>>>>>> a6628d2da1b08ac4e6c160c45f38429cfff1b6a7
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "FoodItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}