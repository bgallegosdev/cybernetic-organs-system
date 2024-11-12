//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

import java.time.LocalDate;
import java.util.ArrayList;

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
     */
    public void addOrgan(CyberneticOrgan organ){
        if(this.idCheck(organ) && this.manufactureCheck(organ) && this.powerLevelCheck(organ) && this.typeCheck(organ) && this.compatibilityCheck(organ))
        {
            this.organs.add(organ);
        }
        else{
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
        boolean check = true;

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
        LocalDate currentTime = LocalDate.now();

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



}
