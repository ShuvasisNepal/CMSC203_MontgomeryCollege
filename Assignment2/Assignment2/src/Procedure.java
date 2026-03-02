/*
 * Class: CMSC203 CRN 32608 
 * Program: Assignment 2 
 * Instructor: Professor Farnaz Eivazi 
 * Summary of Description: This program creates a Patient Class and a Procedure Class to work with PatientDriverAppGUI. 
 * Due Date: 03/01/2026 11:59 P.M. 
 * Integrity Pledge: I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source.
 * Print your name here: Shuvasis Nepal 
 */

public class Procedure {

    private String procedureName;
    private String procedureDate;
    private String practitionerName;
    private double charge;

    //no arg constructor
    public Procedure() {
        procedureName = "";
        procedureDate = "";
        practitionerName = "";
        charge = 0.0;
    }

    //arg constructor for name
    public Procedure(String procedureName, String procedureDate) {
        this();
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
    }

    //arg constructor for all attributes
    public Procedure(String procedureName, String procedureDate,
                     String practitionerName, double charge) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.practitionerName = practitionerName;
        this.charge = charge;
    }

    //getters
    public String getProcedureName(){ 
		return procedureName; 
	}
    public String getProcedureDate(){ 
		return procedureDate; 
	}
    public String getPractitionerName(){ 
		return practitionerName; 
	}
    public double getCharge(){ 
		return charge; 
	}

    
    //setters
    public void setProcedureName(String procedureName){ 
		this.procedureName = procedureName; 
	}
    public void setProcedureDate(String procedureDate){ 
		this.procedureDate = procedureDate; 
	}
    public void setPractitionerName(String practitionerName){ 
		this.practitionerName = practitionerName; 
	}
    public void setCharge(double charge){ 
		this.charge = charge; 
	}

    //display all 
    @Override
    public String toString() {
        return "Procedure Name: " + procedureName + "\n"
                + "Date: " + procedureDate + "\n"
                + "Practitioner: " + practitionerName + "\n"
                + String.format("Charge: $%,.2f", charge);
    }
}