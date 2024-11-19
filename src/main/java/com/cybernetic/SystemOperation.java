package com.cybernetic;

import java.time.LocalDateTime;

//Node class for the SystemOperationsLog.java
public class SystemOperation {
    /*
     * Fields of SystemOperation class
     */
    private String operationId;
    private String operationType; //Valid Types: "MATCH", "TRANSPLANT", "EMERGENCY"
    private LocalDateTime timestamp;
    private String description;
    private boolean isReversible;

    /*
     * Constructor for SystemOperation class with arguments
     */
    public SystemOperation(String oId, String oType, String des, boolean reversible){
        this.operationId = oId;
        this.operationType = oType;
        timestamp = LocalDateTime.now();
        this.description = des;
        this.isReversible = reversible;
    }

    /*
     * Constructor for SystemOperation class with no-arg
     */
    public SystemOperation(){
        this.operationId = "";
        this.operationType = "";
        timestamp = LocalDateTime.now();
        this.description = "";
        this.isReversible = false;
    }

    /*
     * Setters for SystemOperation Class
     */
    public void setOperationId(String oId) {
        this.operationId = oId;
    }
    public void setOperationType(String oType) {
        //checks if type is a valid option: MATCH, TRANSPLANT, EMERGENCY
        if(oType.equals("MATCH") || oType.equals("TRANSPLANT") || oType.equals("EMERGENCY")) {
            this.operationType = oType;
        }
        else
            throw new IllegalArgumentException("Operation Type is not a valid choice");
    }
    public void setDescription(String des) {
        this.description = des;
    }
    public void setReversible(boolean reversible) {
        this.isReversible = reversible;
    }

    /*
     * Getters for SystemOperation Class
     */
    public String getOperationId() {
        return this.operationId;
    }
    public String getOperationType() {
        return this.operationType;
    }
    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }
    public String getDescription() {
        return this.description;
    }
    public boolean getReversible() {
        return this.isReversible;
    }

    /**
     * Method toString to print the list
     * @return the list as a string
     */
    @Override
    public String toString(){
        return getOperationId() + ": " + getOperationType();
    }

}
