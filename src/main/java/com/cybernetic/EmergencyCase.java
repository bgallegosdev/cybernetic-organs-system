package com.cybernetic;

import java.time.LocalDateTime;

//Node class for the EmergencyWaitlist.java
public class EmergencyCase {
    /*
     * Fields of EmergencyCase class
     */
    private String caseId;
    private Patient patient;
    private int severityLevel; //Valid levels: 1 - 5
    private LocalDateTime registrationTime;
    private EmergencyCase left, right; //pointers to left and right of BST

    /*
     * Constructor for EmergencyCase class with arguments
     */
    public EmergencyCase(String id, Patient pat, int level, LocalDateTime time){
        this.caseId = id;
        this.patient = pat;
        this.severityLevel = level;
        this.registrationTime = time;
    }

    /*
     * Constructor for EmergencyCase class with no-arg
     */
    public EmergencyCase(){
        this.caseId = "";
        this.patient = null;
        this.severityLevel = 0;
        this.registrationTime = LocalDateTime.now();
    }

    /*
     * Setters for EmergencyCase Class
     */
    public void setCaseId(String id) {
        this.caseId = id;
    }
    public void setPatient(Patient pat) {
        this.patient = pat;
    }
    public void setSeverityLevel(int level) {
        //checks if level is in the given range
        if(level > 0 && level < 6) {
            this.severityLevel = level;
        }
        else
            throw new IllegalArgumentException("Severity Level is not a valid choice");
    }
    public void setRegistrationTime(LocalDateTime time) {
        this.registrationTime = time;
    }
    public void setLeft(EmergencyCase left) {
        this.left = left;
    }
    public void setRight(EmergencyCase right) {
        this.right = right;
    }

    /*
     * Getters for EmergencyCase Class
     */
    public String getCaseId() {
        return this.caseId;
    }
    public Patient getPatient() {
        return this.patient;
    }
    public int getSeverityLevel() {
        return this.severityLevel;
    }
    public LocalDateTime getRegistrationTime() {
        return this.registrationTime;
    }
    public EmergencyCase getLeft() {
        return this.left;
    }
    public EmergencyCase getRight() {
        return this.right;
    }

    /*
     * Overriding toString
     */
    @Override
    public String toString() {
        //calculate wait time in minutes, between registration time and current time
        long waitTimeMinutes = java.time.Duration.between(registrationTime, LocalDateTime.now()).toMinutes();
        return caseId + " (" + "Severity " + severityLevel + ", " + "Wait time: " + waitTimeMinutes + " min)";
    }

}
