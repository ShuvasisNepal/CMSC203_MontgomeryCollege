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

public class Patient {

	//attributes
    private String firstName;
    private String middleName;
    private String lastName;

    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;

    private String phoneNumber;

    private String emergencyContactName;
    private String emergencyContactPhone;

    //no arg constructor
    public Patient() {
        firstName = "";
        middleName = "";
        lastName = "";
        streetAddress = "";
        city = "";
        state = "";
        zipCode = "";
        phoneNumber = "";
        emergencyContactName = "";
        emergencyContactPhone = "";
    }

    //arg constructor for name
    public Patient(String firstName, String middleName, String lastName) {
        this();
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    //arg constructor for all attributes
    public Patient(String firstName, String middleName, String lastName,
                   String streetAddress, String city, String state, String zipCode,
                   String emergencyContactName, String emergencyContactPhone) {

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
        this.phoneNumber = "";
    }

    //getters
    public String getFirstName(){ 
    	return firstName; 
	}
    public String getMiddleName(){ 
    	return middleName; 
	}
    public String getLastName(){ 
    	return lastName; 
	}
    public String getStreetAddress(){ 
    	return streetAddress; 
	}
    public String getCity(){ 
    	return city; 
	}
    public String getState(){ 
    	return state; 
	}
    public String getZipCode(){ 
    	return zipCode; 
	}
    public String getPhoneNumber(){ 
    	return phoneNumber; 
	}
    public String getEmergencyContactName(){ 
    	return emergencyContactName; 
	}
    public String getEmergencyContactPhone(){ 
    	return emergencyContactPhone; 
	}

    
    //setters
    public void setFirstName(String firstName){ 
    	this.firstName = firstName; 
	}
    public void setMiddleName(String middleName){ 
		this.middleName = middleName; 
	}
    public void setLastName(String lastName){ 
		this.lastName = lastName; 
	}
    public void setStreetAddress(String streetAddress){ 
		this.streetAddress = streetAddress; 
	}
    public void setCity(String city){ 
		this.city = city; 
	}
    public void setState(String state){ 
		this.state = state; 
	}
    public void setZipCode(String zipCode){ 
		this.zipCode = zipCode; 
	}
    public void setPhoneNumber(String phoneNumber){ 
		this.phoneNumber = phoneNumber; 
	}
    public void setEmergencyContactName(String emergencyContactName){ 
		this.emergencyContactName = emergencyContactName; 
	}
    public void setEmergencyContactPhone(String emergencyContactPhone){ 
		this.emergencyContactPhone = emergencyContactPhone; 
	}

    //build full name method
    public String buildFullName() {
        if (middleName == null || middleName.isBlank()){
            return firstName + " " + lastName;
        }
        return firstName + " " + middleName + " " + lastName;
    }

    //build address method
    public String buildAddress(){
        return streetAddress + " " + city + " " + state + " " + zipCode;
    }

    //build emergency contact method
    public String buildEmergencyContact() {
        return emergencyContactName + " " + emergencyContactPhone;
    }

    //display all information method
    @Override
    public String toString() {
        return "Name: " + buildFullName() + "\n"
                + "Address: " + buildAddress() + "\n"
                + "Phone: " + phoneNumber + "\n"
                + "Emergency Contact: " + buildEmergencyContact();
    }
}