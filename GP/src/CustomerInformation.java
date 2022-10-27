package GP.src;

import java.util.ArrayList;
import java.util.Date;

public class CustomerInformation {

    private String name, occasion, allergies, specialRequests;
    private String phoneNumber;
    int numberOfGuests;
    //private Date timeOfArrival;


    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CustomerInformation(String name, String phoneNumber, int numberOfGuests, String occasion, String allergies, String specialRequests){
        this.name = name;
        this.phoneNumber = phoneNumber;
  //      this.timeOfArrival = timeOfArrival;
        this.numberOfGuests = numberOfGuests;
        this.occasion = occasion;
        this.allergies = allergies;
        this.specialRequests = specialRequests;
    }

    @Override
    public String toString() {
        return "CustomerInformation:" +
                " Name = " + name +
                " Occasion " + occasion +
                " Allergies = " + allergies +
                " SpecialRequests = " + specialRequests +
                " PhoneNumber = " + phoneNumber +
                " NumberOfGuests = " + numberOfGuests + "\n";
    }
}
