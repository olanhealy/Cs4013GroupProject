package GP.src;

import static java.lang.Integer.parseInt;

/**
 * Holds information used for bookings
 * @author Kevin Collins
 */
public class CustomerInformation {

    private String name, phoneNumber, numberOfGuests, timeOfArrival, occasion, allergies, specialRequests;

    //getters
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public int getNumberOfGuests() { return parseInt(numberOfGuests); }
    public int getTimeOfArrival() { return parseInt(timeOfArrival); }

    /**
     *
     * @param name name of customer
     * @param phoneNumber number of customer
     * @param timeOfArrival time of booking
     * @param numberOfGuests number of guests arriving
     * @param occasion any occasion occuring
     * @param allergies any allergies of guests
     * @param specialRequests any special requests
     */
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
                "| Name : " + name +
                "| PhoneNumber : " + phoneNumber +
                "| Time of Arrival : " + timeOfArrival +
                "| NumberOfGuests : " + numberOfGuests +
                "| Occasion : " + occasion +
                "| Allergies : " + allergies +
                "| SpecialRequests : " + specialRequests
                        + "\n"
                ;
    }

    public String toStringForFile() {
        return name + "," + phoneNumber + "," + timeOfArrival + "," + numberOfGuests + "," + occasion + "," + allergies + "," + specialRequests;
    }
}
