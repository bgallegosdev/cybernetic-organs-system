//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

import java.util.Random;

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
    protected int minRan = -10; //minimum value for random number generation of 10% random health change
    protected int maxRan = 10; //maximum value for random number generation of 10% random health change
    private int randOrgChoice; //randomly chosen organ to affect


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

    /**
     * The startSimulation method is the main method that runs the simulation of the organ system
     * The method is recursive and will run until the time reaches 0
     * The method will output the health of the organs and any alerts if the health is below 35%
     * @param n time of the simulation
     * @param h object of the Heart
     * @param l object of the Lung
     * @param b object of the Brain
     * */
    public void startSimulation(int n, Heart h, Lung l, Brain b)
    {
        //If time reaches 0, end the simulation and output ending statements
        //Determine if health remaining is a success vs failure
        if(n == 0) //BASE CASE
        {
            System.out.println("Simulation Ended:");
            System.out.println("Time: " + n);
            System.out.println("Heart Health " + h.getHealth());
            System.out.println("Lung Health: " + l.getHealth());
            System.out.println("Brain Health: " + b.getHealth());

            if (h.getHealth() == 0 || l.getHealth() == 0 || b.getHealth() == 0)
            {
                System.out.println("Simulation Result: FAILURE");
            }
            else
            {
                System.out.println("Simulation Result: SUCCESS");
            }
            return;
        }

        //Output initial states of the organs
        if(n == 100)
        {
            System.out.println("Time: " + n);
            System.out.println("Initial States:");
            System.out.println("Heart Health " + h.getHealth());
            System.out.println("Lung Health: " + l.getHealth());
            System.out.println("Brain Health: " + b.getHealth() + "\n");
        }

        //Each time the simulation runs, the organs will update their health and output the new health
        if (n < 100){
            System.out.println("Time: " + n);
            randOrgChoice = randomEvent();
//            System.out.println("Random Organ Choice: " + randOrgChoice); //debugging
            h.heartUpdate(b, l, randOrgChoice, n); //update the heart
            l.lungUpdate(h, randOrgChoice, n); //update the lung
            b.brainUpdate(l, randOrgChoice, n); //update the brain
            System.out.println("Heart Health " + h.getHealth() + "| Pump Rate: " + h.getPumpRate());
            System.out.println("Lung Health: " + l.getHealth() + "| Oxygen Level: " + l.getOxygenLevel());
            System.out.println("Brain Health: " + b.getHealth() + "| Control Efficiency Level: " + b.getControlEfficiency() + "\n");

            //Health Alerts if health is below 35% or reaches 0% to end the program
            if(h.getHealth() < 35)
            {
                System.out.println("ALERT at Time: " + n + ": Heart Critical! Health is below 35%");
            }
            else if(h.getHealth() == 0) //if health reaches 0, end the simulation
            {
                n = 0;
            }

            if(l.getHealth() < 35)
            {
                System.out.println("ALERT at Time: " + n + ": Lung Critical! Health is below 35%");
            }
            else if(l.getHealth() == 0)
            {
                n = 0;
            }

            if(b.getHealth() < 35)
            {
                System.out.println("ALERT at Time: " + n + ": Brain Critical! Health is below 35%");
            }
            else if(b.getHealth() == 0)
            {
                n = 0;
            }
        }
        startSimulation(n-1, h, l, b); //RECURSIVE CALL
    }

    /**
     * The randomEvent method first determines each time the recursive function startSimulation is called, if a random event will occur 10% of the time
     * If a random event occurs, the method will randomly choose an organ to affect and return the choice to the organ to adjust the health output
     * */
    public int randomEvent()
    {
        Random rand = new Random();
        int randOrgHealthChange = (rand.nextInt(10) + 1); //if random number is 1 or 10%, then a random organ will be affected
        int choiceRandOrgan = 0; //initialize the choice of random organ to 0

//        System.out.println("Random Organ Health Change: " + randOrgHealthChange); //debugging

        //if random number is 1, then a random organ will be affected
        if(randOrgHealthChange == 1)
        {
            choiceRandOrgan = (rand.nextInt(3) + 1); //randomly choose which organ to affect 1 - 3
        }

        return choiceRandOrgan;
    }
}
