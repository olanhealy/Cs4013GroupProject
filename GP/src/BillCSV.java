import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;    

public class BillCSV {

	private Bill bill;
	
	private LocalDate date;
	
	private ArrayList<Bill> bills = new ArrayList<Bill>();
	
	public BillCSV(int year, int month, int day) {
		this.date = LocalDate.of(year, month, month);
	}
	
	public void addBills(Bill bill) {
		bills.add(bill);
	}
	
	public void writeToCsv(String fileName){
		
		try {
		File csvFile = new File(fileName);
		PrintWriter out = new PrintWriter(csvFile);
		
		for(Bill bill : bills) {
			out.println(date + bill.toString());
			out.println("\n");
		}
		
		out.close();
		}catch(FileNotFoundException a) {
		
		}
	}
}
	
	

