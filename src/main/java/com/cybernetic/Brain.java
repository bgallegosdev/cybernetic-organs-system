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
     * */

    public void brainUpdate(Lung oL){
        Random random = new Random(); //Random object for random number generation on newControlEfficiency calculation
        //Calculating the new control efficiency
        newControlEfficiency = controlEfficiency + (oL.getOxygenLevel()/20) - 3 + (random.nextInt(randMax - randMin + 1) + randMin);
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
