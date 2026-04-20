//Class: CMSC203 CRN 32608  
//Program: Assignment 5 
//Instructor: Professor Farnaz Eivazi  
//Summary of Description: This project processes sales data for multiple departments over multiple days 
//Due Date: 04/19/2026 11:59 P.M.  
//Integrity Pledge: I pledge that I have completed the programming assignment independently.  
//I have not copied the code from a student or any source.  
//Print your name here: Shuvasis Nepal  

public class SalesDataUtility {

    public static double getTotal(double[][] data) {
        double total = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                total += data[i][j];
            }
        }
        return total;
    }

    public static double getAverage(double[][] data) {
        double total = 0;
        int count = 0;

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                total += data[i][j];
                count++;
            }
        }

        if (count == 0) {
            return 0;
        }

        return total / count;
    }

    public static double getRowTotal(double[][] data, int row) {
        double total = 0;

        if (row < 0 || row >= data.length) {
            return 0;
        }

        for (int j = 0; j < data[row].length; j++) {
            total += data[row][j];
        }

        return total;
    }

    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;

        for (int i = 0; i < data.length; i++) {
            if (col >= 0 && col < data[i].length) {
                total += data[i][col];
            }
        }

        return total;
    }

    public static double getHighestInRow(double[][] data, int row) {
        if (row < 0 || row >= data.length || data[row].length == 0) {
            return 0;
        }

        double highest = data[row][0];

        for (int j = 1; j < data[row].length; j++) {
            if (data[row][j] > highest) {
                highest = data[row][j];
            }
        }

        return highest;
    }

    public static double getLowestInRow(double[][] data, int row) {
        if (row < 0 || row >= data.length || data[row].length == 0) {
            return 0;
        }

        double lowest = data[row][0];

        for (int j = 1; j < data[row].length; j++) {
            if (data[row][j] < lowest) {
                lowest = data[row][j];
            }
        }

        return lowest;
    }

    public static double getHighestInArray(double[][] data) {
        double highest = data[0][0];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] > highest) {
                    highest = data[i][j];
                }
            }
        }

        return highest;
    }

    public static double getLowestInArray(double[][] data) {
        double lowest = data[0][0];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] < lowest) {
                    lowest = data[i][j];
                }
            }
        }

        return lowest;
    }

    public static int getLargestRowLength(double[][] data) {
        int max = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i].length > max) {
                max = data[i].length;
            }
        }

        return max;
    }
}