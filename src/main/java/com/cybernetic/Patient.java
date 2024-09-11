//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Patient {

    // Fields of the Patient class
    private static String name;
    private int age;
    private String medicalHistory;
    private CyberneticOrgan[] installedOrgans = new CyberneticOrgan[5];

    //Constructor with args
    public Patient(String person, int years, String medHistory)
    {
        name = person;
        age = years;
        medicalHistory = medHistory;
    }
    //No-Args Constructor
    public Patient()
    {
        name = null;
        age = 0;
        medicalHistory = null;
    }

    /**
     *  The addOrgan method takes the added CyberneticOrgan and adds it to the array.
     *  @param organ Specific organ added from CyberneticOrgan class
     */

    public String addOrgan(CyberneticOrgan organ)
    {
        //If the maximum array value is empty, add new organ
        for(int i = 0; i < installedOrgans.length; i++) {
            if (installedOrgans[4] != null)
            {
                return "Error, " + organ.model + " cannot be added. Maximum organs added.";
            }
            else if(installedOrgans[i] != null)
            {
                continue;
            }
            else
            {
                installedOrgans[i] = organ;
                break;
            }
        }
        return "Organ " + organ.model + " has been added to " + Patient.name + "'s installed organs.\n";
    }

    /**
     * The getPatientInfo method returns all details/fields of this Patient class
     */

    public String getPatientInfo()
    {
        String nameInfo = "The Patient's Name is: " + name;
        String ageInfo = "The Patient's Age is: " + age;
        String medicalHistoryInfo = "Recent Medical History is: " + medicalHistory;

        //using an enhanced for-loop to determine installed organs
        String installedOrgansList = "";

        if(installedOrgans[0] == null)  //if first value of array is empty, state empty
        {
            installedOrgansList = "empty.";
        }

        for(CyberneticOrgan x: installedOrgans)
        {
            if(x == null)
            {
                break;
            }
            else
            {
                installedOrgansList += " " + x;
            }
        }

        String installedOrgansInfo = "The current installed organs are: " + installedOrgansList;

        return nameInfo + ageInfo + medicalHistoryInfo + installedOrgansInfo;
    }

    /**
     * The getOrganList method converts the existing array of CyberneticOrgan objects into an ArrayList
     * @return ArrayList<CyberneticOrgan> objects are returned
     * */
    public ArrayList<CyberneticOrgan> getOrganList()
    {
        //convert the CyberneticOrgan object array into an ArrayList of CyberneticOrgan objects
        ArrayList<CyberneticOrgan> newList = new ArrayList<>(Arrays.asList(installedOrgans));

        return newList; //**attention to this, why the prefix to newList
    }

}
