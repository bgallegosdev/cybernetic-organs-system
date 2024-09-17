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
    int randomAdjust; //random adjustment value

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
     * @param randomChoice random choice of organ to affect
     * @param time time of the event
     * */
    public void heartUpdate(Brain oB, Lung oL,int randomChoice,int time){
        //Updating the Pump Rate of the Heart
        Random rand = new Random(); //Random object for random number generation on newPumpRate calculation
//        System.out.println("Control Efficiency: " + oB.getControlEfficiency()); //debugging
        randomAdjust = (rand.nextInt(randMax - randMin + 1) + randMin); //random number generation for random adjustment
//        System.out.println("Random Adjustment: " + randomAdjust); //debugging
        newPumpRate = (pumpRate + (oB.getControlEfficiency()/10) - 5 + (randomAdjust));
//        System.out.println("newPumpRate: " + newPumpRate); //debugging

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
//        System.out.println("newPumpRate: " + newPumpRate); //debugging

        //Updating the Health of the Heart
//        System.out.println("oL.getOxygenLevel(): " + oL.getOxygenLevel()); //debugging
        healthChange = (-1 + (oL.getOxygenLevel()/25) - 2);
        health += healthChange;

        //check if health is within the min and max values
        if(health < healthMin){
            health = healthMin;
        }
        else if(health > healthMax){
            health = healthMax;
        }

        //initiate 10% random health change
        if (randomChoice == 1){
            int randHealthChange = 0; //random health change value
            randHealthChange = (rand.nextInt(maxRan - minRan + 1) + minRan);
//            System.out.println("randHealthChange: " + randHealthChange); //debugging
            System.out.println("EVENT at Time " + time + ": Random health change for heart by " + randHealthChange + "%");
            health += randHealthChange;
        }
//        System.out.println("Heart healthChange: " + healthChange); //debugging

        //check if health is within the min and max values
        if(health < healthMin){
            health = healthMin;
        }
        else if(health > healthMax){
            health = healthMax;
        }
    }

}
