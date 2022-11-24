package GP.src;

/**
 * Creates staff object
 * @author Olan Healy
 */
public class Staff {
    private String name;
    private int id;
    private String password;

    public String getName() {return name; }
    public int getId() {return id;}
    public String getPassword() {return password;}

    /**
     * Constructor for staff object
     * @param name name of staff
     * @param id id of staff
     * @param password password of staff
     */
    public Staff(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    /**
     * Checks staff type
     * @return staff type in String
     */
    public String getStaffType() {
        if (this instanceof Manager) {
            return "Manager";
        } else if (this instanceof Waiter) {
            return "Waiter";
        } else if (this instanceof Chef) {
            return "Chef";
        } else {
            return "invalid";
        }
    }

    @Override
    public String toString() {
        return name + ": id =" + id + " : password=" + password;
    }
}

