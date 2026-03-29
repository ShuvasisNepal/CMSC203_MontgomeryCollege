/*
 * Class: CMSC203 CRN 32608 
 * Program: Assignment 4
 * Instructor: Professor Farnaz Eivazi 
 * Summary of Description: This project is about creating a Java program to manage rental properties and calculate total rent.
 * Due Date: 03/29/2026 11:59 P.M. 
 * Integrity Pledge: I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source.
 * Print your name here: Shuvasis Nepal 
 */

public class PropertyDriver {
    public static void main(String[] args) {
        ManagementCompany company = new ManagementCompany("Campus Realty", "123-45-6789");

        Property p1 = new Property("Apt 1", "Rockville", 1200.0, "Bob");
        Property p2 = new Property("Apt 2", "Gaithersburg", 1500.0, "Carol");
        Property p3 = new Property("Apt 3", "Silver Spring", 1800.0, "David");

        company.addProperty(p1);
        company.addProperty(p2);
        company.addProperty(p3);

        System.out.println("Original Company Information:");
        System.out.println(company);

        System.out.println();

        ManagementCompany copiedCompany = new ManagementCompany(company);
        System.out.println("Copied Company Information:");
        System.out.println(copiedCompany);

    }
}