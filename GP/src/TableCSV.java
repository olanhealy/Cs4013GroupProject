package GP.src;

import java.io.*;

/**
 * This class is used to read and write CSV files for Table.
 * @author 	Kevin Collins
 */
public class TableCSV {

    /**
     * This method is used to read a CSV file and return a Table object.
     *
     * @param filePath   The name of the file to be read.
     * @param restaurant The restaurant object to be used.
     */
    public void readFromCSV(String filePath, Restaurant restaurant) {

        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");
                final String UTF8_BOM = "\uFEFF";
                while (values[0].startsWith(UTF8_BOM)) {
                    values[0] = values[0].substring(1);
                }
                Table table = new Table(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
                restaurant.addTable(table.getTableNumber(), table.getNumberOfSeats());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method is used to write a CSV file from a Table object.
     *
     * @param fileName The name of the file to be written.
     * @param table    The table object to be written.
     */
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
