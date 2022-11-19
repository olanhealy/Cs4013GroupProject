package GP.src;

public class MenuCreation {

    public MenuCreation(Restaurant restaurant){
        //adds menu
        restaurant.addMenu("Al la Carte");

        //adds course
        restaurant.getMenus().get(0).addCourse("Starters");
        restaurant.getMenus().get(0).addCourse("Mains");
        restaurant.getMenus().get(0).addCourse("Desserts");
        restaurant.getMenus().get(0).addCourse("Drinks");

        //adds foodItems
        restaurant.getCourse(0,0).addMenuItem(new MenuItem("Soup",3.00 ));
        restaurant.getCourse(0,0).addMenuItem(new MenuItem("Prawns",5.00));

        restaurant.getCourse(0,1).addMenuItem(new MenuItem("Steak",22.00));
        restaurant.getCourse(0,1).addMenuItem(new MenuItem("Chicken",16.00));

        restaurant.getCourse(0,2).addMenuItem(new MenuItem("Brownie",6.00));
        restaurant.getCourse(0,2).addMenuItem(new MenuItem("Sundae",5.00));

        restaurant.getCourse(0,3).addMenuItem(new MenuItem("Guiness",5.00));
        restaurant.getCourse(0,3).addMenuItem(new MenuItem("Rioja",6.50));

    }
}
