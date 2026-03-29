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

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PropertyAppFX extends Application {
    private ManagementCompany company = new ManagementCompany("Campus Realty", "123-45-6789");

    @Override
    public void start(Stage primaryStage) {
        Label nameLabel = new Label("Property Name:");
        TextField nameField = new TextField();

        Label cityLabel = new Label("City:");
        TextField cityField = new TextField();

        Label rentLabel = new Label("Rent Amount:");
        TextField rentField = new TextField();

        Label ownerLabel = new Label("Owner:");
        TextField ownerField = new TextField();

        Button addButton = new Button("Add Property");
        Button totalButton = new Button("Calculate Total Rent");
        Button showButton = new Button("Show All Properties");

        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(250);

        addButton.setOnAction(e -> {
            try {
                String propertyName = nameField.getText();
                String city = cityField.getText();
                double rent = Double.parseDouble(rentField.getText());
                String owner = ownerField.getText();

                Property property = new Property(propertyName, city, rent, owner);
                int result = company.addProperty(property);

                if (result == -1) {
                    outputArea.setText("Cannot add property. Array is full.");
                } else {
                    outputArea.setText("Property added successfully at index " + result);
                }

                nameField.clear();
                cityField.clear();
                rentField.clear();
                ownerField.clear();
            } catch (NumberFormatException ex) {
                outputArea.setText("Please enter a valid number for rent.");
            }
        });

        totalButton.setOnAction(e -> {
            outputArea.setText("Total Rent: " + company.totalRent());
        });

        showButton.setOnAction(e -> {
            outputArea.setText(company.toString());
        });

        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        root.getChildren().addAll(
                nameLabel, nameField,
                cityLabel, cityField,
                rentLabel, rentField,
                ownerLabel, ownerField,
                addButton, totalButton, showButton,
                outputArea
        );

        Scene scene = new Scene(root, 450, 550);
        primaryStage.setTitle("Property Management Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}