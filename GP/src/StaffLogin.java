package GP.src;
import javafx.scene.control.Tab;

import java.util.ArrayList;
import java.util.Scanner;
public class StaffLogin {
    private Table t; //same as order
    private Menu m; //same as order
    private Order o; // not sure if needed but for viewing orders use .showOrder()??
    private BookingsList b; //same as Order object
    private Scanner staff = new Scanner(System.in);
    private ArrayList<Staff> staffList = new ArrayList<Staff>(); //Olan had this as just as 'ArrayList<Staff> stafflist' but was getting
    // a null point exception error. changed it to  'ArrayList<Staff> staffList = new ArrayList<Staff>();' need to figure out why


    public StaffLogin(ArrayList<Staff> staffList) {
        this.staffList = staffList;

    }

    public void addStaff(Staff staff) {
        staffList.add(staff);
        staffList.add(new Waiter("Billy", 13, "HelterSkelter13"));
        staffList.add(new Chef("Sally", 8, "Yum564"));

    }

    public void removeStaff(Staff staff) {
        staffList.remove(staff);
    }

    public StaffLogin() {

    }

    /**
     * @param id
     * @param password
     * @param staffList
     * @return true or false whether or not the staff id and password are correct
     * @author: Olan Healy
     */
    public boolean valid(int id, String password, ArrayList<Staff> staffList) {
        for (Staff staff : staffList) {
            if ((staff.getId() == id) && (staff.getPassword().equals(password))) {
                return true;
            }
        }
        return false;
    }





    public void system() {
        while (true) {
            System.out.println(staffList);
            System.out.println("Enter staff ID");
            int id = staff.nextInt();
            System.out.println("Enter password");
            String password = staff.next();
            if (valid(id, password, staffList)) {

                for (Staff s : staffList) {
                    if (s.getId() == id) {
                        System.out.println("Welcome, " + s.getName());
                        if (s instanceof Manager) {
                            System.out.println("Manager options");
                            System.out.println("1. View bookings");
                            System.out.println("2. View orders");
                            System.out.println("3. View tables");
                            System.out.println("4. View menu");
                            System.out.println("5. Add staff");
                            System.out.println("6. Remove staff");
                            System.out.println("7. View Bills");
                            System.out.println("7. Logout");
                            int choice = staff.nextInt();
                            switch (choice) {
                                case 1 -> System.out.println(b);
                                case 2 -> System.out.println(o);
                                case 3 -> System.out.println(t);
                                case 4 -> System.out.println(m);
                                case 5 -> {
                                    addStaff(s);
                                    System.out.println("Enter staff name");
                                    String name = staff.next();
                                    System.out.println("Enter staff ID");
                                    int staffId = staff.nextInt();
                                    System.out.println("Enter staff password");
                                    String staffPassword = staff.next();
                                    System.out.println("Enter staff role");
                                    String role = staff.next();
                                    if (role.equals("waiter")) {
                                        staffList.add(new Waiter(name, staffId, staffPassword));
                                    } else if (role.equals("chef")) {
                                        staffList.add(new Chef(name, staffId, staffPassword));
                                    } else if (role.equals("manager")) {
                                        staffList.add(new Manager(name, staffId, staffPassword));
                                    } else {
                                        System.out.println("Invalid role");
                                    }
                                }
                                case 6 -> {
                                    System.out.println("Enter staff ID");
                                    int staffId1 = staff.nextInt();
                                    for (Staff staff : staffList) {
                                        if (staff.getId() == staffId1) {
                                            staffList.remove(staff);
                                        }

                                    }
                                }
                                case 7 -> System.out.println("Logging out");
                            }
                        } else if (s instanceof Waiter) {
                            System.out.println("A)dd order, V)iew order T)ake booking, S)ee bookings, P)ayment, Q)uit");
                            String input = staff.next(); //why is this not working?
                            switch (input) {
                                case "A":
                                    System.out.println("Add order");
                                    // System.out.println(o.takeOrder( t,  m)); //TODO: need to figure out how to get order to work
                                    break;
                                case "V":
                                    System.out.println("View order");
                                    System.out.println(o.getOrders());
                                    break;
                                case "T":
                                    System.out.println("Take booking");
                                    //TODO: need to figure out how to get booking to work
                                    break;
                                case "S":
                                    System.out.println("See bookings"); //Hopefully works
                                    System.out.println(b.getBookingList());
                                case "P":
                                    System.out.println("Payment");
                                    break; //TODO: need to figure out how to get payment to work
                                case "Q":
                                    System.out.println("Quit");
                                    break;
                                default:
                                    System.out.println("Invalid input");
                            }
                        } else if (s instanceof Chef) {
                            System.out.println("V)iew order N)ext order Q)uit");

                            String choice = staff.next();
                            switch (choice) {
                                case "V":
                                    System.out.println(o); //TODO: need to figure out how to get order to work
                                    break;
                                case "N": System.out.println("next order"); //TODO: need to figure out how to get order to work
                                    break;
                                case "Q": System.out.println("Quit");
                                    break;
                            }
                        }
                    }
                }
            } else {
                System.out.println("Invalid ID or password");
            }
        }
    }
}
