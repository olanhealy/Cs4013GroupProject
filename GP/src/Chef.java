package GP.src;

/**
 * Creates a chef object
 * @author Olan Healy
 */
public class Chef extends Staff {

    /**
     * Creates Chef Object
     * @param name Name of Chef
     * @param staffID Staff ID of Chef
     * @param password Password of Chef
     */
    public Chef(String name, int staffID, String password) {
        super(name, staffID, password); //as chef is a staff member, using inheritance means we don't have to rewrite the code
        // for all staff members

    }
}