package GP.src;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


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

				total = total + Double.parseDouble(values[1]);

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
				System.out.println("Date: " + values[0] + " Total: €" + values[1]);

				total = total + Double.parseDouble(values[1]);

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
		System.out.print("Please Enter Start Date dd/mm/yy (non-inclusive)");
		String date = scanner.nextLine();
		int day1 = Integer.parseInt(date.substring(0, 2));
		System.out.println("Please Enter End Date dd/mm/yyyy (non-inclusive)");
		String endDate = scanner.nextLine();


		ArrayList<String> dates = new ArrayList<>();
		try {


			BufferedReader br = new BufferedReader(new FileReader(fileName));


			while ((line = br.readLine()) != null) {

				String[] values = line.split(", ");

				dates.add(values[0] + ", " + values[1]);

			}
			for(int i = 0; i < dates.size(); i ++){
				String[] values = dates.get(i).split(", ");
				int day2 = Integer.parseInt(values[0].substring(0,2));
				if((values[0].equals(date) || values[0].equals(endDate) == false) && day2 > day1){
					System.out.println("Date: " + values[0] + " Total: €" + values[1]);
					total = total + Double.parseDouble(values[1]);
				}
			}
			System.out.println("Total sales in this period €" + total);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

	

