package com.cybernetic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransplantHistory {

    TransplantRecord head; //head of the list

    /**
     * Method addTransplantRecordAtBeginning adds a TransplantRecord at the beginning of the TransplantHistory
     * @param record is the passed record to the method
     * @return head is the head of the TransplantHistory
     */
    public TransplantRecord addTransplantRecordAtBeginning(TransplantRecord record) {
        //Create new node with given data
        TransplantRecord newRecord = new TransplantRecord(record.getOperationId(), record.getPatientId(), record.getOrganId(), record.getSurgeon(), record.getOutcome());

        //If list is empty, make new node as head
        if(this.head == null){
            this.head = newRecord;
        }
        else{
            //Else, traverse to the last node and insert new node there
            TransplantRecord last = this.head;
            while(last.getNext() != null){
                last = last.getNext();
            }
            //Insert new node at last node
            last.setNext(newRecord);
        }

        //Return list by head
        return this.head;
    }

    /**
     * Method findTransplantByPatient finds and returns transplant by patient id
     * @param patId patient ID
     * @return searchNode a node found by patient id or null
     */
    public TransplantRecord findTransplantByPatient(String patId){
        //If list is empty, throw exception
        if(this.head == null){
            throw new IllegalArgumentException("Transplant History is empty.");
        }

        //If not, traverse through the list to find node
        TransplantRecord searchNode = this.head;
        while(searchNode != null && !searchNode.getPatientId().equals(patId)){
            searchNode = searchNode.getNext();
        }

        return searchNode; //Will return null if not found
    }

    /**
     * Method getRecentTransplants returns the recent number of transplants based on the number of transplants passed
     * @param numberTransplants is the number of transplants passed
     * @return recordsList list of the number of recent transplants
     */
    public List<TransplantRecord> getRecentTransplants(int numberTransplants) {
        List<TransplantRecord> recordsList = new ArrayList<>();
        TransplantRecord currentNode = this.head;

        if (this.head == null) {
            System.out.println("This Transplant History is empty.");
            return recordsList;
        }

        // Use a temporary list to store all records
        List<TransplantRecord> tempList = new ArrayList<>();
        while (currentNode != null) {
            tempList.add(currentNode);
            currentNode = currentNode.getNext();
        }

        // Get the last numberTransplants records by iterating through the tempList in reverse order
        int start = Math.max(tempList.size() - numberTransplants, 0); // Ensure start is not negative
        for (int i = tempList.size() - 1; i >= start; i--) {
            recordsList.add(tempList.get(i));
        }

        return recordsList;
    }

    /**
     * Method getAllTransplantsByDate returns a LinkedList of all transactions listed by date
     * @param dateTime passed parameter to get the transplants by
     *
     */
    public List<TransplantRecord> getAllTransplantsByDate(LocalDateTime dateTime){
        List<TransplantRecord> dateTimeList = new ArrayList<>();
        TransplantRecord searchNode = this.head;

        //Check if empty
        if (this.head == null) {
            throw new IllegalArgumentException("This Transplant History is empty");
        }

        //If not empty, search list for comparable dates and add them to the list
        while (searchNode != null) {
            if(searchNode.getTimestamp().equals(dateTime))
            {
                dateTimeList.add(searchNode);
            }
            searchNode = searchNode.getNext();
        }

        return dateTimeList;
    }

    /**
     * Method printList supports traversal through the list for printing the operation Id
     * @param record record to be traversed and printed
     */
    public void printList(TransplantRecord record){
        TransplantRecord currentNode = this.head;

        System.out.print("Printing Record: " );

        if(this.head == null)
        {
            System.out.println("This Transplant History is empty.");
            return;
        }

        //Traverse through the list
        while(currentNode != null){
            //Print the data at current node
            System.out.println("Operation Id: " + currentNode.getOperationId());

            //Got to next node
            currentNode = currentNode.getNext();
        }
    }

}
