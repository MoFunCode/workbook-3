package com.pluralsight;
/*
1. Prompt the user for the name of the story/file to read.
2. Use a new Scanner to load and read each line of the selected story in the file.
3. Print the file to the screen, but add a line number to the beginning of each line
*/

import java.io.FileInputStream;  // Lets us read data from a file
import java.util.Scanner;        // Lets us get input from the user and also read from files
import java.io.FileNotFoundException; // Specific exception for when a file isn't found

public class BedtimeStories {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Boring Stories Available:");
        System.out.println("1. Goldilocks");
        System.out.println("2. Hansel and Gretel");
        System.out.println("3. Mary Had a Little Lamb");


        System.out.print("Choose one bro (1-3) from these : ");
        String choice = sc.nextLine();

        // Based on the user's choice, call the method to read a specific story file
        switch (choice) {
            case "1":
                readStory("goldilocks.txt"); // Calls the story reader with the Goldilocks file
                break;
            case "2":
                readStory("hansel_and_gretel.txt");
                break;
            case "3":
                readStory("mary_had_a_little_lamb.txt");
                break;
            default:

                // This block runs if the user enters something other than 1, 2, or 3
                System.out.println("Invalid choice, try again bro.");
        }

        // It's a good habit to close the scanner after you're done with it
        sc.close();
    }

    // Reads a story from a given file name and prints it line by line
    public static void readStory(String fileName) {
        // Full path to where your story files are saved
        String filePath = "/Users/erimo/pluralsight/workbook-3/BedtimeStories/src/main/resources/" + fileName;

        try (
                FileInputStream input = new FileInputStream(filePath); // Opens the file
                Scanner readFile = new Scanner(input)                 // Reads from the file
        ) {
            // Reads the file one line at a time
            while (readFile.hasNextLine()) {
                System.out.println(readFile.nextLine()); // Print each line to the screen
            }

        } catch (FileNotFoundException e) {
            // Only happens if the file is missing or the path is wrong
            System.out.println("Story file not found: " + e.getMessage());

        } catch (Exception e) {
            // Catches all other unexpected errors while trying to read the file
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
