
package com.furalliance.model;

public class RescueModel {
 private String name;
    private String contactNumber;
    private String typeOfAnimal;
    private String location;
    private String descriptionOfInjury;
    private String urgencyLevel;
    private String additionalNotes;

    // Constructor
    public RescueModel() {}
    
    
    public RescueModel(String name, String contactNumber, String typeOfAnimal, String location,
            String descriptionOfInjury, String urgencyLevel, String additionalNotes) {
this.name = name;
this.contactNumber = contactNumber;
this.typeOfAnimal = typeOfAnimal;
this.location = location;
this.descriptionOfInjury = descriptionOfInjury;
this.urgencyLevel = urgencyLevel;
this.additionalNotes = additionalNotes;
}

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getTypeOfAnimal() {
        return typeOfAnimal;
    }

    public void setTypeOfAnimal(String typeOfAnimal) {
        this.typeOfAnimal = typeOfAnimal;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescriptionOfInjury() {
        return descriptionOfInjury;
    }

    public void setDescriptionOfInjury(String descriptionOfInjury) {
        this.descriptionOfInjury = descriptionOfInjury;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }
    
}