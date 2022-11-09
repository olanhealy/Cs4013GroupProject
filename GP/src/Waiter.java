package GP.src;

public class Waiter extends Staff {
    private boolean dropFood = false;
    public Waiter(String name, int id) {
        super(name, id );

    }
    public boolean getDropFood() {
        return dropFood;
    }


    public void chefNotifyWaiter() {
        dropFood = true;
    }


}
