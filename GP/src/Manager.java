package GP.src;

/**
 * This class creates a Manager
 * @author Olan Healy
 */
public class Manager extends Staff {

    /**
     * Constructor for objects of class Manager
     * @param name The name of the manager
     * @param staffID The staff ID of the manager
     * @param password The password of the manager
     */
    public Manager(String name, int staffID, String password) {
        super(name, staffID, password);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
