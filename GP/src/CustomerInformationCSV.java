package GP.src;

import java.io.*;
import java.util.Scanner;
/**
 * This class is used to read the customer information from a CSV file and store it in an array.
 * @author Kevin Collins
 * <p>
 *     This class is used to read the customer information from a CSV file and store it in an array.
 *     This class can write new customer information to the CSV file.
 * </p>
 */
public class CustomerInformationCSV {

    /**
     * This method is used to read the customer information from a CSV file and store it in an array.
     * @param filePath The path of the CSV file.
     * @param Bookings The array that the customer information will be stored in.
     */
    public void readFromCSV(String filePath, BookingsList Bookings) {

        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");
                CustomerInformation booking = new CustomerInformation(values[0], values[1], values[2], values[3], values[4], values[5], values[6]);
                Bookings.addBooking(booking);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to write new customer information to the CSV file.
     * @param filePath The path of the CSV file.
     * @param CustomerInformation The customer information that will be written to the CSV file.
     */
    public void writeToCsv(String filePath, CustomerInformation customer) {
        try {
            FileWriter out = new FileWriter(filePath, true);
            out.write((customer.toStringForFile()) + ", \n");

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
