package GP.src;

import java.util.ArrayList;

public class Course {
    
    private String name ;
    private ArrayList<MenuItem> items = new ArrayList();

    public int getMenuItemPos (String menuItem) throws NullPointerException{
        for (int i = 0; i < getItems().size(); i++){
            if(menuItem.equals(getItems().get(i).getName())){
                return items.indexOf(i);
            }
        }
        throw new NullPointerException();
    }

    public Course(String name){ //TODO Optimize: See if a 'extends' can be adopted between Menu and Course
        this.name = name;

    }

    public ArrayList<MenuItem> getItems() { return items; }
    public String getName() { return name; }

    public void addMenuItem(MenuItem food){ items.add(food);}
    public void removeMenuItem(MenuItem food) {items.remove(food);}

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

