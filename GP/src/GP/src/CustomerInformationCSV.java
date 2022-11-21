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

    public void writeToCsv(String fileName, BookingsList bookings) {
        try {
            FileWriter out = new FileWriter(fileName, true);
            for (CustomerInformation customer : bookings.getBookingList()) {
                out.write((customer.toStringForFile()) + ", \n");
            }

            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
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


