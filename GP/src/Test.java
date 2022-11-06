package GP.src;

public class Test {
    public static void main(String[] args) {

        Menu menu = new Menu();
        MenuItem hello = new MenuItem("garlic bread", 8.0, "starters");
        MenuItem hello1 = new MenuItem("burger and chips", 16.50, "mains");
        MenuItem hello2 = new MenuItem("ice-cream", 5.05, "desert");

        menu.addMenuItem(hello);
        menu.addMenuItem(hello1);
        menu.addMenuItem(hello2);
        System.out.println(menu);
    }
}

