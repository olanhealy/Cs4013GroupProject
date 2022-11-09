package GP.src;

public class Staff {
    private String name;
    private int id;
    private String password;



    public Staff(String name, int staffID, String password) {
        this.name = name;
        this.id = staffID;
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }



}
