import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;    

public class BillCSV {

	private Bill bill;
	
	private LocalDate date;
	
	public BillCSV(Bill bill, int year, int month, int day) {
		this.bill = bill;
		this.date = LocalDate.of(year, month, month);
	}
	
	public void writeToCsv(String filename) {
		try(PrintWriter pw = new PrintWriter(filename)){
			
			pw.write(date.toString() + ", ");
			pw.write(bill.toString() + ", ");
			
			
		}catch(FileNotFoundException e) {
			System.out.print("Error creating file");
			e.printStackTrace();
		}
	}
}
