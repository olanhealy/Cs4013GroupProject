package GP.src;

import java.util.ArrayList;

/**
 * The class deals with the various Courses of the menu
 * <p>
 *     Class add and removes Menu Items.
 *     It can also show the Items aswell
 * </p>
 * @author Kevin Collins
 */
public class Course {

    private String name ;
    private ArrayList<MenuItem> items = new ArrayList();


    public ArrayList<MenuItem> getItems() { return items; }
    public String getName() { return name; }

    /**
     * @param food adds MenuItem to items Array
     */
    public void addMenuItem(MenuItem food){ items.add(food);}

    /**
     * @param food removes MenuItem to items Array
     */
    public void removeMenuItem(MenuItem food) {items.remove(food);}

    /**
     * Creates Course Object
     * @param name String name of Course
     */
    public Course(String name){ //TODO Optimize: See if a 'extends' can be adopted between Menu and Course
        this.name = name;
    }

    /**
     * Used to search position of food in array using MenuItem name
     * @param menuItem item of food
     * @return position of Food Item in item ArrayList
     * @throws NullPointerException
     */
    public int getMenuItemPos (String menuItem) throws NullPointerException{
        for (MenuItem item : items){
            if(menuItem.equals(item.getName())){
                return items.indexOf(item);
            }
        }
        throw new NullPointerException();
    }

    /**
     * displays the food in the array of items
     */
    public void showMenu() {
        System.out.println(getName());
        for (MenuItem menuItem : items) {
            System.out.println(menuItem);
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder("\n***MENU***\n");
        for (MenuItem item : items) {
            str.append(item.toString()).append("\n***\n");
        }
        return str.toString();
    }
}

