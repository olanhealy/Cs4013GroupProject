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

    public void setName(String name_) {
    name = name_;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price_) {
        price = price_;
    }

    public String getType() {
        return type;
    }

    public void setType (String type_) {
        type = type_;
    }


    @Override
    public String toString() {
        return "Type: " + type + ", Food Name: " + name + ", €" + price;
    }
}
