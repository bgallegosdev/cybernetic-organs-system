//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class OrganInventory{

    /*
     * Fields of the OrganInventory class
     */
    private ArrayList<CyberneticOrgan> organs = new ArrayList<>();
    private int maxCapacity; //Default: 1000

    /*
     * Getters for OrganInventory class
     */
    public ArrayList<CyberneticOrgan> getOrgans(){
        return this.organs;
    }
    public int getMaxCapacity(){
        return this.maxCapacity;
    }

    /*
     * Setters for OrganInventory class
     */
    public void setOrgans(ArrayList<CyberneticOrgan> givenOrganList){
        organs.addAll(givenOrganList);
    }
    public void setMaxCapacity(int capacity){
        this.maxCapacity = capacity;
    }


    /**
     * Method addOrgan adds an organ to the OrganInventory and does a validation check for valid parameters
     * @param organ organ to be added to the list if requirements are met
     */
    public void addOrgan(CyberneticOrgan organ){
        //validating data is within requirements
        if(this.idCheck(organ) && this.manufactureCheck(organ) && this.powerLevelCheck(organ) && this.typeCheck(organ) && this.compatibilityCheck(organ))
        {
            this.organs.add(organ); //if so, add organ
        }
        else{
            //if not valid data, throw exceptions mentioned
            if(!this.idCheck(organ)){
                throw new IllegalArgumentException("Organ id is not unique.");
            } else if (!this.manufactureCheck(organ)){
                throw new IllegalArgumentException("Organ manufacture date is in the future");
            } else if (!this.powerLevelCheck(organ)){
                throw new IllegalArgumentException("Organ power level is invalid");
            } else if (!this.typeCheck(organ)){
                throw new IllegalArgumentException("Organ type is approved organ type");
            } else if (!this.compatibilityCheck(organ)){
                throw new IllegalArgumentException("Organ compatibility score is invalid");
            }
        }
    }

    /**
     * Method idCheck, checks if the ID is unique by going through ArrayList organs
     * helper method for addOrgan
     * @param organ organ to be added to list and to be id checked
     * @return check a boolean expression if the id is unique or not
     */
    private boolean idCheck(CyberneticOrgan organ){
        boolean check = true; //flag

        for(CyberneticOrgan o : organs)
        {
            if(o.getId().equals(organ.getId()))
            {
                check = false;
                return check;
            }
        }
        return check;
    }

    /**
     * Method manufactureCheck, checks if the Manufacture Date is not in the future
     * helper method for addOrgan
     * @param organ organ to be added to list and for Manufacture Date to be checked
     * @return boolean expression if to be added organ is after LocalDate current time
     */
    private boolean manufactureCheck(CyberneticOrgan organ){
        LocalDate currentTime = LocalDate.now(); //get local time to compare

        if(organ.getManufactureDate().isAfter(currentTime)){
            return false;
        }

        return true;
    }

    /**
     * Method powerLevelCheck, checks if the power level is in the specified range
     * helper method for addOrgan
     * @param organ organ to be added to the list and for powerLevel to be checked
     * @return boolean expression if powerLevel is between parameters of 1 - 100
     */
    private boolean powerLevelCheck(CyberneticOrgan organ){
        if(organ.getPowerLevel() >= 1 && organ.getPowerLevel() <= 100) {
            return true;
        }
        else
            return false;
    }

    /**
     * Method typeCheck, checks if the type is an acceptable typing for an organ
     * helper method for addOrgan
     * @param organ organ to be added to the list and for type to be checked
     * @return boolean expression if type is within list of valid options
     */
    private boolean typeCheck(CyberneticOrgan organ) {
        if(organ.getType().equals("HEART") || organ.getType().equals("LUNG") || organ.getType().equals("KIDNEY") || organ.getType().equals("LIVER")){
            return true;
        }
        else
            return false;
    }

    /**
     * Method compatibilityCheck, checks if the compatibility score is within range
     * helper method for addOrgan
     * @param organ organ to be added to the list and for compatibility type to be checked
     * @return boolean expression if the score is within range or not
     */
    private boolean compatibilityCheck(CyberneticOrgan organ) {
        if (organ.getCompatibilityScore() >= 0.0 && organ.getCompatibilityScore() <= 1.0) {
            return true;
        } else
            return false;
    }

    /**
     * Method removeOrgan, first checks if organ does exist already in the list
     * If so, removes organ listed
     * If not, outputs error and removes none
     * @param organ organ to be removed
     */
    public void removeOrgan(CyberneticOrgan organ){
        boolean organExists = false;
        String reason;

        //output and input for reasoning of removal
        System.out.println("What is the reason for the removal?");
        Scanner input = new Scanner(System.in);
        reason = input.nextLine();
        System.out.println("Reason: " + reason);

        //loop for checking if organ id matches in list
        for(CyberneticOrgan o : organs)
        {
            if(o.getId().equals(organ.getId())){
                organExists = true;
                organs.remove(o);
            }
        }

        if(organExists){
            System.out.println("Organ " + organ.getId() + " was found and removed.");
        }
        else
            System.out.println("Organ " + organ.getId() + " was not found in list to remove.");
    }

    /**
     * Method sortByPowerLevel, sorts the ArrayList organs by Power Level using QuickSort Method in descending order
     */
    public ArrayList<CyberneticOrgan> sortByPowerLevel() {
        ArrayList<CyberneticOrgan> sortedOrgans = new ArrayList<>(organs);
        quickSort(sortedOrgans, 0, sortedOrgans.size() - 1);
        return sortedOrgans;
    }

    /**
     *Method quickSort is a helper method for sortByPowerLevel
     * @param organs ArrayList of organs to be sorted
     * @param i index of the first element
     * @param last index of the last element
     */
    private void quickSort(ArrayList<CyberneticOrgan> organs, int i, int last) {
        if (i < last) {
            int partitionIndex = partition(organs, i, last);
            quickSort(organs, i, partitionIndex - 1);
            quickSort(organs, partitionIndex + 1, last);
        }
    }

    /**
     * Method partition is a helper method for quickSort
     * @param organs ArrayList of organs to be sorted
     * @param i index of the first element
     * @param last index of the last element
     * @return int value of the partition
     */
    private int partition(ArrayList<CyberneticOrgan> organs, int i, int last) {
        CyberneticOrgan pivot = organs.get(last);
        int index = i - 1;

        for (int j = i; j < last; j++) {
            if (organs.get(j).getPowerLevel() > pivot.getPowerLevel()) {
                index++;
                CyberneticOrgan temp = organs.get(index);
                organs.set(index, organs.get(j));
                organs.set(j, temp);
            }
        }

        CyberneticOrgan temp = organs.get(index + 1);
        organs.set(index + 1, organs.get(last));
        organs.set(last, temp);

        return index + 1;
    }

    /**
     * Method sortByManufactureDate, sorts the ArrayList organs by Manufacture Date using MergeSort with the Newest Date first
     * @return ArrayList of organs sorted by Manufacture Date
     */
    public ArrayList<CyberneticOrgan> sortByManufactureDate() {
        ArrayList<CyberneticOrgan> sortedOrgans = new ArrayList<>(organs);
        mergeSort(sortedOrgans, 0, sortedOrgans.size() - 1);
        return sortedOrgans;
    }

    /**
     * Method mergeSort is a helper method for sortByManufactureDate
     * @param sortedOrgans ArrayList of organs to be sorted
     * @param i index of the first element
     * @param i1 index of the last element
     */
    private void mergeSort(ArrayList<CyberneticOrgan> sortedOrgans, int i, int i1) {
        if (i < i1) {
            int middle = (i + i1) / 2;
            mergeSort(sortedOrgans, i, middle);
            mergeSort(sortedOrgans, middle + 1, i1);
            merge(sortedOrgans, i, middle, i1);
        }
    }

    /**
     * Method merge is a helper method for mergeSort
     * @param sortedOrgans ArrayList of organs to be sorted
     * @param i index of the first element
     * @param middle index of the middle element
     * @param i1 index of the last element
     */
    private void merge(ArrayList<CyberneticOrgan> sortedOrgans, int i, int middle, int i1) {
        int n1 = middle - i + 1;
        int n2 = i1 - middle;

        CyberneticOrgan[] left = new CyberneticOrgan[n1];
        CyberneticOrgan[] right = new CyberneticOrgan[n2];

        for (int x = 0; x < n1; x++) {
            left[x] = sortedOrgans.get(i + x);
        }

        for (int y = 0; y < n2; y++) {
            right[y] = sortedOrgans.get(middle + 1 + y);
        }

        int x = 0;
        int y = 0;
        int k = i;

        while (x < n1 && y < n2) {
            if (left[x].getManufactureDate().isAfter(right[y].getManufactureDate())) {
                sortedOrgans.set(k, left[x]);
                x++;
            } else {
                sortedOrgans.set(k, right[y]);
                y++;
            }
            k++;
        }

        while (x < n1) {
            sortedOrgans.set(k, left[x]);
            x++;
            k++;
        }

        while (y < n2) {
            sortedOrgans.set(k, right[y]);
            y++;
            k++;
        }
    }

    /**
     * Method sortByCompatibilityScore, sorts the ArrayList organs by Compatibility Score using BubbleSort using highest score first
     * @return ArrayList of organs sorted by Compatibility Score
     */
    public ArrayList<CyberneticOrgan> sortByCompatibilityScore() {
        ArrayList<CyberneticOrgan> sortedOrgans = new ArrayList<>(organs);
        bubbleSort(sortedOrgans);
        return sortedOrgans;
    }

    /**
     * Method bubbleSort is a helper method for sortByCompatibilityScore
     * @param sortedOrgans ArrayList of organs to be sorted
     */
    private void bubbleSort(ArrayList<CyberneticOrgan> sortedOrgans) {
        int n = sortedOrgans.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedOrgans.get(j).getCompatibilityScore() < sortedOrgans.get(j + 1).getCompatibilityScore()) {
                    CyberneticOrgan temp = sortedOrgans.get(j);
                    sortedOrgans.set(j, sortedOrgans.get(j + 1));
                    sortedOrgans.set(j + 1, temp);
                }
            }
        }
    }
}
