package GP.src;
import java.io.BufferedReader;
import java.util.Scanner;
import java.time.LocalDate;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;    
/**
 * 
 * @author seanc
 *
 */
public class BillCSV {

	private int year;

	private int month;

	private int day;

	private ArrayList<Bill> bills = new ArrayList<Bill>();

	private LocalDate date = LocalDate.now();

	/**
	 * Creates date for data being written to CSV file
	 */
	public BillCSV() {

		String dateToString = date.toString();

		String dates[] = dateToString.split("-");

		this.year = Integer.parseInt(dates[0]);
		this.month = Integer.parseInt(dates[1]);
		this.day = Integer.parseInt(dates[2]);
		
		/*
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter year");
		this.year = scanner.nextInt();
		System.out.println("Enter Month");
		this.month = scanner.nextInt();
		System.out.println("Enter day");
		this.day = scanner.nextInt();
		*/
	}

	/**
	 * @param bill Adds bill object to bills array list
	 */
	public void addBills(Bill bill) {
		this.bills.add(bill);
	}

	/**
	 * Writes bill infromation to CSV file
	 *
	 * @param fileName String for CSV filepath
	 */
	public void writeToCsv(String fileName) {
		try {
			FileWriter out = new FileWriter(fileName, true);
			for (Bill bill : bills) {
				out.write((day + "/" + month + "/" + year + "," + bill.toString()) + ", \n");
			}

			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @param fileName String that holds the file path to PaymentRecords.csv
	 * Method read CSV data and holds it in array values
	 *
	 */
	public String[] readFromCSV(String fileName) {

		String line = "";
		double total = 0;

		String[] empty = new String[0];
		try {

			BufferedReader br = new BufferedReader(new FileReader(fileName));


			while ((line = br.readLine()) != null) {

				//Stores CSV elements in array values
				String[] values = line.split(", ");

				total = total + Double.parseDouble(values[2]);

				//returns an array of values
				return values;
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//return empty array if file not read
		return empty;
	}

	/**
	 *
	 * @param fileName String that holds the file path to PaymentRecords.csv
	 * Method prints CSV file data to the console
	 */
	public void displayCSV(String fileName){

		String line = "";
		double total = 0;

		try {

			BufferedReader br = new BufferedReader(new FileReader(fileName));


			while ((line = br.readLine()) != null) {

				String[] values = line.split(", ");

				//Prints CSV elements to console
				System.out.println("Date: " + values[0] + " Total: €" + values[2] + " " + values[3] + " " + values[4]
						+ " " + values[5] + " " + values[6] + " " + values[7] + " " + values[8] + " " + values[9]);

				total = total + Double.parseDouble(values[2]);

			}

			System.out.println("Total sales: €" + total);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

			}

	public void readFromCSVByDate(String fileName) {

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String line = "";
		double total = 0;
		System.out.print("Please Enter Date dd/mm/yy");
		String date = scanner.nextLine();
		try {


			BufferedReader br = new BufferedReader(new FileReader(fileName));


			while ((line = br.readLine()) != null) {

				String[] values = line.split(", ");

				if (values[0].equals(date)) {

					System.out.println("Date: " + values[0] + " Total: €" + values[2] + " " + values[3] + " " + values[4]
							+ " " + values[5] + " " + values[6] + " " + values[7] + " " + values[8] + " " + values[9]);

					total = total + Double.parseDouble(values[2]);

				}

			}
			System.out.println("Total sales for " + date + ": €" + total);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

	

