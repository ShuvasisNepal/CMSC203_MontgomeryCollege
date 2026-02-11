/*
 * Class: CMSC203
 * Instructor:Professor Farnaz Eivazi
 * Description: This program calculates a student's final grade by reading
 * grading configuration and student scores from files. It displays the result
 * on the screen and writes it to an output file.
 * Due: 02/10/2026 11:59 P.M>
 * I pledge that I have completed the programming assignment independently.
 * Print your Name here: Shuvasis Nepal
 */

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class GradeCalculator{
	public static void main(String[]args) {
		
		Scanner input = new Scanner(System.in);
		
		//declaring variables
		String courseName = "";
		String category1 = "";
		String category2 = "";
		String category3 = "";
		
		int category1Total = 0;
		int category2Total = 0;
		int category3Total = 0;
		
		boolean defaultConfigUsed = false;
		
		//reading file
		try {
			Scanner readFile = new Scanner(new File("gradeconfig.txt"));
			
			courseName = readFile.nextLine();
			int numberofCategories = readFile.nextInt();
			readFile.nextLine();
			
			if(numberofCategories != 3) {
				System.out.println("Invalid number of categories in configuration file.");
                readFile.close();
                return;
			}
			
			category1 = readFile.next();
			category1Total = readFile.nextInt();
			
			category2 = readFile.next();
			category2Total = readFile.nextInt();
			
			category3 = readFile.next();
			category3Total = readFile.nextInt();
			
			if(category1Total + category2Total + category3Total != 100) {
				System.out.println("Categories does not add up to 100.");
				readFile.close();
				return;
			}
			
			readFile.close();
			System.out.println("Configuration Loaded Sucessfully!!!");
			
			
		}catch(Exception e) {
			System.out.println("Error reading file!!!...using default configuration!!!");
			courseName = "Default Course";
            category1 = "Projects";
            category2 = "Quizzes";
            category3 = "Exams";

            category1Total = 40;
            category2Total = 30;
            category3Total = 30;

            defaultConfigUsed = true;
		}
		
		Scanner read2File;
		
		try {
			read2File = new Scanner(new File("grades_input.txt"));
		}catch(Exception e) {
			System.out.println("Error reading File!!!");
			return;
		}
		
		String fname = read2File.nextLine();
		String lname = read2File.nextLine();
		
		double category1Avg = 0.0;
		double category2Avg = 0.0;
		double category3Avg = 0.0;
		
		//reading category scores
		for(int i = 0; i < 3; i++) {
			String categoryName = read2File.nextLine();
			int categoryScore = read2File.nextInt();
			
			double total = 0.0;
			
			for(int j = 0; j < categoryScore; j++) {
				total += read2File.nextDouble();
			}
			
			read2File.nextLine();
			
			double average = total/categoryScore;
			
			if(categoryName.equals(category1)) {
				category1Avg = average;
			}
			else if(categoryName.equals(category2)) {
				category2Avg = average;
			}
			else if(categoryName.equals(category3)) {
				category3Avg = average;
			}
			else {
				System.out.println("Category Not Found!!!" + categoryName);
			}
		}
		
		read2File.close();
		
		//calculating overall average
		double totalAverage = 0.0;
		
		totalAverage += (category1Avg* category1Total / 100);
		totalAverage += (category2Avg* category2Total / 100);
		totalAverage += (category3Avg* category3Total / 100);
		
		//grading total score
		String grade = "";
		if (totalAverage >= 90) {
			grade = "A";
		}
		else if(totalAverage >= 80) {
			grade = "B";
		}
		else if(totalAverage >= 70) {
			grade = "C";
		}
		else if(totalAverage >= 60) {
			grade = "D";
		}
		else {
			grade = "F";
		}
		
		//grading options
		String answer;
		
		do {
			System.out.println("Apply +/- grading? (Y/N): ");
			answer = input.nextLine();
		}while(!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N"));
		
		if(answer.equalsIgnoreCase("Y")) {
			double decimalPart = totalAverage % 10;
			if(decimalPart >= 8) {
				grade = grade + "+";
			}
			else if(decimalPart <= 2) {
				grade = grade + "-";
			}
		}
		
		//displaying results
		
		try {
			PrintWriter output = new PrintWriter("grades_report.txt");
			
			System.out.println();
			System.out.println("Student: " + fname + " " + lname);
			System.out.println("Course: " + courseName);

			System.out.println(category1 + " (" + category1Total + "%): average = " + category1Avg);
			System.out.println(category2 + " (" + category2Total + "%): average = " + category2Avg);
			System.out.println(category3 + " (" + category3Total + "%): average = " + category3Avg);

			System.out.println("Overall numeric average: " + totalAverage);
			System.out.println("Final letter grade: " + grade);
			System.out.println("Default configuration used: " + defaultConfigUsed);

			//writing results in the file
			output.println("Student: " + fname + " " + lname);
			output.println("Course: " + courseName);

			output.println(category1 + " (" + category1Total + "%): average = " + category1Avg);
			output.println(category2 + " (" + category2Total + "%): average = " + category2Avg);
			output.println(category3 + " (" + category3Total + "%): average = " + category3Avg);

			output.println("Overall numeric average: " + totalAverage);
			output.println("Final letter grade: " + grade);
			output.println("Default configuration used: " + defaultConfigUsed);

			output.close();

			System.out.println("Summary written to grades_report.txt");

			
		}catch(Exception e) {
			System.out.println("Error writing to file!!!");
		}
		
		System.out.println("Program Complete. Goodbye!");
	}
}
