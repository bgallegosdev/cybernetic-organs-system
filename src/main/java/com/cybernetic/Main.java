//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

import java.util.ArrayList;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Heart h = new Heart();
        Lung l = new Lung();
        Brain b = new Brain();

        //Create Cybernetic Organ Object for Recursion Simulation
        CyberneticOrgan trifecta = new CyberneticOrgan();
        trifecta.startSimulation(100, h, l, b);

    }
}