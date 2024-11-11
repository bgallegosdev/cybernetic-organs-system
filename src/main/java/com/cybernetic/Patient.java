//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

import java.time.LocalDate;

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

}
