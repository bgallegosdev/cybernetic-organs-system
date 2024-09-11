//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

public class CyberneticOrgan
{
    // Fields of the CyberneticOrgan class
    private int id;
    protected String model;
    protected String functionality;
    private String compatibility;


    //Constructor, with args
    public CyberneticOrgan(int num, String mod, String function, String compatible)
    {
      id = num;
      model = mod;
      functionality = function;
      compatibility = compatible;
    }

    //No-Arg Constructor
    public CyberneticOrgan()
    {
        id = 0;
        model = null;
        functionality = null;
        compatibility = null;
    }

    /**
     * SETTERS
     * The setId, setModel, setFunctionality, and setCompatibility methods are able to set fields of the organ object
     * */
    public void setId(int x)
    {
        id = x;
    }

    public void setModel(String x)
    {
        model = x;
    }

    public void setFunctionality(String x)
    {
        functionality = x;
    }

    public void setCompatibility(String x)
    {
        compatibility = x;
    }

    /**
     * GETTERS
     * The getId, getModel, getFunctionality, and getCompatibility method returns the designated field for the organ
     * */
    public int getId()
    {
        return id;
    }

    public String getModel()
    {
        return model;
    }

    public String getFunctionality()
    {
        return functionality;
    }

    public String getCompatibility()
    {
        return compatibility;
    }

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
