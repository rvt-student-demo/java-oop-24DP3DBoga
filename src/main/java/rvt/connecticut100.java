package rvt;
import java.util.Scanner;

public class Connecticut100 {
    public static void main(String[] args) {
        MultipleGroups();
    }


    public static void DivisionPractice() {
            Scanner scan = new Scanner(System.in);
    
            while (true) {
                System.out.print("Enter the numerator: ");
                String input = scan.next();
    
                if (input.toLowerCase().charAt(0) == 'q') {
                    break;
                }
    
                try {
                    int numerator = Integer.parseInt(input);
    
                    System.out.print("Enter the divisor: ");
                    String divInput = scan.next();
                    int divisor = Integer.parseInt(divInput);
    
                    if (divisor == 0) {
                        System.out.println("You can't divide " + numerator + " by 0");
                    } else {
                        System.out.println(numerator + " / " + divisor + " is " + (numerator / divisor));
                    }
    
                } catch (NumberFormatException e) {
                    System.out.println("You entered bad data.");
                    System.out.println("Please try again.");
                }
                
                System.out.println();
            
        }
    }


    public static void MultipleGroups() {
        Scanner scan = new Scanner(System.in);
        String currentGroup = null;
        int sum = 0;
        boolean firstGroup = true;

        while (scan.hasNextLine()) {
            String line = scan.nextLine().trim();
            if (line.isEmpty()) continue;

            try {
                int number = Integer.parseInt(line);
                sum += number;
            } catch (NumberFormatException e) {
                if (!firstGroup) {
                    System.out.println("Sum = " + sum);
                    System.out.println();
                }
                
                System.out.println(line);
                currentGroup = line;
                sum = 0;
                firstGroup = false;
            }
        }
        
        if (currentGroup != null) {
            System.out.println("Sum = " + sum);
        }
    }
}