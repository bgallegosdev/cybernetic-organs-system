//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

public class CyberneticOrgan
{
    // Fields of the CyberneticOrgan class
    private int id;
    private String model;
    private String functionality;
    private String compatibility;

    /**
     * The getDetails method returns details on the Organ instance
     */

    public String getDetails()
    {
        String idDetails = "The Organ's ID is: " + id;
        String modelDetails = "The Model is: " + model;
        String functionalityDetails = "The functionality of the organ is: " + functionality;
        String compatibilityDetails = "The compatibility is: " + compatibility;

        return idDetails + "\n" + modelDetails + "\n" + functionalityDetails + "\n" + compatibilityDetails;
    }

    /**
     * The isCompatible method returns details on Compatibility. TBD later
     */

    public String isCompatible(String patientCompatibility)
    {
        return patientCompatibility;
    }
}
