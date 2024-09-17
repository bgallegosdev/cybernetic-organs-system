//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

public class Main
{
    public static void main(String[] args)
    {
        //Create Organs for Recursion Simulation
        Heart h = new Heart();
        Lung l = new Lung();
        Brain b = new Brain();

        //Create Cybernetic Organ Object for Recursion Simulation
        CyberneticOrgan trifecta = new CyberneticOrgan();

        //Call to the Recursive Method, startSimulation
        trifecta.startSimulation(100, h, l, b);

    }
}