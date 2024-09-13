//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

public class CyberneticOrgan
{
    // Fields of the CyberneticOrgan class
    private int id;
    protected String model;
    protected String functionality;
    private String compatibility;
    protected int health; //health value of the organ
    protected int healthMin = 0; //minimum value of health, 0
    protected int healthMax = 100; //maximum value of health, 100

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

    public int getHealth()
    {
        return health;
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

    public void startSimulation(int n)
    {
        if(n == 0) //BASE CASE
        {
            return;
        }
        Heart h = new Heart();
        Lung l = new Lung();
        Brain b = new Brain();

        if(n == 100)
        {
            System.out.println("Time: " + n);
            System.out.println("Initial States:");
            System.out.println("Heart Health " + h.getHealth());
            System.out.println("Lung Health: " + l.getHealth());
            System.out.println("Brain Health: " + b.getHealth() + "\n");
        }

        if (n < 100){
            System.out.println("Time: " + n);
            h.heartUpdate(b, l);
            l.lungUpdate(h);
            b.brainUpdate(l);
            System.out.println("Heart Health " + h.getHealth() + "| Pump Rate: " + h.getPumpRate());
            System.out.println("Lung Health: " + l.getHealth() + "| Oxygen Level: " + l.getOxygenLevel());
            System.out.println("Brain Health: " + b.getHealth() + "| Control Efficiency Level: " + b.getControlEfficiency() + "\n");
        }
        startSimulation(n-1);
    }
}
