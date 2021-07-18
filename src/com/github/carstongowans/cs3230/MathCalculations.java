package com.github.carstongowans.cs3230;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MathCalculations {
    public static Scanner myScanner = new Scanner(System.in);      // Scanner For Input            

    public static String getUserInput() {                          // Function for gathering User Input
        System.out.print("> ");
        return myScanner.nextLine();
    }

    public static int[] stringArrayToIntArray(String[] strings) {  // Function for converting String Input to Int array
        int[] integers = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            try {
                integers[i] = Integer.parseInt(strings[i]);
            } catch (NumberFormatException ex) {
                System.out.println("invalid integer, try again");
            }
        }
        Arrays.sort(integers);                                  // Check to ensure array is sorted for other functions
        return integers;
    }

    public static int sum(int[] intArray) {                     // Function for calculating sum
        return Arrays.stream(intArray).sum();                   // Stream function to parse the sum of the total array. 
                                                                // Streams can be used to parse the total array for it's information. So in this case, we're grabbing
                                                                // the information from the array through the stream and throwing that information into the .sum() function
    }

    public static ArrayList<Integer> evens(int[] intArray) {    // Function for calculating even values
        ArrayList<Integer> evens = new ArrayList<Integer>();
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] % 2 == 0) {                         // Determine if int is even using Modulo Division
                evens.add(intArray[i]);
            }
        }
        return evens;
    }

    public static ArrayList<Integer> odds(int[] intArray) {     // Function for determining odd values
        ArrayList<Integer> odds = new ArrayList<Integer>();
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] % 2 != 0) {                         // Determine if int is odd using Modulo Division
                odds.add(intArray[i]);
            } else {
            }
        }
        return odds;
    }

    public static int max(int[] intArray) {                     // Function for calculating new max value
        if (intArray.length == 1) {                             // Return first number if size is 1
            return intArray[0];
        } else {
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < intArray.length; i++) {         // Else, parse through the array to determine the max value
                if (intArray[i] > max) {
                    max = intArray[i];
                }
            }
            return max;
        }
    }

    public static int min(int[] intArray) {                     // Function for calculating new min min value
        if (intArray.length == 1) {                             // Return first number if size is 1
            return intArray[0];
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < intArray.length; i++) {         // Else, parse through the array to determine the min value
                if (intArray[i] < min) {
                    min = intArray[i];
                }
            }
            return min;
        }
    }

    public static double mean(int[] intArray) {                 // Function for calculating average
        double mean = sum(intArray) / intArray.length;          // Σ(intArray) / Count = average
        return mean;
    }

    public static double median(int[] intArray) {               // Function for calculating average
        int indexRange = intArray.length;

        if (indexRange % 2 == 0) {                              // The range is even, so grab the average between the two middle points
            int divRange = indexRange / 2;
            double medianValue = (double) (intArray[divRange] + intArray[divRange - 1]) / 2;
            return medianValue;
        } else {                                                // The range is odd, so just grab the mid point.
            double medianValue = intArray[Math.round(indexRange / 2)];
            return medianValue;
        }
    }

    public static double q1(int[] intArray) {                   // Function for calculating the First Quartile
        int index = (int) Math.floor(intArray.length / 2);      // Find the index but floor it down to determine the number of values in the first quartile
        int[] q1Array = new int[index];                         // Make a new array with the size of the first quartile
        for (int i = 0; i < index; i++) {                       // copy values of first quartile into it's array
            q1Array[i] = intArray[i];
        }
        return median(q1Array);                                 // Find the median
    }                                                           // The BigO time and space complexities aren't that good here. Space complexity isn't constant and the time complexity is a little worse than linear.
                                                                // I can't think of a way to make this any easier / better.

    public static double q3(int[] intArray) {                   // Function for calculating the Third Quartile
        int index = (int) Math.floor(intArray.length / 2);      // Same as above, except for the boundaries is everything after the median value.
        int[] q3Array = new int[index];
        for (int i = 0; i < index; i++) {
            q3Array[i] = intArray[intArray.length - index + i];
        }
        return median(q3Array);
    }

    public static double standardDeviation(int[] intArray) {    // Standard Deviation Function from https://www.programiz.com/java-programming/examples/standard-deviation. (Given through the assignment instructions repo).
        double stdDeviation = 0;
        int sum = sum(intArray);
        double mean = mean(intArray);

        for (double value : intArray) {
            stdDeviation += Math.pow(value - mean, 2);
        }

        return Math.sqrt(stdDeviation / intArray.length);
    }
}
