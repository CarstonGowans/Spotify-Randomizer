        package com.github.carstongowans.cs3230;
        import java.util.List;
        import java.util.ArrayList;
        import java.util.Scanner;

        class Cli {
        public static void stringsCli(String[] args) {
            List<Boolean> palindromeResult;
            System.out.println("String Operations: Please Enter a list of strings delimited by spaces ");
            String[] stringsList = StringOperations.stringInputToList();

            Scanner input = new Scanner(System.in);
            int operation = 0;

            while(operation != 2) {                             // Valid input
                System.out.println("Please select an Operation\n1. Palindrome Checker\n2. Back to Main Menu");
                operation = input.nextInt();
                switch(operation) {
                    case 1: palindromeResult = StringOperations.palindromeCheck(stringsList);
                       for(int i = 0; i < palindromeResult.size(); i++) {
                           System.out.print(stringsList[i] + ": ");
                           if(palindromeResult.get(i) == true) {
                               System.out.println("Is a palindrome");
                           }
                           else {
                               System.out.println("Is not a palindrome");
                           }
                       }
                    break;
                    case 2: Main.main(args);
                    break;
                    default: break;
                }
            }
        }

        public static void cli(String [] args) {                                                                    // Main Driver code for Cli
        //Cli cli = new Cli();
        System.out.println("Enter list of Integers. (space separated): ");
        int [] ints = MathCalculations.stringArrayToIntArray(MathCalculations.getUserInput().split("\\s+"));  // Input Information into Array from stringToIntArray() function
       
        int operation = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose an Operation\n1. Sum - sum the integers\n2. Evens - find the evens\n3. Odds - find the odds\n4. Max - find the max\n5. Min - find the min\n6. Update - enter a new list of integers\n7. Exit");
        
        while(operation != 7) {                                                 // While loop to loop through commands
            operation = scan.nextInt();
            switch(operation) {
                case 1: {                                                       // Output for Sum
                    int sum = MathCalculations.sum(ints);
                    System.out.println("Sum - " + sum);
                    break;
                }
                case 2: {                                                       // Output for Evens
                    ArrayList<Integer> evens = MathCalculations.evens(ints);
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
                case 3: {                                                       // Output for Odds
                    ArrayList<Integer> odds = MathCalculations.odds(ints);
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
                case 4: {                                                       // Output for Max Value
                    int max = MathCalculations.max(ints);
                    System.out.println("Max: " + max);
                    break;
                }
                case 5: {
                    int min = MathCalculations.min(ints);                       // Output for Min Value
                    System.out.println("Min: " + min);
                    break;
                }
                case 6: {                                                       // Function call for inserting new Ints
                    System.out.println("Enter list of Integers. (space separated): ");
                    ints = MathCalculations.stringArrayToIntArray(MathCalculations.getUserInput().split("\\s+"));
                    System.out.println("Choose an Operation\n1. Sum - sum the integers\n2. Evens - find the evens\n3. Odds - find the odds\n4. Max - find the max\n5. Min - find the min\n6. Update - enter a new list of integers\n7. Exit");
                    break;
                }
                case 7:                                                         // Function call to break out of loop
                    Main.main(args);
                    break;
            }
        }
        System.out.println("Goodbye!");
        scan.close();
    }

}