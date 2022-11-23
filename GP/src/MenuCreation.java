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
        restaurant.getCourse(0,0).addMenuItem(new MenuItem("Pork Belly",4.00));
        restaurant.getCourse(0,0).addMenuItem(new MenuItem("Chicken Parfait",5.00));

        restaurant.getCourse(0,1).addMenuItem(new MenuItem("Ribeye Steak",22.00));
        restaurant.getCourse(0,1).addMenuItem(new MenuItem("Chicken",16.00));
        restaurant.getCourse(0,1).addMenuItem(new MenuItem("Fillet Steak",28.00));
        restaurant.getCourse(0,1).addMenuItem(new MenuItem("Pork Chop",24.00));
        restaurant.getCourse(0,1).addMenuItem(new MenuItem("Caesar Salad",12.00));

        restaurant.getCourse(0,2).addMenuItem(new MenuItem("Brownie",6.00));
        restaurant.getCourse(0,2).addMenuItem(new MenuItem("Sundae",5.00));
        restaurant.getCourse(0,2).addMenuItem(new MenuItem("Lemon Posset",6.00));
        restaurant.getCourse(0,2).addMenuItem(new MenuItem("Crem Brulee",6.00));

        restaurant.getCourse(0,3).addMenuItem(new MenuItem("Guinness",5.00));
        restaurant.getCourse(0,3).addMenuItem(new MenuItem("Heineken",5.40));
        restaurant.getCourse(0,3).addMenuItem(new MenuItem("Coors",5.40));
        restaurant.getCourse(0,3).addMenuItem(new MenuItem("Rioja",6.50));
        restaurant.getCourse(0,3).addMenuItem(new MenuItem("Malbec",8.00));
        restaurant.getCourse(0,3).addMenuItem(new MenuItem("Prosecco",10.00));

        //adds menu
        restaurant.addMenu("Set Menu");

        //adds course
        restaurant.getMenus().get(1).addCourse("Starters");
        restaurant.getMenus().get(1).addCourse("Mains");
        restaurant.getMenus().get(1).addCourse("Desserts");

        //adds foodItems
        restaurant.getCourse(1,0).addMenuItem(new MenuItem("Soup",4.00 ));
        restaurant.getCourse(1,0).addMenuItem(new MenuItem("Prawns",4.00));


        restaurant.getCourse(1,1).addMenuItem(new MenuItem("Ribeye Steak",20.00));
        restaurant.getCourse(1,1).addMenuItem(new MenuItem("Chicken",20.00));
        restaurant.getCourse(1,1).addMenuItem(new MenuItem("Pork Chop",20.00));

        restaurant.getCourse(1,2).addMenuItem(new MenuItem("Brownie",6.00));
        restaurant.getCourse(1,2).addMenuItem(new MenuItem("Sundae",6.00));


    }
}
