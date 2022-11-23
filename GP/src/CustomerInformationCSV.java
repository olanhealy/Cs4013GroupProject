package GP.src;

import java.io.*;
import java.util.Scanner;

public class CustomerInformationCSV {

    public void readFromCSV(String filePath, BookingsList Bookings) {

        String line = "";
        double total = 0;

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

    public void writeToCsv(String fileName, CustomerInformation customer) {
        try {
            FileWriter out = new FileWriter(fileName, true);
            out.write((customer.toStringForFile()) + ", \n");

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
