//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

public class OrganInventory {

    // Field of the OrganInventory class
    private String[] inventory;

    /**
     *   The addOrgan method adds the CyberneticOrgan organ to the inventory field of this class.
     *   @param organ Organ listed from the CyberneticOrgan class
     */
    public String addOrgan(CyberneticOrgan organ)
    {
        return "You've added " + organ + " organ to the inventory!";
    }

    /**
     *  The getOrgan method returns the organ needed for the model given
     * @param model Part model compatibility
     */

    public String getOrgan(String model)
    {
        return "The organ needed for model " + model + " is : *insert organ*";
    }
}
