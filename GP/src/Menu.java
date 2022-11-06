package GP.src;

import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuItem> menuItems = new ArrayList<>();

    public void addMenuItem(MenuItem food) {
        menuItems.add(food);

    }

    public void removeMenuItem(MenuItem food) {
        menuItems.remove(food);
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void showMenu() {
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem);
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

