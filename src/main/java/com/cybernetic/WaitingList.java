package com.cybernetic;


public class WaitingList {
    //implement a linked list
    private WaitingListNode head; //head of linked list

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

    /**
     * Method removeHighestPriority removes the highest level rank of the waiting list
     */
    public Patient removeHighestPriority()
    {
        if (head == null)
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
    }

}
