package GP.src;



public class MenuItem {
    private String name;
    private double price;
    private String type;

    public MenuItem(String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }




    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }


    public String getType() {
        return type;
    }


    @Override
    public String toString() {
        return "FoodItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}
