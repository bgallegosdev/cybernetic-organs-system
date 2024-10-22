//Class pulled from src/main/java/com/cybernetic/Organ.java of main branch; edits by Benjamin Gallegos
package com.cybernetic;

public class Organ {
    private String id;  // New property
    private String name;
    private String bloodType;
    private int weight;
    private String hlaType;

    public Organ(String id, String name, String bloodType, int weight, String hlaType) {
        this.id = id;
        this.name = name;
        this.bloodType = bloodType;
        this.weight = weight;
        this.hlaType = hlaType;
    }

    public String getName() { return name; }
    public String getBloodType() { return bloodType; }
    public int getWeight() { return weight; }
    public String getHlaType() { return hlaType; }
    public String getId() {return id; }

}