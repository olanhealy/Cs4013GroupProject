package GP.src;

public class Waiter extends Staff {
    private boolean dropFood = false;
    public Waiter(String name, int id, String password) {
        super(name, id, password);

    }
    //getter
    public boolean getDropFood() {
        return dropFood;
    }


    /**
     * if the chef notifies the waiter, then drop food is set to true
     * @author: Olan Healy
     */

    public void chefNotifyWaiter() {
        dropFood = true;
    }

    /**
     * if the chef notifies waiter that food is ready, waiter should drop the food
     * @param course
     * @author: Olan Healy
     */
    public void dropFood(Course course) {
        if (dropFood == true) {
            System.out.println("Waiter has dropped the ");
        }
    }

}
