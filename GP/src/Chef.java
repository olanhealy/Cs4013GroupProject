package GP.src;

public class Chef extends Staff {

    private Order order;
    private Course course;
    public Chef(String name, int staffID) {
        super(name, staffID);

    }

    public Course getCourse() {
        return course;
    }

    /**
     * @param course
     * @return the time it takes to for a particular food in the  course to take
     * @author: Olan Healy
     */
    public int timeToCook(Course course) {

        if (course.getName().equals("Starter")) {
            return 5;
        } else if (course.getName().equals("Main")) {
            return 20;
        } else if (course.getName().equals("Dessert")) {
            return 5;
        } else {
            return 1;
        }
    }

    public void dropFoodQuestionMark(Course course, Waiter waiter) {
    if  (order.checkStatusChef("READY")) {
        System.out.println("Time to cook: " + timeToCook(course));
        waiter.chefNotifyWaiter();
        }
    }


}