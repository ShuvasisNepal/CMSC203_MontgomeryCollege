//Class: CMSC203 CRN 32608  
//Program: Assignment 5 
//Instructor: Professor Farnaz Eivazi  
//Summary of Description: This project processes sales data for multiple departments over multiple days 
//Due Date: 04/19/2026 11:59 P.M.  
//Integrity Pledge: I pledge that I have completed the programming assignment independently.  
//I have not copied the code from a student or any source.  
//Print your name here: Shuvasis Nepal  

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesFileIO {

    //reads file and creates ragged 2D array
    public static double[][] readSalesData(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner input = new Scanner(file);

        ArrayList<double[]> rows = new ArrayList<double[]>();

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();

            if (line.isEmpty()) continue;

            String[] tokens = line.split("\\s+");
            double[] row = new double[tokens.length];

            for (int i = 0; i < tokens.length; i++) {
                row[i] = Double.parseDouble(tokens[i]);
            }

            rows.add(row);
        }

        input.close();

        double[][] data = new double[rows.size()][];

        for (int i = 0; i < rows.size(); i++) {
            data[i] = rows.get(i);
        }

        return data;
    }

    //writes summary results to output file
    public static void writeSummary(String filename, double[][] data) throws IOException {
        PrintWriter output = new PrintWriter(filename);

        output.printf("Total sales: %.2f%n", SalesDataUtility.getTotal(data));
        output.printf("Average sale: %.2f%n", SalesDataUtility.getAverage(data));
        output.printf("Highest sale: %.2f%n", SalesDataUtility.getHighestInArray(data));
        output.printf("Lowest sale: %.2f%n", SalesDataUtility.getLowestInArray(data));
        output.println();

        for (int i = 0; i < data.length; i++) {
            output.printf("Row %d total: %.2f%n", i, SalesDataUtility.getRowTotal(data, i));
        }

        output.println();

        int maxCols = SalesDataUtility.getLargestRowLength(data);

        for (int i = 0; i < maxCols; i++) {
            output.printf("Column %d total: %.2f%n", i, SalesDataUtility.getColumnTotal(data, i));
        }

        output.close();
    }
}