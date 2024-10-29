package com.cybernetic;

import java.util.Objects;
import java.util.Queue;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PatientWaitingList {
    private Queue<Patient> waitingList = new LinkedList<>();

    /**
     * Add a new patient to the end of the waiting list.
     * @param patient The patient to be added to the waiting list.
     */
    public void addPatient(Patient patient) {
        waitingList.add(patient);
    }

    /**
     * Remove and return the next patient from the front of the waiting list.
     * @return The next patient in the waiting list.
     */
    public Patient removeNextPatient() {
       return waitingList.remove();
    }

    /**
     * Check if the patient waiting list is empty.
     * @return True if the waiting list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return waitingList.isEmpty();
    }

    /**
     * Print the current state of the patient waiting list.
     */
    public void printWaitingList() {
        System.out.println(this.toString());
    }

    /**
     * Method overrides toString to display waitingList properly
     * @return String
     */
    @Override
    public String toString(){
        return waitingList.stream()
                .filter(Objects::nonNull)
                .map(Patient::getName)
                .collect(Collectors.joining("<-----"));
    }
}
