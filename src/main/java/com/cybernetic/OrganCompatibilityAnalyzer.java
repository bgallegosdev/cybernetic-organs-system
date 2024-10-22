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

    public OrganCompatibilityAnalyzer() {
        organs = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void addOrgan(Organ organ) {
        organs.add(organ);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public List<Organ> getCompatibleOrgans(Patient patient) {
        //filter the organs list to only include organs that are compatible with the patient
       return organs.stream()
               .filter(organ -> isCompatible(organ, patient))
               .collect(Collectors.toList());
    }

    //helper method
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

//        //iterate through the patients list
//        for(Patient x: patients)
//        {
//            for(Organ y: organs)
//            {
//                compatScoreTemp = this.calculateCompatibilityScore(y, x);
//                compatScoresList.add(compatScoreTemp);
//            }
//
//            patientMap.put(x, compatScoresList);
//        }

        return patientMap;
    }

    //helper method
   public double calculateCompatibilityScore(Organ organ, Patient patient) {
        double bloodTypeScore = calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType());
        double weightScore = calculateWeightCompatibility(organ.getWeight(), patient.getWeight());
        double hlaScore = calculateHlaCompatibility(organ.getHlaType(), patient.getHlaType());
        return (bloodTypeScore * 0.4) + (weightScore * 0.3) + (hlaScore * 0.3);
    }

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
//        System.out.println("Donor: " + donorType + " Recipient: " + recipientType + " Compatibility: " + compatibility);
        //end debugging

        return compatibility;
    }

    private int calculateWeightCompatibility(int organWeight, int patientWeight) {
        int weightScore = 0; //set weight score to 0
        double weightRatio = (organWeight / (patientWeight * 1000.0));
//        System.out.println(weightRatio + " for " + organWeight + " and " + patientWeight); //debugging

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

}