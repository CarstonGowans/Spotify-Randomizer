package com.github.carstongowans.cs3230;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {                                            // Main Driver code
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Program. Please enter a number to access the program!\n1. String Operations \n2. Math Operations \n3. Exit");
        int choice = scan.nextInt();

        switch (choice) {
            case 1: Cli.stringsCli(args);                                               // String Operations
            break;
            case 2:Cli.cli(args);                                                       // Math Operations
            break;
            case 3: break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }


    }


}
