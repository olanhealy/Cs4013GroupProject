package GP.src;

import java.io.*;
import java.util.Scanner;

public class TableCSV {

    public TableCSV() {

    }

    //read from CSV file
    public void readFromCSV(String filePath, Restaurant restaurant) {

        String line = "";

                try {
                    BufferedReader br = new BufferedReader(new FileReader(filePath));

                    while((line = br.readLine()) != null) {

                        String[] values = line.split(",");
                        Table table = new Table(Integer.parseInt(values[0]),Integer.parseInt(values[1]));
                        restaurant.addTable(table.getTableNumber(), table.getNumberOfSeats());
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

    public void writeToCsv(String fileName, Table table) {
        try {
            FileWriter out = new FileWriter(fileName, true);
            out.write((table.toStringForFile()) + ", \n");

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
        }
