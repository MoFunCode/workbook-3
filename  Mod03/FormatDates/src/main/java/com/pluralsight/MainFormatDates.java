package com.pluralsight;

/*
 * Java Application: FormatDates
 *
 * TASK: Create a Java program that:
 * - Gets the current date and time
 * - Displays the date/time in multiple formats
 *
 * FORMATS to Display:
 *
 * 1. MM/dd/yyyy → Example: 09/05/2021
 *    - Common U.S. format: Month/Day/Year
 *
 * 2. yyyy-MM-dd → Example: 2021-09-05
 *    - ISO format (standard international format)
 *
 * 3. Full Month Name → Example: September 5, 2021
 *    - Displays the full month name with day and year
 *
 * 4. Day with Time in GMT → Example: Sunday, Sep 5, 2021 10:02
 *    - Shows day of week, short month name, day, year and time
 *    - Time must be shown in GMT time zone (not local)
 *
 * CHALLENGE:
 * 5. Custom Format → Example: 5:02 on 05-Sep-2021
 *    - Shows hour and minute, followed by custom text and date
 *    - Display this in your **local** time zone
 *
 * TIPS:
 * - Use `java.time.LocalDate`, `java.time.LocalDateTime`, `java.time.ZonedDateTime`
 * - Use `DateTimeFormatter` to format the date/time
 * - Use `ZoneId.of("GMT")` to work with GMT time zone
 * - For local time, you can just use `LocalDateTime.now()`
 */


import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class MainFormatDates {

    public static void main(String[] args) {

        // Step 1: U.S. format: Month/Day/Year (MM/dd/yyyy)
        // This gets the current date without time (e.g., 04/23/2025)
        LocalDate currentDate = LocalDate.now();
        // Define a formatter to match the U.S. date format
        DateTimeFormatter formatterOne = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        // Format and print the date in U.S. format
        String formattedDate = currentDate.format(formatterOne);
        System.out.println("Formatted Date (MM/dd/yyyy): " + formattedDate);

        // Step 2: Format the date as yyyy-MM-dd (ISO format)
        DateTimeFormatter isoFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String isoFormattedDate = currentDate.format(isoFormatter);
        System.out.println("Formatted Date (yyyy-MM-dd): " + isoFormattedDate);

        // Step 3: Full Month Name Format: 'September 5, 2021'
        // Example: April 23, 2025
        DateTimeFormatter fullMonthFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        String fullMonthFormatted = currentDate.format(fullMonthFormatter);
        System.out.println("Formatted Date (MMMM d, yyyy): " + fullMonthFormatted);

        // Step 4: Format date and time in GMT (Greenwich Mean Time)
        // Example: Sunday, Apr 23, 2025 10:02
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));
        DateTimeFormatter gmtFormatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm");
        String gmtFormatted = gmtTime.format(gmtFormatter);
        System.out.println("GMT Time: " + gmtFormatted);

        // Step 5: Local time format: '5:02 on 05-Sep-2021'
        // This uses your local time zone (not GMT)
        ZonedDateTime localTime = ZonedDateTime.now(); // Current local time
        DateTimeFormatter localFormatter = DateTimeFormatter.ofPattern("h:mm 'on' dd-MMM-yyyy");

        // Format and print the local date and time
        String localFormatted = localTime.format(localFormatter);
        System.out.println("Local Time: " + localFormatted);
    }
}

