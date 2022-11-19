package GP.src;

import java.util.ArrayList;

/**
 * The class creates menus that can be used in the restaurant
 * @author Kevin Collins
 */
public class Menu {

    private String name;
    private ArrayList<Course> courses = new ArrayList();

    /**
     * Creates Menu Object
     *
     * @param name Name of menu e.g. A la Carte
     */
    public Menu(String name) {
        this.name = name;
    }

    /**
     * @return list of courses
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * Adds course to the Courses array
     *
     * @param name name of Course
     */
    public void addCourse(String name) {
        getCourses().add(new Course(name));
    }

    public void showFullMenu(Restaurant restaurant, int menuId) {
        //shows menu
            for (int i = 0; i <= (getCourses().size()-1); i++) {
                restaurant.getMenus().get(menuId).getCourses().get(i).showMenu();
            }
    }
}
