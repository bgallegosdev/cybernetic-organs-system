package com.cybernetic;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Comparator;

public class OrganManagementSystem {
    private List<Organ> organs;
    private List<Patient> patients;

    public OrganManagementSystem(List<Organ> organs, List<Patient> patients) {
        this.organs = organs;
        this.patients = patients;
    }

    public Set<String> getUniqueBloodTypes() {
        //Create a HashSet to hold String objects of Unique Blood Types from previous list
        Set<String> bloodTypes = new HashSet<>();

        //iterate through Organ List and convert all blood types into list of unique blood types
        organs.stream().forEach(o -> {
            String oBloodType = o.getBloodType();
            bloodTypes.add(oBloodType);
        });

        //iterate through Patient List and convert all blood types into list of unique blood types
        patients.stream().forEach(p -> {
            String pBloodType = p.getBloodType();
            bloodTypes.add(pBloodType);
        });

        return bloodTypes;
    }

    public Map<String, List<Patient>> groupPatientsByBloodType() {
        //Create TreeMap of Patient Blood Types, and the Patient objects
        //TreeMap because the list will be in alphabetical sorted order
        Map<String, List<Patient>> pByBlood = new TreeMap<>();

        //iterate over Patients List and add to map
        patients.stream().forEach(patient -> {
            String pBloodType = patient.getBloodType();
            pByBlood.put(pBloodType, patients);
        });

        return pByBlood;
    }

    public List<Organ> sortOrgansByWeight() {
        //Create List of Organ Objects by weight field
        List<Organ> organsByWeight = new LinkedList<>(organs);

        //using the sort method of List.java to sort the List by Weight size
        organsByWeight.stream().forEach(organ -> {

        });

        //need to sort the list by weight, casting required to compare the weight of the organs using Integer.compare
        Collections.sort(organsByWeight, (o1, o2) -> Integer.compare(o1.getWeight(), o2.getWeight())); //sort by weight


        return organsByWeight;
    }

    public List<Organ> getTopCompatibleOrgans(Patient patient, int n) {
        //Create a List of Organ objects
        List<Organ> topOrgans = new LinkedList<>(organs);

        //Create a Comparator to sort the List of Organ objects by compatibility score
        Comparator<Organ> compScore = (o1, o2) -> {
            OrganCompatibilityAnalyzer analyzer = new OrganCompatibilityAnalyzer();
            double score1 = analyzer.calculateCompatibilityScore(o1, patient);
            double score2 = analyzer.calculateCompatibilityScore(o2, patient);
            return Double.compare(score2, score1);
        };

        //Sort the List of Organ objects by compatibility score
        Collections.sort(topOrgans, compScore);

        //Return the first n elements of the List
        return topOrgans.subList(0, n);

        //  ORIGINAL CODE -- DOESN'T WORK
//        //Temporary Organ list return
//        List<Organ> tempOrganList = new LinkedList<>();
//
//        //Create List of Organ objects best compatible by each patient
//        List<Organ> topOrgans = new LinkedList<>();
//
//        //Create OrganCompatibility Object to call on the getCompatibleOrgans method
//        OrganCompatibilityAnalyzer analyzer = new OrganCompatibilityAnalyzer();
//
//        //store compatible organs in topOrgans List
//        tempOrganList = analyzer.getCompatibleOrgans(patient);
//        //use stream to sort the temp list by natural order
//        tempOrganList.stream().sorted().toList();
//
//        //start debugging
//        System.out.println(tempOrganList);
//        //end debugging
//
//        //grab top three organs after sorted list
//        for(int i = 0; i < n; i++)
//        {
//            topOrgans.add(tempOrganList.get(i));
//        }
//
//        return  topOrgans;
//    }
//  }
    }
}
