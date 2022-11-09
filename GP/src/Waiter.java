package GP.src;

public class Waiter extends Staff {
    private boolean dropFood = false;
    public Waiter(String name, int id, String password) {
        super(name, id, password);

    }
    public boolean getDropFood() {
        return dropFood;
    }


    public void chefNotifyWaiter() {
        dropFood = true;
    }


}
