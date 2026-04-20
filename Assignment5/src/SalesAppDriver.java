//Class: CMSC203 CRN 32608  
//Program: Assignment 5 
//Instructor: Professor Farnaz Eivazi  
//Summary of Description: This project processes sales data for multiple departments over multiple days 
//Due Date: 04/19/2026 11:59 P.M.  
//Integrity Pledge: I pledge that I have completed the programming assignment independently.  
//I have not copied the code from a student or any source.  
//Print your name here: Shuvasis Nepal  

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class SalesAppDriver {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter input file name: ");
        String inputFile = keyboard.nextLine();

        System.out.print("Enter output file name: ");
        String outputFile = keyboard.nextLine();

        try {
            double[][] data = SalesFileIO.readSalesData(inputFile);

            System.out.printf("Total sales: %.2f%n", SalesDataUtility.getTotal(data));
            System.out.printf("Average sale: %.2f%n", SalesDataUtility.getAverage(data));
            System.out.printf("Highest sale: %.2f%n", SalesDataUtility.getHighestInArray(data));
            System.out.printf("Lowest sale: %.2f%n", SalesDataUtility.getLowestInArray(data));

            for (int i = 0; i < data.length; i++) {
                System.out.printf("Row %d total: %.2f%n", i, SalesDataUtility.getRowTotal(data, i));
            }

            SalesFileIO.writeSummary(outputFile, data);
            System.out.println("Summary written to " + outputFile);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Input file not found.");
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Invalid number in data file.");
        } catch (IOException e) {
            System.out.println("ERROR writing summary: " + e.getMessage());
        }

        keyboard.close();
    }
}