package GP.src;
public class TestTable {
    public static void main(String args[]) {
        Restaurant restaurant = new Restaurant(24);


        CustomerInformation booking1 = new CustomerInformation("John Francis", "0873416741", "12:00",2, "Birthday", "Wheat", "None");
        CustomerInformation booking2 = new CustomerInformation("Mary Richards", "0871234567", "13:30",5, "Date Night", "None", "Wedding ring");
        CustomerInformation booking3 = new CustomerInformation("Hugh B. Pipen", "0869395333", "14:00",12, "None", "None", "Window Seat");


        TableAssignment assign = new TableAssignment(restaurant, booking1);

        System.out.println(restaurant);

    }
}
