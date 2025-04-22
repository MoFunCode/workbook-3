package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FamousQuotes {

/*
EXERCISE 1: FamousQuotes Java Application

Instructions:
1. Create a new Java application named FamousQuotes.
2. Create an array of Strings that holds 10 of your favorite quotes.
3. Prompt the user to enter a number between 1 and 10, and display the corresponding quote.

Initial Testing:
- First, test the application with a valid number (1–10). Make sure it displays the correct quote.
- Then, test it with an invalid number (outside the range). Observe what happens.

Exception Handling:
- Now, add exception handling to prevent the program from crashing when invalid input is entered.
  (Note: Use try-catch to handle out-of-range numbers and input mismatches.)

BONUS Features:
- Add a loop so that after displaying a quote, the program asks the user if they want to see another.
- If the user chooses yes, repeat the process.
- If an exception occurs, do not shut the application down—just catch the error and continue.

Additional Bonus:
- Add an option for the user to see a random quote instead of choosing by number.

*/

    public static void main(String[] args) {

        Scanner mo = new Scanner(System.in);
        System.out.println("Here’s a surprise quote you don't actaully understand:");


        //Translate this at your own risk
        String[] myFavoriteArabicQuotes = {
                "الـقـرد فـي عـيـن أمّـه غـزال",
                "أدعـي عـلـى ولـدي وأكـره مـن يـقـول آمـيـن",
                "آخـرة الـمـعـروف الـضـرب بـالـكـفـوف",
                "الـلـي ايـده فـي الـمـيـة مـش زي الـلـي ايـده فـي الـنـار",
                "لـمـا انـفـرقـت الـعـقـول كـل واحـد عـجـبـه عـقـلـه، ولـمـا انـفـرقـت الأرزاق مـاحـدش عـجـبـه رزقـه"
        };
        

        System.out.print("Pick a number between 1 and 5: ");

        try {
            // This line could throw an InputMismatchException if user enters text
            int userChoice = mo.nextInt();

            if (userChoice >= 1 && userChoice <= 5) {
                // userChoice - 1 converts user input (1-5) to array index (0-4)
                System.out.println("Your quote might be: " + myFavoriteArabicQuotes[userChoice -1]);
            } else {

                System.out.println("Sorry bro, that's an invalid number. Please pick between 1 and 5.");
            }

            System.out.print("Wanna see another quot you still don't understand? (yes/no): ");
            mo.nextLine(); // consume leftover newline
            String answer = mo.nextLine().trim().toLowerCase();

            if (!answer.equals("yes")) {
                boolean keepGoing = true;
                System.out.println("Alright, ma'a salama!");
            }
// First catch block: Catches a specific exception type
        } catch (InputMismatchException e) {

            System.out.println("You entered text instead of a number. Please run the program again and enter a number.");

// Second catch block: Catches any other exceptions not caught above
        } catch (Exception e) {

            // This is a "catch-all" for any unexpected exceptions
            System.out.println("An unexpected error occurred: " + e.getMessage());

// Always runs, whether there was an exception or not
        } finally {

            mo.close();
        }
    }
}