package TableWriter;

import java.util.Scanner;

public class TableScanner {
    Row[] scanTable(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter left column");
        String headerLeft = scanner.nextLine();
        System.out.println("Please enter right column");
        String headerRight = scanner.nextLine();
        Row  header = new Row(headerLeft,headerRight);
        System.out.println("How many rows u want?");
        int rowsCount = scanner.nextInt();
        Row[] table = new Row[rowsCount + 1];
        table[0] = header;
        for(int i = 1;i < rowsCount + 1;i++){
            System.out.println("Enter " + i + "row");
            System.out.println("Left: ");
            String left = scanner.next();
            System.out.println("Right: ");
            String right = scanner.next();
            Row row = new Row(left,right);
            table[i] = row;

        }
        return table;

    }

}
