//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

import java.util.Random;

public class Lung extends CyberneticOrgan
{
    //fields of the Lung class
    private int oxygenLevel;
    private int oxygenLevelMin = Math.min(70, 100); //minimum value of oxygenLevel, 70
    private int oxygenLevelMax = Math.max(70, 100); //maximum value of oxygenLevel, 100
    private int newOxygenLevel; //new oxygenLevel value
    private int randMax = 1; //maximum value for random number generation
    private int randMin = -2; //minimum value for random number generation
    private int healthChange; //new health value

    //No-Arg Constructor
    public Lung(){
        //health starts at 100 max
        health = 100;
        //oxygenLevel starts at 95
        oxygenLevel = 95;

    }

    //Getter for oxygenLevel
    public int getOxygenLevel(){
        return oxygenLevel;
    }

    /**
     * The lungUpdate method updates the oxygen level and health of the lung based on the pump rate of the heart
     * @param oH object of the Heart
     * */

    public void lungUpdate(Heart oH){
        Random rand = new Random(); //Random object for random number generation on newOxygenLevel calculation
       //Calculating the new oxygen level
        newOxygenLevel = oxygenLevel + (oH.getPumpRate()/20) - 3 + (rand.nextInt(randMax - randMin + 1) + randMin);
        //check if newOxygenLevel is within the min and max values
        if(newOxygenLevel < oxygenLevelMin){
            newOxygenLevel = oxygenLevelMin; //if newOxygenLevel is less than oxygenLevelMin, set newOxygenLevel to oxygenLevelMin
            oxygenLevel = newOxygenLevel;
        }
        else if(newOxygenLevel > oxygenLevelMax){
            newOxygenLevel = oxygenLevelMax; //if newOxygenLevel is greater than oxygenLevelMax, set newOxygenLevel to oxygenLevelMax
            oxygenLevel = newOxygenLevel;
        }
        else {
            oxygenLevel = newOxygenLevel;
        }

        //Updating the Health of the Lung
        healthChange = (-1 + (oH.getPumpRate()/25) - 2);
        health += healthChange;
        //check if health is within the min and max values
        if(health < healthMin){
            health = healthMin;
        }
        else if(health > healthMax){
            health = healthMax;
        }
    }
}
