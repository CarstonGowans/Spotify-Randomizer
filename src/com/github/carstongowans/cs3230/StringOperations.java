package com.github.carstongowans.cs3230;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringOperations {
    static List<Boolean> palindromeResult;
    static List<String> stringList = new ArrayList<String>();

    public static String[] stringInputToList() {                      // https://beginnersbook.com/2015/05/java-string-to-arraylist-conversion/#:~:text=1)%20First%20split%20the%20string,asList()%20method.
        stringList.clear();                                           // Clears list encase of re-input
        Scanner input = new Scanner(System.in);                       // Create Scanner for input
        String unParsedStrings = input.nextLine();                    // Grab the grouped String input
        String[] stringsArray = unParsedStrings.split(" ");     // Takes the inputted strings and splits it based on the space delimiter.

        stringList = Arrays.asList(stringsArray);                     // Convert from String array to String list using Array.asList()
        return stringsArray;                                          // Return String
    }

    public static List<Boolean> palindromeCheck(String[] stringsList) {
        List<Boolean> pR = new ArrayList<>();
        for (String s : stringsList) {                                 // For string in StringList
            StringBuilder parsedString = new StringBuilder(s);         // String Builder constructors and reverse to string objects
            StringBuilder stringReversed = new StringBuilder(parsedString.reverse().toString());
            parsedString.reverse();
            if (parsedString.compareTo(stringReversed) == 0) {         // If else statement for comparisons
                boolean t = true;
                pR.add(t);
            } else {
                boolean f = false;
                pR.add(f);
            }
        }
        return pR;
    }
}
