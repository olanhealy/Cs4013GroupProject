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
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //getters
    public String getName() {return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "FoodItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}