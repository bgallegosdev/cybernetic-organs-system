package com.cybernetic;

public class WaitingListNode {

    //fields of the Node Waiting List
    private Patient patient; //the patient in the waiting list
    private int priority; //priority of the patient (high number means high priority)
    private WaitingListNode next; //reference to the next node in the list

    /**
     *  Constructor
     * @param p the Patient to store in the node
     * @param rank the rank of priority to store in the node
     * @param successor the next reference of the next node to be store in this node
     * adding just in case
     */
    WaitingListNode(Patient p, int rank, WaitingListNode successor)
    {
        patient = p;
        priority = rank;
        next = successor.next;
    }

    /**
     *  Constructor - without a successor parameter
     * @param p the Patient to store in the node
     * @param rank the rank of priority to store in the node
     * adding just in case
     */
    WaitingListNode(Patient p, int rank)
    {
        patient = p;
        priority = rank;
        next = this.getNext();
    }

    /**
     *  Constructor - without a successor or rank parameter
     * @param p the Patient to store in the node
     * adding just in case
     */
    WaitingListNode(Patient p)
    {
        patient = p;
        priority = 0;
        next = this.getNext();
    }

    /**
     *  No-Arg Constructor
     * adding just in case
     */
    WaitingListNode()
    {
        patient = null;
        priority = 0;
        next = null;
    }


    /*
        * Getters and Setters
     */

    /**
     * Method getPatient to get the patient in the node
     * @return the patient in the node
     */
    public Patient getPatient()
    {
        return patient;
    }

    /**
     * Method getNext to get the next node in the list
     * @return the next node in the list
     */
    public WaitingListNode getNext() {
        return this.next;
    }

    /**
     * Method getPriority to get the priority of the patient in the node
     * @return the priority of the patient in the node
     */
    public int getPriority(){
        return this.priority;
    }

    /**
     * Method setPriority will set the new priority of the WaitingListNode
     * @param newPriority new rank in priority list
     */
    public void setPriority(int newPriority) {
        priority = newPriority;
    }
}
