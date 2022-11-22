package GP.src;

import java.util.ArrayList;

public class Staff {
    private String name;
    private int id;
    private String password;


    public Staff(String name, int id, String password) {
        this.name = name;
        this.id = id;
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

    @Override
    public String toString() {
        return name + ": id =" + id + " : password=" + password;
    }
}
