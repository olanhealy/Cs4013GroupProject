package GP.src;
import java.util.ArrayList;
import java.util.Date;

public class Menu {
    protected ArrayList<MenuItem> menuItems = new ArrayList<>();
    private String lastUpdate;

    public String getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate() {
        lastUpdate = new Date().toString();
    }

    public void addMenuItem(MenuItem item) {
        if (!menuItems.contains(item)) {
            menuItems.add(item);
        }
        lastUpdate = new Date().toString();
    }
    public void removeMenuItem(MenuItem item) {
        menuItems.remove(item);
        lastUpdate = new Date().toString();
    }

    public void printItem(String itemName) {
        for (MenuItem item : menuItems) {
            if (item.getName().equals(itemName)) {
                System.out.println(item);
            }
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder("\n***MENU***\n");
        for (MenuItem item : menuItems) {
            str.append(item.toString()).append("\n***\n");
        }
        return str.toString();
    }
}




/**public class Menu {
    private double price;
    private String name;
    private String[] starters = {"soup", "bread", "chicken wings"};
    private String[] mains = {"steak", "burger & chips", "chicken curry"};
    private String[] deserts = {"ice-cream", "jelly", "chicken curry"};
    private double[] startersPrice = {3.0, 2.0, 4.0};
    private double[] mainsPrice = {3.0, 2.0, 4.0};
    private double[] desertsPrice = {3.0, 2.0, 4.0};


    public Menu() {
    }

    public void showStarters() {
        System.out.println(starters);
    }

    @Override
    public String toString() {
        return "starters" + starters;
    }
} /**


    /**

    public void showMenu(){
        System.out.println("   FOOD ");
        for(int i=0;i<foodList.size();i++){
            System.out.println((i+1)+") "+foodList.get(i).getCategory()+" "+foodList.get(i).getName()+" price"+foodList.get(i).getPrice());
        }
        System.out.println("   Drinks ");
        for(int i = foodList.size();i<(drinksList.size()+foodList.size());i++){
            System.out.println((i+1)+") "+drinksList.get(i-foodList.size()).getName()+" price"+drinksList.get(i-foodList.size()).getPrice()+"-->"+drinksList.get(i-foodList.size()).getMl()+" ml");
        }
    }
     */



/** public class FoodInMenu {

        private String name;        //name of item
        private double price;       //price of item
        private String type;        //appetizer, main course, or dessert
        private String description; //description of item


        public FoodInMenu(String name, double price, String type,  String description){
            this.name = name;
            this.price = price;
            this.type = type;
            this.description = description;

        }

        public FoodInMenu(FoodInMenu items){
            this.name = name;
            this.price = price;
            this.type = type;
            this.description = description;

        }


        public String getInfo(){ //used in the menu's search method to find item based on key word
            return name + " " + price + " " + type + " " + description + " " ;
        }

        public String getName(){
            return name;
        }

        public double getPrice(){
            return price;
        }

        public String getType(){
            return type;
        }

        public String getDescription(){
            return description;
        }


    } */





































/** public class FoodInMenu {
 private ArrayList<String> Starters;
 private ArrayList<String> Mains;

 private ArrayList<String> Sides;
 private ArrayList<String> Deserts;
 private ArrayList<String> Drinks;




    public void setStarters() {
    Starters.add("soup");
    Starters.add("garlic bread");
        System.out.println(Starters);
    }
    public void setMains() {
        Mains.add("pizza");
        Mains.add("burger");
        System.out.println(Mains);
    }
    public void setSides() {
        Sides.add("chips");
        Sides.add("corn on the cob");
        System.out.println(Sides);
    }
    public void setDeserts() {
        Deserts.add("ice cream");
        Deserts.add("chocolate cake");
        System.out.println(Deserts);
    }

    public void setDrinks() {
        Drinks.add("coke");
        Drinks.add("water");
        System.out.println(Drinks);
    }
}
*/
