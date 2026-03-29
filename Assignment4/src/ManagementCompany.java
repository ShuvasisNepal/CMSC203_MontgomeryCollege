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

public class ManagementCompany {
    private String name;
    private String taxId;
    private Property[] properties;
    private int propertyCount;
    public static final int MAX_PROPERTIES = 5;

    //parameterized constructor
    public ManagementCompany(String name, String taxId) {
        this.name = name;
        this.taxId = taxId;
        properties = new Property[MAX_PROPERTIES];
        propertyCount = 0;
    }

    //copy constructor
    public ManagementCompany(ManagementCompany otherCompany) {
        this.name = otherCompany.name;
        this.taxId = otherCompany.taxId;
        this.properties = new Property[MAX_PROPERTIES];
        this.propertyCount = otherCompany.propertyCount;

        for (int i = 0; i < otherCompany.propertyCount; i++) {
            this.properties[i] = new Property(otherCompany.properties[i]);
        }
    }

    //add property to array method
    public int addProperty(Property p) {
        if (p == null || propertyCount >= MAX_PROPERTIES) {
            return -1;
        }

        properties[propertyCount] = new Property(p);
        propertyCount++;
        return propertyCount - 1;
    }

    //calculate total rent method
    public double totalRent() {
        double total = 0.0;

        for (int i = 0; i < propertyCount; i++) {
            total += properties[i].getRentAmount();
        }

        return total;
    }

    //get current count of properties method
    public int getPropertyCount() {
        return propertyCount;
    }

    //get company name method
    public String getName() {
        return name;
    }

    //get taxId method
    public String getTaxId() {
        return taxId;
    }

    //get property method
    public Property getProperty(int index) {
        if (index < 0 || index >= propertyCount) {
            return null;
        }
        return properties[index];
    }

    //toString method
    @Override
    public String toString() {
        String result = "Management Company: " + name + "\n";
        result += "Tax ID: " + taxId + "\n";
        result += "Properties:\n";

        for (int i = 0; i < propertyCount; i++) {
            result += properties[i].toString() + "\n";
        }

        result += "Total Rent: " + totalRent();
        return result;
    }
}