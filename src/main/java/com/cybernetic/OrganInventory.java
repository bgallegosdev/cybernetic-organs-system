//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class OrganInventory {

    // Field of the OrganInventory class
    private ArrayList<CyberneticOrgan> inventoryList = new ArrayList<>(); //dynamic storing of inventory of organs

    /**
     *   The addOrgan method adds the CyberneticOrgan organ to the inventory field of this class.
     *   @param organ Organ listed from the CyberneticOrgan class
     */
    public String addOrgan(CyberneticOrgan organ)
    {
        inventoryList.add(organ);
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


    /**
     * The getOrganList method simply returns an ArrayList of the inventory of organs to calling method
     * @return ArrayList<CyberneticOrgans> called inventoryList
     * */

    public ArrayList<CyberneticOrgan> getOrganList()
    {
        return inventoryList;
    }

    /**
     * The removeOrgan method searches the ArrayList<CyberneticOrgan> inventoryList for an organ where the organ matches the calling method's model passed.
     * If found, the organ is removed from the ArrayList. And returns a statement to the user, the organ is successfully removed.
     * If not found, the method returns a statement that it is not found.
     * @return String statement that the organ is either removed successfully or not
     * */

    public String removeOrgan(String model)
    {
        //flag
        boolean organFound = false;

        //Strings for returns
        String removeStatement = "";

            for (CyberneticOrgan x : inventoryList) {
                if (x.model.equals(model)) {
                    inventoryList.remove(x);
                    organFound = true;
                    removeStatement += "Organ from model " + model + " has been successfully removed.";
                }
            }

        if (!organFound)
        {
            removeStatement += "Organ from model " + model + " was not found or removed from inventory.";
        }

        return removeStatement;
    }

    /**
     * The searchOrganByFunctionality method searches inventoryList for the object based on its functionality property.
     * If matching functionality found, then the object is added to a new ArrayList to return to calling method.
     * If not found, message is relayed that none are found and an empty ArrayList is sent back.
     * @return ArrayList<Cybernetic Organs> if matches are found, if not then a message is displayed
     * */

    public ArrayList<CyberneticOrgan> searchOrganByFunctionality(String functionality)
    {
        //new ArrayList to return to method
        ArrayList<CyberneticOrgan> searchedList = new ArrayList<>();

        //flag
        boolean organFound = false;

        for (CyberneticOrgan x : inventoryList)
        {
            if (CyberneticOrgan.functionality.equals(functionality)) {
                searchedList.add(x);
                organFound = true;
            }
        }

        if(organFound == false)
        {
            System.out.println("No organ was found under the functionality: " + functionality);
            System.out.println("An empty ArrayList has been returned to you.");
        }

        return searchedList;
    }

    /** The sortOrgansByModel method has several parts to it.
     * Resources Attributed Online for Support/Structure for Comparator:
     * ChatGPT: https://chatgpt.com/ -- Date: 09/10/2024 -- Structure/Knowledge
     * BeginnersBook: https://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/ -- Date: 09/10/2024 -- Knowledge
     *
     * First, the method creates a Comparator list modelSorted.
     * Second, the method uses the compare method on CyberneticOrgans to compare each one of the models of the organs for sorting.
     * Third, the Collections.sort method uses the comparator to sort the inventoryList
     * @return the sorted inventoryList is now sorted by model name
     *
     * *All websites are used as support for learning the new material in this method
     * */

    public ArrayList<CyberneticOrgan> sortOrgansByModel()
    {
        //Using a comparator
        Comparator<CyberneticOrgan> modelSorted = new Comparator<CyberneticOrgan>() {
            @Override
            public int compare(CyberneticOrgan o1, CyberneticOrgan o2) {
                return o1.getModel().compareTo(o2.getModel());
            }
        };

        //Sorting the list, using comparator
        Collections.sort(inventoryList, modelSorted);

        return inventoryList;

    }
}
