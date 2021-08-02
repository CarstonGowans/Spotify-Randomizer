package com.github.carstongowans.cs3230;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Helper {

    public static int[] inputToArray(String input) {
        int [] ints = MathCalculations.stringArrayToIntArray(input.split("\\s+"));  // Input Information into Array from stringToIntArray() function
        return ints;
    }

    public static String minStringBuilder(int[] ints) {
        int minValue = MathCalculations.min(ints);
        return "Min: " + minValue;
    }

    public static String maxStringBuilder(int[] ints) {
        int maxValue = MathCalculations.max(ints);
        return "Max: " + maxValue;
    }

    public static String evensStringBuilder(int[] ints) {
        ArrayList<Integer> evensArray = MathCalculations.evens(ints);
        String evensString = "Evens: ";
        for (int i = 0; i < evensArray.size(); i++) {
            evensString += evensArray.get(i) + " ";
        }
        return evensString;
    }

    public static String oddsStringBuilder(int[] ints) {
        ArrayList<Integer> oddsArray = MathCalculations.odds(ints);
        String oddsString = "Odds: ";
        for (int i = 0; i < oddsArray.size(); i++) {
            oddsString += oddsArray.get(i) + " ";
        }
        return oddsString;
    }

    public static String sumStringBuilder(int[] ints) {
        int sum = MathCalculations.sum(ints);
        return "Sum: " + sum;
    }

    public static String stdStringBuilder(int[] ints) {
        DecimalFormat fourDigits = new DecimalFormat("#.####");
        return "Standard Deviation: " +  fourDigits.format(MathCalculations.standardDeviation(ints));

    }

    public static String fnsStringBuilder(int[] ints) {
        String fns = "Five Number Summary: ";
        fns += "Min: " + MathCalculations.min(ints) + " ";
        fns += "Q1: " + MathCalculations.q1(ints) + " ";
        fns += "Median: " + MathCalculations.median(ints) + " ";
        fns += "Q3: " + MathCalculations.q3(ints) + " ";
        fns += "Max: " + MathCalculations.max(ints) + " ";

        return fns;
    }


}
