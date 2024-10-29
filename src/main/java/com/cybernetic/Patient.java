//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

public class Patient {
    private String id;
    private String name;
    private String bloodType;
    private int weight;
    private String hlaType;

    public Patient(String id, String name,String bloodType, int weight, String hlaType) {
        this.id = id;
        this.name = name;
        this.bloodType = bloodType;
        this.weight = weight;
        this.hlaType = hlaType;
    }

    private PatientHistory history;

    public String getId() { return id; }
    public String getBloodType() { return bloodType; }
    public int getWeight() { return weight; }
    public String getHlaType() { return hlaType; }
    public String getName() { return name; }

    public void setHistory(PatientHistory history) {
        this.history = history;
    }

    public PatientHistory getHistory(){
        return this.history;
    }

    public void addMedicalEvent(String medicalEvent) {
        this.history.addMedicalEvent(medicalEvent);
    }

    public String removeMostRecentEvent() {
        return this.history.removeMostRecentEvent();
    }
}
