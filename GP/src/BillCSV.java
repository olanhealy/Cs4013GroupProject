<<<<<<< HEAD
package GP.src;

=======
 package GP.src;
>>>>>>> 3cbb591815c991bb3d528d45727338979223239f
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
