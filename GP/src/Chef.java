package GP.src;

public class Chef extends Staff {



    public Chef(String name, int staffID, String password) {
        super(name, staffID, password); //as chef is a staff member, using inheritance means we don't have to rewrite the code
        // for all staff members

    }
}