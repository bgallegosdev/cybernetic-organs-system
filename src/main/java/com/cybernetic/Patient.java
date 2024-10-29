//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

public class Patient {
    private String id;
    private String name;
    private String bloodType;
    private int weight;
    private String hlaType;

    // Constructor
    public Patient(String id, String name,String bloodType, int weight, String hlaType) {
        this.id = id;
        this.name = name;
        this.bloodType = bloodType;
        this.weight = weight;
        this.hlaType = hlaType;
    }

    // Create a new PatientHistory object for each patient
    private PatientHistory history = new PatientHistory();

    // Getters
    public String getId() { return id; }
    public String getBloodType() { return bloodType; }
    public int getWeight() { return weight; }
    public String getHlaType() { return hlaType; }
    public String getName() { return name; }

    public PatientHistory getHistory(){
        return history;
    }

    // Setters
    public void setHistory(PatientHistory history) {
        this.history = history;
    }

    /**
     * Add a new medical event to the patient's history.
     * @param medicalEvent the medical event to be added.
     */
    public void addMedicalEvent(String medicalEvent) {
        this.history.addMedicalEvent(medicalEvent);
    }

    /**
     * View the most recent medical event without removing it from the stack.
     * @return The most recent medical event.
     */
    public String removeMostRecentEvent() {
        return this.history.removeMostRecentEvent();
    }
}
