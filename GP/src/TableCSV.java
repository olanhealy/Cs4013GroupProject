package GP.src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        }
