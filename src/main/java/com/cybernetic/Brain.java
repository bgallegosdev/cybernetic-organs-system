//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

import java.util.Random;

public class Brain extends CyberneticOrgan
{
    // Fields of the Brain class
    private int controlEfficiency;
    private int controlMin = Math.min(50, 100); //minimum value of controlEfficiency, 50
    private int controlMax = Math.max(50, 100); //maximum value of controlEfficiency, 100
    private int newControlEfficiency; //new controlEfficiency value
    private int randMax = 1; //maximum value for random number generation
    private int randMin = -2; //minimum value for random number generation
    private int healthChange; //new health value
    private int randomAdjust; //random adjustment value

    //No-Arg Constructor
    public Brain(){
        //health starts at 100 max
        health = 100;
        //brainWave starts at 90
        controlEfficiency = 90;
    }

    //Getter for controlEfficiency
    public int getControlEfficiency(){
        return controlEfficiency;
    }

    /**
     * The brainUpdate method updates the control efficiency and health of the brain based on the oxygen level of the lung
     * @param oL object of the Lung
     * @param randomChoice random choice of organ to affect
     * @param time time of the event
     * */
    public void brainUpdate(Lung oL, int randomChoice,int time){
        Random rand = new Random(); //Random object for random number generation on newControlEfficiency calculation
        randomAdjust = (rand.nextInt(randMax - randMin + 1) + randMin);

        //Calculating the new control efficiency
        newControlEfficiency = (controlEfficiency + (oL.getOxygenLevel()/20) - 3 + (randomAdjust));

        //check if newControlEfficiency is within the min and max values
        if(newControlEfficiency < controlMin){
            newControlEfficiency = controlMin; //if newControlEfficiency is less than controlMin, set newControlEfficiency to controlMin
            controlEfficiency = newControlEfficiency;
        }
        else if(newControlEfficiency > controlMax){
            newControlEfficiency = controlMax; //if newControlEfficiency is greater than controlMax, set newControlEfficiency to controlMax
            controlEfficiency = newControlEfficiency;
        }
        else {
            controlEfficiency = newControlEfficiency;
        }

        //Updating the Health of the Brain
//        System.out.println("oH.getOxygenLevel: " + oL.getOxygenLevel()); //debugging
        healthChange = (-1 + (oL.getOxygenLevel()/25) - 2);
//        System.out.println("Brain healthChange: " + healthChange); //debugging
        health += healthChange;

        //check if health is within the min and max values
        if(health < healthMin){
            health = healthMin;
        }
        else if(health > healthMax){
            health = healthMax;
        }

        //initiate 10% random health change
        if (randomChoice == 3){
            int randHealthChange = 0; //random health change value
            randHealthChange = (rand.nextInt(maxRan - minRan + 1) + minRan);
//            System.out.println("randHealthChange: " + randHealthChange); //debugging
            System.out.println("EVENT at Time " + time + ": Random health change for brain by " + randHealthChange + "%");
            health += randHealthChange;
        }

        //check if health is within the min and max values
        if(health < healthMin){
            health = healthMin;
        }
        else if(health > healthMax){
            health = healthMax;
        }
    }
}
