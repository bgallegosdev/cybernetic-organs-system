//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrganInventory implements Comparator<Organ>{

    // Field of the OrganInventory class
    private ArrayList<CyberneticOrgan> inventoryList = new ArrayList<>(); //dynamic storing of inventory of organs
    private final List<Organ> inventory;

    public OrganInventory() {
        this.inventory = new ArrayList<>();
    }

    /**
     *   The addOrgan method adds the CyberneticOrgan organ to the inventory field of this class.
     *   @param organ Organ listed from the CyberneticOrgan class
     */
//    public String addOrgan(CyberneticOrgan organ)
//    {
//        System.out.println("Adding organs to inventory..");
//        inventoryList.add(organ);
//        return "You've added " + organ.model + " organ to the inventory!\n";
//    }

    //for assignment 5
    public void addOrgan(Organ organ) {
        inventory.add(organ);
    }


    /**
     *  The getOrgan method returns the organ needed for the model given
     * @param model string output of model match
     */

    public String getOrgan(String model)
    {
        return "The organ needed for model " + model + " is : *insert organ*";
    }


    /**
     * The getOrganList method simply returns an ArrayList of the inventory of organs to calling method
     * @return ArrayList<CyberneticOrgans> called inventoryList
     * */

//    public ArrayList<CyberneticOrgan> getOrganList()
//    {
//        return inventoryList;
//    }

    //for assignment 5
    public List<Organ> getOrganList() {
        return Collections.unmodifiableList(inventory);
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
        System.out.println("Searching for organs with the functionality: " + functionality);

        //new ArrayList to return to method
        ArrayList<CyberneticOrgan> searchedList = new ArrayList<>();

        //flag
        boolean organFound = false;

        for (CyberneticOrgan x : inventoryList)
        {
            if (x.functionality.equals(functionality)) {
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
     * Resources Attributed Online only used for Support/Structure for this method, and understanding Comparator:
     * ChatGPT: https://chatgpt.com/ -- Date: 09/10/2024 -- Structure/Knowledge
     * BeginnersBook: https://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/ -- Date: 09/10/2024 -- Knowledge
     *
     * First, the method creates a Comparator list modelSorted.
     * Second, the method uses the compare method on CyberneticOrgans to compare each one of the models of the organs for sorting.
     * Third, the Collections.Sort method uses the comparator to sort the inventoryList
     * @return the sorted inventoryList is now sorted by model name
     *
     * *All websites are used as support for learning the new material in this method
     * */
    Comparator<CyberneticOrgan> modelSorted = new Comparator<CyberneticOrgan>() {
        @Override
        public int compare(CyberneticOrgan o1, CyberneticOrgan o2) {
            return o1.getModel().compareTo(o2.getModel());
        }
    };

    public ArrayList<CyberneticOrgan> sortOrgansByModel()
    {
        //Using a comparator

        //Sorting the list, using comparator
        Collections.sort(inventoryList, modelSorted);

        return inventoryList;

    }



    //for assignment 5
    /**
     *  The sortOrganByNameModelAndCompatibilityUsingBuiltInSort() method ability to sort by multiple properties in order. name, model, compatibility using built-in sort
     */
    public List<Organ> sortOrganByNameModelAndCompatibilityUsingBuiltInSort() {
        Collections.sort(inventory, builtInCompareName); //using collections.sort with comparator for name

//            System.out.println("By Name:"); //debugging for sorting by name
//            for(Organ x: inventory)
//            {
//                System.out.println(x.getName());
//            } //end debug

        Collections.sort(inventory, builtInCompareModel); //using collections.sort with comparator for model

//            System.out.println("By Model:"); //debugging for sorting by Model
//            for(Organ x: inventory)
//            {
//                System.out.println(x.getModel());
//            } //end debug

        Collections.sort(inventory, builtInCompareCompatibility); //using collections.sort with comparator for compatibility

//            System.out.println("By Compatibility:"); //debugging for sorting by Compatibility
//            for(Organ x: inventory)
//            {
//                System.out.println(x.getCompatibility());
//            } //end debug

        return inventory; //return final sort
    }

    //compare method for comparator of the sortOrganByNameModelAndCompatibilityUsingBuildInSort() for name comparison
    Comparator<Organ> builtInCompareName = new Comparator<Organ>()
    {
        @Override
        public int compare(Organ o1, Organ o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    //compare method for comparator of the sortOrganByNameModelAndCompatibilityUsingBuildInSort() for model comparison
    Comparator<Organ> builtInCompareModel = new Comparator<Organ>()
    {
        @Override
        public int compare(Organ o1, Organ o2) {
            return o1.getModel().compareTo(o2.getModel());
        }
    };

    //compare method for comparator of the sortOrganByNameModelAndCompatibilityUsingBuildInSort() for compatibility comparison
    Comparator<Organ> builtInCompareCompatibility = new Comparator<Organ>()
    {
        @Override
        public int compare(Organ o1, Organ o2) {
            return o1.getCompatibility().compareTo(o2.getCompatibility());
        }
    };

    @Override
    public int compare(Organ o1, Organ o2) {
        return 0;
    }

    /**
     *  The quickSortOrganByNameModelAndCompatibility method needed to sort Organ list by using the QuickSort Method; ability to sort by multiple properties in order. name, model, compatibility using quicksort
     * @param unmodifiableOrganList List of organ list
     */
    public List<Organ> quickSortOrganByNameModelAndCompatibility(List<Organ> unmodifiableOrganList) {
        int low = 0; //beginning element of list
        int high = (unmodifiableOrganList.size() - 1); //ending element of list

        quickSort(unmodifiableOrganList, low, high);

//        for(int x = 0; x < unmodifiableOrganList.size(); x++) //debugging
//        {
//            System.out.println(unmodifiableOrganList.get(x).getName());
//        } //end debugging

        return unmodifiableOrganList;
    }

    //actual quicksort method
    public void quickSort(List<Organ> unmodifiableOrganList, int low, int high)
    {
        if(low < high)
        {
            int pivotIndex = partition(unmodifiableOrganList, low, high);
            quickSort(unmodifiableOrganList, low, pivotIndex - 1);
            quickSort(unmodifiableOrganList, pivotIndex + 1, high);
        }
    }

    //pivot method for quickSortOrganByNameModuleAndCompatibility
    //finding pivot in the middle element but moving it to the first as the end of the left sublist
    public int partition(List<Organ> unmodifiableOrganList, int low, int high)
    {
        Organ pivotValue; //holding pivot object
        int endOfLeftList; //last element in left sublist
        int mid; //holding the mid-point subscript

        //find mid in the middle element
        mid = (low + high) / 2;

        //swap mid subscript element with the first to start the end of the left sublist
        swap(unmodifiableOrganList, low, mid);

        //save pivot value for comparisons, after the swap to 1st element
        pivotValue = unmodifiableOrganList.get(low);

        //end of left sublist is first element
        endOfLeftList = low;

        // scan list and move any values "less" than Organ Name, Model, and Compatibility to left of sublist
        for (int scan = low + 1; scan <= high; scan++) {
            int compareValueName = unmodifiableOrganList.get(scan).getName().compareTo(pivotValue.getName()); // comparison by name
            int compareValueModel = unmodifiableOrganList.get(scan).getModel().compareTo(pivotValue.getModel()); // comparison by model
            int compareValueCompatibility = unmodifiableOrganList.get(scan).getCompatibility().compareTo(pivotValue.getCompatibility()); // comparison by compatibility

            // By Name, Model, and Compatibility
            if (compareValueName < 0 || (compareValueName == 0 && compareValueModel < 0) || (compareValueName == 0 && compareValueModel == 0 && compareValueCompatibility <= 0)) {
                endOfLeftList++;
                swap(unmodifiableOrganList, endOfLeftList, scan);
            }
        }

        //move pivot value to the end of the left sublist
        swap(unmodifiableOrganList, low, endOfLeftList);

        //return the subscript of the pivot value
        return endOfLeftList;
    }

    //swap method for partition method
    public void swap(List<Organ> unmodifiableOrganList, int i, int j)
    {
//        Organ temp; //creating a temporary organ, POSSIBLE ERROR
//       temp = unmodifiableOrganList.get(i);
//
//       unmodifiableOrganList.set(i, unmodifiableOrganList.get(j));
//       unmodifiableOrganList.set(j, temp);

            Collections.swap(unmodifiableOrganList, i, j);

    }

}
