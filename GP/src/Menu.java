package GP.src;

import java.util.ArrayList;

public class Menu {

    ArrayList<Course> courses = new ArrayList();

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(String name){
        getCourses().add(new Course(name));
    }
}
