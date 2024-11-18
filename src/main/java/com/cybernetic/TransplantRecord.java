package com.cybernetic;

import java.time.LocalDateTime;

//Node class for the TransplantHistory.java
public class TransplantRecord {
    /*
     * Fields of TransplantRecord class
     */
    String operationId;
    String patientId;
    String organId;
    LocalDateTime timestamp;
    String surgeon;
    String outcome;
    TransplantRecord next; // for LinkedList implementation

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
}
