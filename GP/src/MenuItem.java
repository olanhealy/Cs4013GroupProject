package GP.src;

import java.util.ArrayList;

public class MenuItem {
    private String name;
    private double price;
    private ArrayList<Course> Menu = new ArrayList<>();

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public double getPrice() { return price; }



    @Override
    public String toString() {
        return "FoodItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}