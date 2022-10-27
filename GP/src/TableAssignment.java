package GP.src;

import java.util.Scanner;

public class TableAssignment {
    Scanner scanner = new Scanner(System.in);
    private  int tableCount = 0;

    Table [] table = new Table[20];


    public TableAssignment() {
        System.out.println("Hello this is YUM restaurant, would you like to make a booking?");
        String yesNo = scanner.next();
        if(yesNo.equals("Yes") ) {
            System.out.println("How many seats do you need? ");
            int numberOfSeatsNeeded = scanner.nextInt();
            addTable(numberOfSeatsNeeded);
            displayTables();
        } else if (yesNo.equals("No")) {
            System.exit(0);

        }


    }

        public void addTable (int numberOfSeats) {
            table[tableCount] = new Table(tableCount, numberOfSeats);
            table[tableCount].setAvailable(true);
             tableCount++;
        }
    public void displayTables()
    {
        for(int i = 0;i<tableCount;i++)
        {
            System.out.println(table[i].toString());
        }
    }




    }

