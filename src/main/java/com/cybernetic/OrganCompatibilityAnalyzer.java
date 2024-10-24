package com.cybernetic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrganCompatibilityAnalyzer {
    private List<Organ> organs;
    private List<Patient> patients;

    /**
     * Constructor
     * Initialize the organs and patients lists
     */

    public OrganCompatibilityAnalyzer() {
        organs = new ArrayList<>();
        patients = new ArrayList<>();
    }

    /**
     * Method to add an organ to the list of organs
     * @param organ the organ to be added
     */
    public void addOrgan(Organ organ) {
        organs.add(organ);
    }

    /**
     * Method to add a patient to the list of patients
     * @param patient the patient to be added
     */
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    /**
     * Method to find a compatible organs for compatible patients
     * @param patient the patient to be matched
     * @return the patient that is compatible with the organ
     */
    public List<Organ> getCompatibleOrgans(Patient patient) {
        //filter the organs list to only include organs that are compatible with the patient
       return organs.stream()
               .filter(organ -> isCompatible(organ, patient))
               .collect(Collectors.toList());
    }

    /**
     * Method to find a compatible patient for a given organ
     * @param organ the organ to be matched
     * @return the patient that is compatible with the organ
     */
    public boolean isCompatible(Organ organ, Patient patient)
    {
        //flag
        boolean compatScore = false;


        //variables to hold compatibility values
        int bloodValue;
        int weightValue;

        bloodValue = calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType());
        weightValue = calculateWeightCompatibility(organ.getWeight(), patient.getWeight());

        if(bloodValue > 0 && weightValue > 0)
        {
            compatScore = true;
        }

        return compatScore;
    }

    /**
     * Method to calculate compatibility scores for all patients
     * @return a map of patients and their compatibility scores
     */
    public Map<Patient, List<Double>> calculateCompatibilityScores() {
        //create list of Double Compatibility scores
        List<Double> compatScoresList = new ArrayList<>();
        double compatScore = 0.0;
        Double compatScoreTemp = compatScore;

        //create HashMap to store patients and compatibility scores of compatible organs
        Map<Patient, List<Double>> patientMap = new HashMap<>();

        //iterate through each stream element and obtain the compatibility scores
        //store scores in HashMap
        patients.stream().forEach(patient -> {
            organs.stream().forEach(organ -> {
                double v = this.calculateCompatibilityScore(organ, patient);
                compatScoresList.add(v);
            });
            patientMap.put(patient, compatScoresList);
        });

        return patientMap;
    }

    /**
     * Method to calculate compatibility score for a given organ and patient
     * @param organ the organ to be matched
     * @param patient the patient to be matched
     * @return the compatibility score
     */
   public double calculateCompatibilityScore(Organ organ, Patient patient) {
        double bloodTypeScore = calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType());
        double weightScore = calculateWeightCompatibility(organ.getWeight(), patient.getWeight());
        double hlaScore = calculateHlaCompatibility(organ.getHlaType(), patient.getHlaType());
        return (bloodTypeScore * 0.4) + (weightScore * 0.3) + (hlaScore * 0.3);
    }

    /**
     * Method to calculate blood type compatibility
     * @param donorType the blood type of the donor
     * @param recipientType the blood type of the recipient
     * @return the compatibility score
     */
    private int calculateBloodTypeCompatibility(String donorType, String recipientType) {
        int compatibility = 0; //set compatibility score to 0

        if(donorType.equals(recipientType))
        {
            compatibility = 100; //if the donor and recipient have the same blood type, set compatibility to 100
        }
        //Checking O- compatibility; Universal Donor
        else if(donorType.equals("O-") && (recipientType.equals("O+") || recipientType.equals("B-") || recipientType.equals("A+")))
        {
            compatibility = 80; //if the donor is O- and the recipient is O+ or B- or A+, set compatibility to 80
        }
        //Checking A+ compatibility
        else if(donorType.equals("A+") && (recipientType.equals("O+") || recipientType.equals("B-")))
        {
            compatibility = 0; //if the donor is A+ and the recipient is O+ or B-, set compatibility to 0
        }

        //debugging
        // System.out.println("Donor: " + donorType + " Recipient: " + recipientType + " Compatibility: " + compatibility);
        //end debugging

        return compatibility;
    }

    /**
     * Method to calculate weight compatibility
     * @param organWeight the weight of the organ
     * @param patientWeight the weight of the patient
     * @return the compatibility score
     */
    private int calculateWeightCompatibility(int organWeight, int patientWeight) {
        int weightScore = 0; //set weight score to 0
        double weightRatio = (organWeight / (patientWeight * 1000.0));
        //ystem.out.println(weightRatio + " for " + organWeight + " and " + patientWeight); //debugging

        if( weightRatio >= 0.8 && weightRatio <= 1.2)
        {
            weightScore = 100; //if the weight ratio is between 0.8 and 1.2, set compatibility to 100
        }
        else if( weightRatio >= 0.6 && weightRatio < 0.8)
        {
            weightScore = 50; //if the weight ratio is between 0.6 and 0.8, set compatibility to 50
        }
        else if( weightRatio <= 1.4 && weightRatio > 1.2)
        {
            weightScore = 50; //if the weight ratio is between 1.2 and 1.4, set compatibility to 50
        }

        return weightScore;
    }

    /**
     * Method to calculate HLA compatibility
     * @param organHla the HLA type of the organ
     * @param patientHla the HLA type of the patient
     * @return the compatibility score
     */
    private int calculateHlaCompatibility(String organHla, String patientHla) {
        int compatibility = 0; //set compatibility score to 0

        //tokenize the organHla and patientHla strings
        String[] organHlaTokens = organHla.split("-");
        String[] patientHlaTokens = patientHla.split("-");

        //counter for the number of matching HLA types
        int matchingHla = 0;

        //iterate through the organHlaTokens
        for(String organHlaToken : organHlaTokens)
        {
            //iterate through the patientHlaTokens
            for(String patientHlaToken : patientHlaTokens)
            {
                //if the organHlaToken matches the patientHlaToken
                if(organHlaToken.equals(patientHlaToken))
                {
                    matchingHla++; //increment the matchingHla counter
                }
            }
        }

        //calculate the compatibility score based on the number of matching HLA types
        if(matchingHla == 6)
        {
            compatibility = 100; //if all 6 HLA types match, set compatibility to 100
        }
        else if(matchingHla == 5)
        {
            compatibility = 80; //if 5 HLA types match, set compatibility to 80
        }
        else if(matchingHla == 4)
        {
            compatibility = 60; //if 4 HLA types match, set compatibility to 60
        }
        else if(matchingHla == 3)
        {
            compatibility = 50; //if 3 HLA types match, set compatibility to 50
        }
        else if(matchingHla == 2)
        {
            compatibility = 20; //if 2 HLA types match, set compatibility to 20
        }
        else if (matchingHla == 1)
        {
            compatibility = 10; //if 1 HLA type matches, set compatibility to 10
        }

        return compatibility;
    }

    /**
     * Method to find a compatible patient for an organ
     * Finding the highest priority patient in the waiting list for a given organ
     */
    public void findCompatiblePatient(CyberneticOrgan organ, WaitingList waitingList)
    {

    }

}