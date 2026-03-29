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

public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;

    //default constructor
    public Property() {
        propertyName = "";
        city = "";
        rentAmount = 0.0;
        owner = "";
    }

    //parameterized constructor
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
    }

    //copy constructor
    public Property(Property otherProperty) {
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rentAmount = otherProperty.rentAmount;
        this.owner = otherProperty.owner;
    }


    //getters and setters
    
    public String getPropertyName() {
        return propertyName;
    }


    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }

    double getRentAmount() {
        return rentAmount;
    }


    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }


    public String getOwner() {
        return owner;
    }


    public void setOwner(String owner) {
        this.owner = owner;
    }

    //toString Method
    @Override
    public String toString() {
        return "Property Name: " + propertyName
                + ", City: " + city
                + ", Rent: " + rentAmount
                + ", Owner: " + owner;
    }
}