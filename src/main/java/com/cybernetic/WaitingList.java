package com.cybernetic;


public class WaitingList {
    //implement a linked list
    private WaitingListNode head = null; //head of linked list

    /*
     * Methods for adding to the linked list
     */

    /**
     * Method addPatient to add a patient in the waiting list node
     * @param p for Patient to be added
     * @param priority for rank of priority list
     */

    public void addPatient(Patient p, int priority)
    {
        head = new WaitingListNode(p, priority);
    }



}
