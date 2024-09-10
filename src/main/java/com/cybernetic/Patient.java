//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Patient {

    // Fields of the Patient class
    private String name;
    private int age;
    private String medicalHistory;
    private CyberneticOrgan[] CyberneticOrganArr = new CyberneticOrgan[5];

    /**
     *  The addOrgan method takes the added CyberneticOrgan and adds it to the array.
     *  @param organ Specific organ added from CyberneticOrgan class
     */

    public String addOrgan(CyberneticOrgan organ)
    {
        //If the maximum array value is empty, add new organ
        if(CyberneticOrganArr[4] == null)
        {
            CyberneticOrganArr[4] = organ;
        }
        else //else, display error and end the method
        {
           return "Error, " + organ + " cannot be added. Maximum organs added.";
        }
        return "Organ " + organ + " has been added!";
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

        if(CyberneticOrganArr[0] == null)  //if first value of array is empty, state empty
        {
            installedOrgansList = "empty.";
        }

        for(CyberneticOrgan x: CyberneticOrganArr)
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
        List<CyberneticOrgan> newList = Arrays.asList(CyberneticOrganArr);

        return (ArrayList<CyberneticOrgan>) newList; //**attention to this, why the prefix to newList
    }

}
