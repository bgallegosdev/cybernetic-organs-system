//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

import java.time.LocalDate;

public class CyberneticOrgan
{
    /*
     * Fields of CyberneticOrgan Class
     */
    private String id; //Required Format: (ORG-XXXX)
    private String type; //Required Values: (HEART, LUNG, KIDNEY, LIVER)
    private String model; //Required Format: ( [type]X-[version] )
    private int powerLevel; //Range: 1-100
    private double compatibilityScore; //Range: 0.0 - 1.0
    private LocalDate manufacturerDate; //Cannot be Future Date
    private String status; //Valid Values: (AVAILABLE, ALLOCATED, DEFECTIVE)
    private String manufacturer;

    /*
     * Getters for CyberneticOrgan Class
     */
    public String getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public String getModel() {
        return model;
    }
    public int getPowerLevel() {
        return powerLevel;
    }
    public double getCompatibilityScore() {
        return compatibilityScore;
    }
    public LocalDate getManufactureDate() {
        return manufacturerDate;
    }
    public String getStatus() {
        return status;
    }
    public String getManufacturer() {
        return manufacturer;
    }

    /*
     * Setters for CyberneticOrgan Class
     */
    public void setId(String id) {
        this.id = id;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }
    public void setCompatibilityScore(double compatibilityScore) {
        this.compatibilityScore = compatibilityScore;
    }
    public void setManufactureDate(LocalDate manufacturerDate) {
        this.manufacturerDate = manufacturerDate;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /*
     * Constructor for CyberneticOrgan Class with arguments
     */
    public CyberneticOrgan(String id, String type, String model, int powerLevel, double compatibility, LocalDate manufacturerDate, String status, String manufacturer) {

        this.id = id;
        this.type = type;
        this.model = model;
        this.powerLevel = powerLevel;
        this.compatibilityScore = compatibility;
        this.manufacturerDate = manufacturerDate;
        this.status = status;
        this.manufacturer = manufacturer;
    }

    /*
     * Constructor for CyberneticOrgan Class without arguments
     */
    public CyberneticOrgan() {
        this.id = "";
        this.type = "";
        this.model = "";
        this.powerLevel = 0;
        this.compatibilityScore = 0.0;
        this.manufacturerDate = LocalDate.now();
        this.status = "";
        this.manufacturer = "";
    }



}
