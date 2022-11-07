package GP.src;

import java.util.ArrayList;

public class Menu {

    private String name;
    ArrayList<Course> courses = new ArrayList();

    public Menu(String name){
        this.name = name;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(String name){
        getCourses().add(new Course(name));
    }


}
