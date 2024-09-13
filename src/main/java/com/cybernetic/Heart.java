//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

import java.util.Random;

public class Heart extends CyberneticOrgan
{
    // Fields of the Heart class
    private int pumpRate;
    private int pumpRateMin = Math.min(40, 100); //minimum value of pumpRate, 40
    private int pumpRateMax = Math.max(40, 100); //maximum value of pumpRate, 100
    private int newPumpRate; //new pump rate value
    private int healthChange; //new health value
    private int randMax = 3; //maximum value for random number generation
    private int randMin = -4; //minimum value for random number generation

    //No-Arg Constructor
    public Heart(){
        //health starts at 100 max
        health = 100;
        //pumpRate starts at 70
        pumpRate = 70;
    }

    //Getter for pumpRate
    public int getPumpRate(){
        return pumpRate;
    }

    /**
     * The heartUpdate method updates the pump rate and health of the heart based on the control efficiency of the brain and the oxygen level of the lung
     * @param oB object of the Brain
     * @param oL object of the Lung
     * */

    public void heartUpdate(Brain oB, Lung oL){

        //Updating the Pump Rate of the Heart
        Random rand = new Random(); //Random object for random number generation on newPumpRate calculation
        newPumpRate = pumpRate + (oB.getControlEfficiency()/10) - 5 + (rand.nextInt(randMax - randMin + 1) + randMin);
        //check if newPumpRate is within the min and max values
        if(newPumpRate < pumpRateMin){
            newPumpRate = pumpRateMin; //if newPumpRate is less than pumpRateMin, set newPumpRate to pumpRateMin
            pumpRate = newPumpRate;
        }
        else if(newPumpRate > pumpRateMax){
            newPumpRate = pumpRateMax; //if newPumpRate is greater than pumpRateMax, set newPumpRate to pumpRateMax
            pumpRate = newPumpRate;
        }
        else {
            pumpRate = newPumpRate;
        }

        //Updating the Health of the Heart
        healthChange = (-1 + (oL.getOxygenLevel()/25) - 2);
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
