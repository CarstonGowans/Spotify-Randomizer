import java.util.ArrayList;
public class Hello {
    public static void main(String[] args) {            // Data Initalization 
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


