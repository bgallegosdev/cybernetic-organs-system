package com.cybernetic;

import java.time.LocalDateTime;

//Node class for the TransplantHistory.java
public class TransplantRecord {
    /*
     * Fields of TransplantRecord class
     */
    private String operationId;
    private String patientId;
    private String organId;
    private LocalDateTime timestamp;
    private String surgeon;
    private String outcome;
    private TransplantRecord next; // for LinkedList implementation

    /*
     * Constructor for TransplantRecord Class with arguments
     */
    public TransplantRecord(String operation, String pId, String oId, String surg, String out){

        this.operationId = operation;
        this.patientId = pId;
        this.organId = oId;
        timestamp = LocalDateTime.now();
        this.surgeon = surg;
        this.outcome = out;
        this.next = null;
    }

    /*
     * Constructor for TransplantRecord Class with no-arg
     */
    public TransplantRecord(){
        this.operationId = "";
        this.patientId = "";
        this.organId = "";
        timestamp = LocalDateTime.now();
        this.surgeon = "";
        this.outcome = "";
        this.next = null;
    }

    /*
     * Getters for TransplantRecord Class
     */
    public String getOperationId() {
        return this.operationId;
    }
    public String getPatientId() {
        return this.patientId;
    }
    public String getOrganId() {
        return this.organId;
    }
    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }
    public String getSurgeon() {
        return this.surgeon;
    }
    public String getOutcome() {
        return this.outcome;
    }
    public TransplantRecord getNext() {
        return this.next;
    }

    /*
     * Setters for TransplantRecord Class
     */
    public void setOperationId(String operation) {
        this.operationId = operation;
    }
    public void setPatientId(String pId) {
        this.patientId = pId;
    }
    public void setOrganId(String oId) {
        this.organId = oId;
    }
    public void setTimestamp(LocalDateTime time) {
        this.timestamp = time;
    }
    public void setSurgeon(String surg) {
        this.surgeon = surg;
    }
    public void setOutcome(String out) {
        this.outcome = out;
    }
    public void setNext(TransplantRecord next) {
        this.next = next;
    }

    /**
     * Method toString returns the string representation of the TransplantHistory
     * @return string representation of the TransplantHistory
     */
    @Override
    public String toString() {
        return getOperationId() + ": " + getPatientId() + "(" + getOutcome() + ")";
    }
}
