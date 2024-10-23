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
        next = this.next;
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
        next = this.next;
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
}
