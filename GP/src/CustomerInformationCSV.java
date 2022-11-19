package GP.src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CustomerInformationCSV {

    public CustomerInformationCSV() {

    }

    public void readFromCSV(String filePath, BookingsList Bookings) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Read Bookings Y/N");
        String input = scanner.nextLine();
        String line = "";
        double total = 0;

        if (input.equals("Y")) {

            System.out.println("Enter 'A' to show all Bookings ");
           // System.out.println("Or enter 'T' for Bookings by a specific Time");
            input = scanner.nextLine();
            if (input.equals("A")) {

                try {
                    BufferedReader br = new BufferedReader(new FileReader(filePath));

                    while ((line = br.readLine()) != null) {

                        String[] values = line.split(",");
                        CustomerInformation booking = new CustomerInformation(values[0], values[1], values[2], values[3], values[4], values[5], values[6]);
                        Bookings.addBooking(booking);
                    }
                    System.out.println(Bookings);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//            else if (input.equals("T")) {
//
//                System.out.print("Please Enter Time HH");
//                String time = scanner.nextLine();
//                try {
//
//
//                    BufferedReader br = new BufferedReader(new FileReader(filePath));
//
//
//                    while ((line = br.readLine()) != null) {
//
//                        String[] values = line.split(", ");
//
//                        if (values[0].equals(time)) {
//
//                            System.out.println("Time: " + values[0] + " Number" + values[2] + " Time of Arrival: " + values[3] + " Number of Guests " + values[4]
//                                    + " Occasion: " + values[5] + " Allergies: " + values[6] + " Special Requests" + values[7]);
//
//                        }
//
//                    }
//
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}

