package src.MathCalculations;

import java.util.ArrayList;
import java.util.Scanner;

public class MathCalculations {
    public static Scanner myScanner = new Scanner(System.in);      // Scanner For Input            

    public static String getUserInput() {                          // Function for gathering User Input
        System.out.print("> ");
        return myScanner.nextLine();
    }

    public static int[] stringArrayToIntArray(String[] strings) {  // Function for converting String Input to Int array
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

    public static int sum(int[] intArray) {                    // Function for calculating sum
        int sum = 0;
        for(int i = 0; i < intArray.length; i++) {              // Read in Ints and pasrse for information: If the first number in the input doesn't matter, change back to int i = 0...
            sum += intArray[i];   
        }
        return sum;
    }

    public static ArrayList<Integer> evens(int[] intArray) {   // Function for calculating even values
        ArrayList<Integer> evens = new ArrayList<Integer>();
        for(int i = 0; i < intArray.length; i++) {
            if(intArray[i] % 2 == 0) {                          // Determine if int is even using Modulo Division
                evens.add(intArray[i]);                
            }
        }
        return evens;
    }

    public static ArrayList<Integer> odds(int[] intArray) {    // Function for determining odd values
        ArrayList<Integer> odds = new ArrayList<Integer>();
        for(int i = 1; i < intArray.length; i++) {
            if(intArray[i] % 2 != 0) {                          // Determine if int is odd using Modulo Division
                odds.add(intArray[i]);                
            }
            else {}
        }
        return odds;
    }

    public static int max(int[] intArray) {                    // Function for calculating new max value
        if (intArray.length == 1) {                             // Return first number if size is 1
            return intArray[0];
        }
        else {
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < intArray.length; i++) {              // Else, parse through the array to determine the max value
            if(intArray[i] > max) {                             
                max = intArray[i];
            }
        }
        return max;
        }
    }
    
    public static int min(int[] intArray) {                    // Function for calculating new min min value
        if (intArray.length == 1) {                             // Return first number if size is 1
            return intArray[0];                 
        }
        else {
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < intArray.length; i++) {              // Else, parse through the array to determine the min value
            if(intArray[i] < min) {                    
                min = intArray[i];
            }   
        }
        return min;
        }
    }
}
