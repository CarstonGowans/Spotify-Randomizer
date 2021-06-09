import java.util.ArrayList;
import java.util.Scanner;

public class Cli {
    private static Scanner myScanner = new Scanner(System.in);

    private static String getUserInput() {
        System.out.print("> ");
        return myScanner.nextLine();
    }

    private static int[] stringArrayToIntArray(String[] strings) {
        int[] integers = new int[strings.length];

            for(int i = 0; i < strings.length; i++) {
                try {
                    integers[i] = Integer.parseInt(strings[i]);
                } catch (NumberFormatException ex) {
                    System.out.println("invalid integer, try again");
                }
            }
        return integers;
    }

    private static int sum(int[] intArray) {
        int sum = 0;
        for(int i = 0; i < intArray.length; i++) {            // Read in Ints and pasrse for information: If the first number in the input doesn't matter, change back to int i = 0...
            sum += intArray[i];   
        }
        return sum;
    }

    private static ArrayList<Integer> evens(int[] intArray) {
        ArrayList<Integer> evens = new ArrayList<Integer>();
        for(int i = 0; i < intArray.length; i++) {
            if(intArray[i] % 2 == 0) {                  // Determine if int is even or odd 
                evens.add(intArray[i]);                
            }
        }
        return evens;
    }

    private static ArrayList<Integer> odds(int[] intArray) {
        ArrayList<Integer> odds = new ArrayList<Integer>();
        for(int i = 1; i < intArray.length; i++) {
            if(intArray[i] % 2 != 0) {                  // Determine if int is even or odd 
                odds.add(intArray[i]);                
            }
            else {}
        }
        return odds;
    }

    private static int max(int[] intArray) {
        if (intArray.length == 1) {
            return intArray[0];
        }
        else {
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < intArray.length; i++) {
            if(intArray[i] > max) {                     // Determine new max value
                max = intArray[i];
            }
        }
        return max;
        }
    }
    
    private static int min(int[] intArray) {
        if (intArray.length == 1) {
            return intArray[0];
        }
        else {
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < intArray.length; i++) {
            if(intArray[i] < min) {                     // Determine new min value
                min = intArray[i];
            }   
        }
        return min;
        }
    }

    public static void main(String [] args) {
        //Cli cli = new Cli();
        System.out.println("Enter list of Integers. (space separated): ");
        int [] ints = Cli.stringArrayToIntArray(getUserInput().split("\\s+"));
       
        int operation = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose an Operation\n1. Sum - sum the integers\n2. Evens - find the evens\n3. Odds - find the odds\n4. Max - find the max\n5. Min - find the min\n6. Update - enter a new list of integers\n7. Exit");
        while(operation != 7) {
            operation = scan.nextInt();
            switch(operation) {
                case 1: {
                    int sum = Cli.sum(ints);
                    System.out.println("Sum - " + sum);
                    break;
                }
                case 2: {
                    ArrayList<Integer> evens = Cli.evens(ints);
                    System.out.print("Even: ");
                    for(int i = 0; i < evens.size(); i++) {
                        if(i != evens.size() - 1) {
                            System.out.print(evens.get(i) + ", ");
                        }
                        else {
                            System.out.println(evens.get(i));
                        }
                    }
                    break;
                }
                case 3: {
                    ArrayList<Integer> odds = Cli.odds(ints);
                    System.out.print("Odds: ");
                    for(int i = 0; i < odds.size(); i++) {
                        if(i != odds.size() - 1) {
                            System.out.print(odds.get(i) + ", ");
                        }
                        else {
                            System.out.println(odds.get(i));
                        }
                    }
                    break;
                }
                case 4: {
                    int max = Cli.max(ints);
                    System.out.println("Max: " + max);              // Print Max
                    break;
                }
                case 5: {
                    int min = Cli.min(ints);
                    System.out.println("Min: " + min);              // Print Min
                    break;
                }
                case 6: {
                    System.out.println("Enter list of Integers. (space separated): ");
                    ints = Cli.stringArrayToIntArray(getUserInput().split("\\s+"));
                    System.out.println("Choose an Operation\n1. Sum - sum the integers\n2. Evens - find the evens\n3. Odds - find the odds\n4. Max - find the max\n5. Min - find the min\n6. Update - enter a new list of integers\n7. Exit");
                    break;
                }
                case 7:
                    operation = 7;
                    break;
            }
        }
        System.out.println("Goodbye!");
        scan.close();
    }
}
  /*   public static void main1(String[] args) {            // Data Initalization 
        int argLength = args.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        ArrayList<Integer> evens = new ArrayList<Integer>();
        ArrayList<Integer> odds = new ArrayList<Integer>();
        int[] intArray = new int[argLength];
        
        for(int i = 1; i < argLength; i++) {            // Read in Ints and pasrse for information: If the first number in the input doesn't matter, change back to int i = 0...
            intArray[i] = Integer.parseInt(args[i]);
            sum += intArray[i];                         // Sum Array values

            if(intArray[i] % 2 == 0) {                  // Determine if int is even or odd 
                evens.add(intArray[i]);                
            }
            else {
                odds.add(intArray[i]);
            }

            if(intArray[i] > max) {                     // Determine new max value
                max = intArray[i];
            }

            if(intArray[i] < min) {                     // Determine new min value
                min = intArray[i];
            }   
        }
        System.out.println("Sum: " + sum);              // Print Sum

        System.out.print("Even: ");                     // Print Even values
        for(int i = 0; i < evens.size(); i++) {
            if(i != evens.size() - 1) {
                System.out.print(evens.get(i) + ", ");
            }
            else {
                System.out.println(evens.get(i));
            }
        }

        System.out.print("Odds: ");                     // Print Odd values
        for(int i = 0; i < odds.size(); i++) {
            if(i != odds.size() - 1) {
                System.out.print(odds.get(i) + ", ");
            }
            else {
                System.out.println(odds.get(i));
            }
        }

        System.out.println("Max: " + max);              // Print Max
        System.out.println("Min: " + min);              // Print Min
    }
}
*/

