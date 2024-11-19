package com.cybernetic;

import java.util.ArrayList;
import java.util.List;

public class SystemOperationsLog {
    ArrayList<SystemOperation> list;

    /**
     * Constructor for SystemOperationsLog class with arguments
     */
    public SystemOperationsLog(int size) {
        this.list = new ArrayList<>(size);
    }

    /**
     * Constructor for SystemOperationsLog class with no-arg
     */
    public SystemOperationsLog() {
        this.list = new ArrayList<>();
    }

    /**
     * Method systemOperation to push an operation to the list
     * @param systemOperation is the operation to be pushed
     */
    public void pushOperation(SystemOperation systemOperation) {
        this.list.add(systemOperation);
    }

    /**
     * Method popLastOperation to pop the last operation from the list
     * @return the last operation from the list
     */
    public SystemOperation popLastOperation() {
        return this.list.removeLast();
    }

    /**
     * Method peekLastOperation to peek the last operation from the list but not remove it
     * @return the last operation from the list
     */
    public SystemOperation peekLastOperation() {
        return this.list.getLast();
    }

    /**
     * Method toString to print the list
     * @return the list as a string
     */
    @Override
    public String toString(){
        return this.list.toString();
    }

    /**
     * Method getRecentOperations returns the recent number of System Operations based on the number of operations passed
     * @param numberOperations is the number of operations passed to return
     * @return operationList list of the number of recent transplants
     */
    public List<SystemOperation> getRecentOperations(int numberOperations) {
        List<SystemOperation> operationList = new ArrayList<>();

        //check if list is empty
        if (this.list.isEmpty()) {
            System.out.println("This System Operations Log is empty.");
            return operationList;
        }

        // Get the last numberTransplants records by iterating through the tempList in reverse order
        int start = Math.max(this.list.size() - numberOperations, 0); // Ensure start is not negative
        for (int i = this.list.size() - 1; i >= start; i--) {
            operationList.add(this.list.get(i));
        }

        return operationList;
    }
}
