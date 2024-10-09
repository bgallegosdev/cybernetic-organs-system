package com.cybernetic;

import java.util.ArrayList;
import java.util.List;

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

    public int[][] createCompatibilityMatrix() {
        int[][] matrix = new int[organs.size()][patients.size() * 3]; // 3 factors: blood type, weight, HLA

        //TODO:  Calculate compatibility for each organ-patient pair
        for(int i = 0; i < organs.size(); i++)
        {
            Organ organ = organs.get(i); //get the organ at index i
            for(int j = 0; j < patients.size(); j++)
            {
                Patient patient = patients.get(j); //get the patient at index j

                //calculate the compatibility for each factor
                int bloodTypeCompatibility = calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType());
                int weightCompatibility = calculateWeightCompatibility(organ.getWeight(), patient.getWeight());
                int hlaCompatibility = calculateHlaCompatibility(organ.getHlaType(), patient.getHlaType());

                //set the compatibility scores in the matrix
                matrix[i][j * 3] = bloodTypeCompatibility;
                matrix[i][j * 3 + 1] = weightCompatibility;
                matrix[i][j * 3 + 2] = hlaCompatibility;
            }
        }

        return matrix;
    }

    private int calculateBloodTypeCompatibility(String donorType, String recipientType) {
        //TODO: Calculate compatibility for each organ-patient pair based on compatibility calculation rules.

        int compatibility = 0; //set compatibility score to 0

        if(donorType.equals(recipientType))
        {
            compatibility = 100; //if the donor and recipient have the same blood type, set compatibility to 100
        }
        //Checking O- compatibility; Universal Donor
        else if(donorType.equals("O-") && (recipientType.equals("O+") || recipientType.equals("B-") || recipientType.equals("A+")))
        {
            compatibility = 80; //if the donor is O- and the recipient is O+, set compatibility to 80
        }
        //Checking A+ compatibility
        else if(donorType.equals("A+") && (recipientType.equals("O+") || recipientType.equals("B-")))
        {
            compatibility = 0; //if the donor is A+ and the recipient is O+ or B-, set compatibility to 0
        }

        return compatibility;
    }

    private int calculateWeightCompatibility(int organWeight, int patientWeight) {
        //TODO: Calculate compatibility for each organ-patient pair based on compatibility calculation rules.

        int weightScore = 0; //set weight score to 0
        int weightRatio = organWeight / (patientWeight * 1000);

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
        //TODO: Calculate compatibility for each organ-patient pair based on compatibility calculation rules.

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

    public double[][] calculateWeightedCompatibility(double[] weights) {
        int[][] compatibilityMatrix = createCompatibilityMatrix();
        double[][] resultMatrix = new double[organs.size()][patients.size()];

        //TODO: calculate the weighted compatibility for each organ-patient pair
        for(int i = 0; i < compatibilityMatrix.length; i++)
        {
            for(int j = 0; j < compatibilityMatrix[i].length; j+=3)
            {
                //calculate the weighted compatibility score
                double weightedCompatibility = (weights[0] * compatibilityMatrix[i][j] +
                        weights[1] * compatibilityMatrix[i][j + 1] +
                        weights[2] * compatibilityMatrix[i][j + 2]) / 3.0;

                //set the weighted compatibility score in the resultMatrix
                resultMatrix[i][j / 3] = weightedCompatibility;
            }
        }

        return resultMatrix;
    }


    public void displayMatrix(int[][] matrix) {
        System.out.println("Initial Compatibility Matrix:");
        //TODO: complete the displayMatrix method to display the initial compatibility matrix

        // Print patient IDs
        System.out.print("  ");
        for (Patient patient : patients) {
            System.out.print(patient.getId() + " " + patient.getId() + " " + patient.getId() + " ");
        }
        System.out.println();

        for(int i = 0; i < matrix.length; i++)
        {
            System.out.print(organs.get(i).getName() + " ");
            for(int j = 0; j < matrix[i].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void displayWeightMatrix(double[] weights) {
        System.out.println("\nWeight Matrix:");
        for (double weight : weights) {
            System.out.printf("%.2f  ", weight);
        }
        System.out.println();
    }

    public void displayWeightedMatrix(double[][] matrix) {
        System.out.println("\nFinal Weighted Compatibility Matrix:");
        System.out.print("  ");
        //TODO: complete the displayWeightedMatrix method to display the final weighted compatibility matrix

        // Print patient IDs
        for (Patient patient : patients) {
            System.out.print(patient.getId() + " ");
        }
        System.out.println();

        for(int i = 0; i < matrix.length; i++)
        {
            System.out.print(organs.get(i).getName() + " ");
            for(int j = 0; j < matrix[i].length; j++)
            {
                System.out.printf("%.1f ", matrix[i][j]);
            }
            System.out.println();
        }
    }

}