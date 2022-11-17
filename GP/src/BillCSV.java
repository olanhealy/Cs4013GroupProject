package GP.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.ArrayList;    

public class BillCSV {
	
	private int year;
	
	private int month;
	
	private int day;
	
	private ArrayList<Bill> bills = new ArrayList<Bill>();
	
	public BillCSV(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public void addBills(Bill bill) {
		bills.add(bill);
	}
	
	public void writeToCsv(String fileName) {
		try {
			FileWriter out = new FileWriter(fileName, true);
			for(Bill bill : bills) {
				out.write((day + "/"+ month +"/"+ year + ","+  bill.getTotal())+", \n");
			}
			
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void readFromCSV(String fileName) {
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			while((line = br.readLine()) != null) {
				String[] values = line.split(", ");
				System.out.println("Date: " + values[0] + " Total: "+ values[1]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
	
	

