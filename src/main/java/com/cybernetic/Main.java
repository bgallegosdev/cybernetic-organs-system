//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        //creating an object of the OrganInventory class for a new organList
        OrganInventory organList = new OrganInventory();

        //creating first organ
        CyberneticOrgan CyberHeartX1 = new CyberneticOrgan(1, "CyberHeartX1", "Pumps Blood", "Type O");
        //creating second organ
        CyberneticOrgan CyberEyeV2 = new CyberneticOrgan(2, "CyberEyeV2", "Enhanced Vision", "Type A");

        //adding first and second organs
        System.out.println(organList.addOrgan(CyberHeartX1));
        System.out.println(organList.addOrgan(CyberEyeV2));

        //creating patient John Doe
        Patient johnDoe = new Patient("John Doe", 28, "Diabetic");

        //adding organ to John Doe
        System.out.println(johnDoe.addOrgan(CyberHeartX1));

        //Creating ArrayList for returned installed organs
        ArrayList<CyberneticOrgan> installedOrganList = new ArrayList<>();
        installedOrganList = johnDoe.getOrganList();
        System.out.println("Listing installed organs for John Doe: ");
        for(CyberneticOrgan o : installedOrganList)
        {
            if(o == null)
            {
                break;
            }
            else
            {
                System.out.println(o.getModel() + ": " + o.getFunctionality() + "\n");
            }
        }

        //Searching organsList for functionality
        ArrayList<CyberneticOrgan> functionOrganList = new ArrayList<>();
        functionOrganList = organList.searchOrganByFunctionality("Enhanced Vision");
        for(CyberneticOrgan o : functionOrganList)
        {
            System.out.println(o.getModel() + ": " + o.getFunctionality() + "\n");
        }

        //Sorting organList by model name
        ArrayList<CyberneticOrgan> sortedOrganList = new ArrayList<>();
        sortedOrganList = organList.sortOrgansByModel();
        System.out.println("Sorted organs:");
        for(CyberneticOrgan o : sortedOrganList)
        {
            System.out.println("- " + o.getModel());
        }

    }
}