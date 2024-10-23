package com.cybernetic;


public class WaitingList {
    //implement a linked list
    private WaitingListNode head; //head of linked list
    private WaitingListNode last; //last node of the linked list

    /**
     * Constructor
     */
    public WaitingList()
    {
        head = null;
        last = null;
    }

    /*
     * Methods for operating on linked lists
     */

    /**
     * Method addPatient to add a patient in the waiting list node
     * @param p for Patient to be added
     * @param priority for rank of priority list
     */
    public void addPatient(Patient p, int priority)
    {
        if(this.isEmpty()) {
            head = new WaitingListNode(p, priority);
            last = head;
        }
        else
        {
            last.setNext(new WaitingListNode(p, priority));
            last = last.getNext();
        }
    }

    /**
     * Method removeHighestPriority removes the highest level rank of the waiting list
     */
    public Patient removeHighestPriority()
    {
        if (this.isEmpty())
        {
            return null;
        }
        else
        {
            Patient p = head.getPatient();
            head = head.getNext();
            return p;
        }
    }

    /**
     * Method updatePriority sets a priority
     * @param patientId indicates a call to the patientId of the patient for comparison
     * @param newPriority new rank
     */
    public void updatePriority(String patientId, int newPriority)
    {
        //create reference to node to traverse through WaitingListNodes
        WaitingListNode ref = head;

        while(ref != null)
        {
            if(ref.getPatient().getId().equals(patientId))
            {
                ref.setPriority(newPriority);
            }
           ref = ref.getNext();
        }
    }

    /**
     * Method displayWaitingList will display all waiting lists in ranking
     */
    public void displayWaitingList()
    {
        //create reference to node to traverse through WaitingListNodes
        WaitingListNode ref = head;

        //traverse through linked lists
        while(ref != null)
        {
            //print the node list
            System.out.println("Patient: " + ref.getPatient().getName() + ", Priority: " + ref.getPriority());
            ref = ref.getNext();
        }
    }

    /**
     * Method isEmpty will check in the Waitinglist is empty
     */
    public boolean isEmpty(){
        return head == null; //if head is null, presumably the list is empty
    }

    /**
     * Method getPosition will return the position of the Patient sent
     * @param patientId the Patient's id to be returned position of
     */
    public int getPosition(String patientId)
    {
        //create reference to node to traverse through WaitingListNodes
        WaitingListNode ref = head;

        //use a counter
        int count = 0;

        //traverse through linked lists
        while(ref != null)
        {
            if(ref.getPatient().getId().equals(patientId)) //if id found break look
            {
                break;
            }
            else { //else, increase counter and move reference point
                count++;
                ref = ref.getNext();
            }
        }
        return count;
    }

    /**
     * Method removePatient removes a Patient from the WaitingListNode
     */
    public void removePatient(String patientId)
    {
        //create reference to node to traverse through WaitingListNodes
        WaitingListNode ref = head;

        //create reference to hold node successor
        WaitingListNode refNext = ref.getNext();

        //first check if the node list is empty
        if(this.isEmpty())
            System.out.println("This is list is empty, no Patients to remove");

        //traverse through linked lists, if empty skip
        while(ref != null && !ref.getPatient().getId().equals(patientId))
        {

        }

        //if found, remove it and move the successor
        if(ref.getPatient().getId().equals(patientId))
        {

        }
        else {
            ref = ref.getNext();
        }
    }
}
