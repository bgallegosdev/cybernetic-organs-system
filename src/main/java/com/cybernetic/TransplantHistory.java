package com.cybernetic;

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
        TransplantRecord newRecord = new TransplantRecord(record.operationId, record.patientId, record.organId, record.surgeon, record.outcome);

        //If list is empty, make new node as head
        if(this.head == null){
            this.head = newRecord;
        }
        else{
            //Else, traverse to the last node and insert new node there
            TransplantRecord last = this.head;
            while(last.next != null){
                last = last.next;
            }
            //Insert new node at last node
            last.next = newRecord;
        }

        //Return list by head
        return this.head;
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
            currentNode = currentNode.next;
        }
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
            currentNode = currentNode.next;
        }

        // Get the last numberTransplants records by iterating through the tempList in reverse order
        int start = Math.max(tempList.size() - numberTransplants, 0); // Ensure start is not negative
        for (int i = tempList.size() - 1; i >= start; i--) {
            recordsList.add(tempList.get(i));
        }

        return recordsList;
    }

}
