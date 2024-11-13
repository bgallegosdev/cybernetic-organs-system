//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

import java.time.LocalDate;
import java.util.ArrayList;

public class Patient {

    /*
     * Fields of Patient Class
     */
    private String id; //Format: (PAT-XXXX)
    private String name;
    private int age; //Range: 1 - 120
    private String bloodType; //Valid Values: (A+, A-, B+, B-, AB+, AB-, O+, O-)
    private String organNeeded; //Valid Values: (A+, A-, B+, B-, AB+, AB-, O+, O-)
    private int urgencyLevel; //Range: 1 - 10, 10 is most urgent
    private LocalDate registrationDate;
    private String status; //Valid Values: (WAITING, MATCHED, TRANSPLANTED)

    /*
     * Getters for Patient Class
     */
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getBloodType(){
        return bloodType;
    }
    public String getOrganNeeded(){
        return organNeeded;
    }
    public int getUrgencyLevel(){
        return urgencyLevel;
    }
    public LocalDate getRegistrationDate(){
        return registrationDate;
    }
    public String getStatus(){
        return status;
    }

    /*
     * Setters for Patient Class
     */
    public void setId(String identity){
        id = identity;
    }
    public void setName(String givenName){
        name = givenName;
    }
    public void setAge(int ageGiven){
        //checks if age is in the given range
        if(ageGiven > 0 && ageGiven < 120) {
            age = ageGiven;
        }
        else
            throw new IllegalArgumentException("Patient age is invalid");
    }
    public void setBloodType(String blood){
        //checks if blood type is a valid option: A+, A-, B+, B-, AB+, AB-, O+, O-
        if(blood.equals("A+") || blood.equals("A-") || blood.equals("B+") || blood.equals("B-") || blood.equals("AB+") || blood.equals("AB-") || blood.equals("O+") || blood.equals("O-")) {
            bloodType = blood;
        }
        else
            throw new IllegalArgumentException("Patient blood type is invalid");
    }
    public void setOrganNeeded(String needed){
        //checks if organ needed is a valid option: HEART, LUNG, KIDNEY, LIVER
        if(needed.equals("HEART") || needed.equals("LUNG") || needed.equals("KIDNEY") || needed.equals("LIVER")) {
            organNeeded = needed;
        }
        else
            throw new IllegalArgumentException("Patient organ needed is not a valid choice");
    }
    public void setUrgencyLevel(int level){
        //checks if the level is between 1 and 10
       if(level >= 1 && level <= 10) {
           urgencyLevel = level;
       }else
           throw new IllegalArgumentException("Urgency level is invalid");
    }
    public void setRegistrationDate(LocalDate date){
        registrationDate = date;
    }
    public void setStatus(String stat){
        //all patients must start with WAITING as starting status
        if(stat.equals("WAITING")) {
            status = stat;
        }
        else
            throw new IllegalArgumentException("New patients start at WAITING only");
    }

    /*
     * Constructor for Patient Class with arguments
     */
    public Patient(String id, String givenName, int ageGiven, String blood, String neededOrgan, int level, LocalDate date, String stat) {

        //using setters to validate information passed to the Patient class
        //making sure the data meets the requirements
        setId(id);
        setName(givenName);
        setAge(ageGiven);
        setBloodType(blood);
        setOrganNeeded(neededOrgan);
        setUrgencyLevel(level);
        setRegistrationDate(date);
        setStatus(stat);
    }

    /*
     * Constructor for Patient Class with no-arguments
     */
    public Patient() {
        this.id = "";
        this.name = "";
        this.age = 0;
        this.bloodType = "";
        this.organNeeded = "";
        this.urgencyLevel = 0;
        this.registrationDate = LocalDate.now();
        this.status = "";
    }

}
