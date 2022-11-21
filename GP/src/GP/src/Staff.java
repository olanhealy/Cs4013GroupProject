package GP.src;

import java.util.ArrayList;

public class Staff {
    private String name;
    private int id;
    private String password;
    private ArrayList<Staff> staffList = new ArrayList<Staff>();



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
    public boolean validStaff(int id, String password, ArrayList<Staff> staffList) {
        for (Staff staff : staffList) {
            if ((staff.getId() == id) && (staff.getPassword().equals(password))) {
                return true;
            }
        }
        return false;
    }
    public void addStaff(ArrayList<Staff> staffList) {

        staffList.add(new Waiter("Billy", 13, "Helt23"));
        staffList.add(new Chef("Sally", 8, "Yu564"));
        staffList.add(new Manager("Bobby", 1, "1"));

    }


    @Override
    public String toString() {
        return name + ": id =" + id + " : password=" + password;
    }

    public ArrayList<Staff> getStaffList() {
        return staffList;
    }
}
