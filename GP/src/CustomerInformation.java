package GP.src;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class CustomerInformation {

    Scanner scanner;
    private String name, timeOfArrival, occasion, allergies, specialRequests;
    private String phoneNumber;
    private String numberOfGuests;
    //private Date timeOfArrival;

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getNumberOfGuests() {
        return parseInt(numberOfGuests);
    }

    //collects all info from customer
    public CustomerInformation(String name, String phoneNumber, String timeOfArrival, String numberOfGuests, String occasion, String allergies, String specialRequests){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.timeOfArrival = timeOfArrival;
        this.numberOfGuests = numberOfGuests;
        this.occasion = occasion;
        this.allergies = allergies;
        this.specialRequests = specialRequests;
    }

    @Override
    public String toString() {
        return "CustomerInformation:" +
                " Name = " + name +
                " Time of Arrival " + timeOfArrival +
                " Occasion " + occasion +
                " Allergies = " + allergies +
                " SpecialRequests = " + specialRequests +
                " PhoneNumber = " + phoneNumber +
                " NumberOfGuests = " + numberOfGuests + "\n";
    }
}
