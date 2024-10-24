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
        //sort the list
        head = sortList(head);

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

        //check if the node list is empty
        if(this.isEmpty()) {
            System.out.println("This is list is empty, no Patients to remove");
            return;
        }

        //check if the node is located on the head
        if (head.getPatient().getId().equals(patientId)) {
            head = head.getNext(); //if located in head, move the head variable
            if(head == null) {
                last = null; //List is empty
            }
            return;
        }

        // Traverse the list to find the patient
        WaitingListNode current = head;
        WaitingListNode previous = null;

        while (current != null && !current.getPatient().getId().equals(patientId)) {
            previous = current;
            current = current.getNext();
        }

        // If the patient was found
        if (current != null) {
            previous.setNext(current.getNext());
            if (current == last) {
                last = previous; // Update last if the last node was removed
            }
        } else {
            System.out.println("Patient not found in the list");
        }
    }

    //Credit Below: Using Co-Pilot to Generate a Sorting Algorithm for the WaitingList
    /**
     * Method sortList will sort the list in order of highest priority to lowest
     * @param head the head of the list
     * @return the head of the sorted list
     */
    public WaitingListNode sortList(WaitingListNode head) {
        //check if the list is empty
        if (head == null || head.getNext() == null) {
            return head;
        }

        //initialize the sorted list
        WaitingListNode sortedList = null;

        //create reference to node to traverse through WaitingListNodes
        WaitingListNode current = head;

        //traverse through linked lists
        while (current != null) {
            //store the next node
            WaitingListNode next = current.getNext();

            //check if the current node is greater than the head
            if (sortedList == null || current.getPriority() > sortedList.getPriority()) {
                //insert the current node at the head
                current.setNext(sortedList);
                sortedList = current;
            } else {
                //traverse through the sorted list
                WaitingListNode ref = sortedList;
                while (ref.getNext() != null && ref.getNext().getPriority() > current.getPriority()) {
                    ref = ref.getNext();
                }
                //insert the current node
                current.setNext(ref.getNext());
                ref.setNext(current);
            }
            //move to the next node
            current = next;
        }
        return sortedList;
    }

}