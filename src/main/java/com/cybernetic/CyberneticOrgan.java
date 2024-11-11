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


}
