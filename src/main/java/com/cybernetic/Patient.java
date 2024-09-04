//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

public class Patient {

    // Fields of the Patient class
    private String name;
    private int age;
    private String medicalHistory;
    private String[] installedOrgans;

    /**
     *  The addOrgan method takes the added CyberneticOrgan and adds it to the array.
     *  @param organ Specific organ added from CyberneticOrgan class
     */

    public String addOrgan(CyberneticOrgan organ)
    {
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
        String installedOrgansInfo = "The current installed organs are: ";

        return nameInfo + ageInfo + medicalHistoryInfo + installedOrgansInfo;
    }

}
