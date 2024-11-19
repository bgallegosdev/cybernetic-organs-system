package com.cybernetic;

//EmergencyWaitlist class based off of PriorityQueue and BST data structures
public class EmergencyWaitlist {
    private EmergencyCase root; //root of the EmergencyWaitlist

    /**
     * Method addEmergencyCase to add a new EmergencyCase to the EmergencyWaitlist
     * @param case1 is the EmergencyCase to be added
     * @return root is the root of the EmergencyWaitlist
     */
    public EmergencyCase addEmergencyCase(EmergencyCase case1) {
        //if node is empty, add
        if(root == null)
        {
            root = new EmergencyCase(case1.getCaseId(), case1.getPatient(), case1.getSeverityLevel(), case1.getRegistrationTime());
            return root;
        }

        //if data is less than root's data value, go left
        if(case1.getSeverityLevel() < root.getSeverityLevel()){
            root.setLeft(insertNode(root.getLeft(), case1)); //recursive call
        }
        else if(case1.getSeverityLevel() > root.getSeverityLevel()){ //if data is more than root's data value, go right
            root.setRight(insertNode(root.getRight(), case1)); //recursive call
        }

        //return the new data
        return root;
    }

    //helper method for insert to relate data to Nodes with the EmergencyCase class
    private EmergencyCase insertNode(EmergencyCase root, EmergencyCase case1) {
        if(root == null){ //if node is empty, add
            root = new EmergencyCase(case1.getCaseId(), case1.getPatient(), case1.getSeverityLevel(), case1.getRegistrationTime());
            return root;
        }

        //if data is less than root's data value, go left
        if(case1.getSeverityLevel() < root.getSeverityLevel()){
            root.setLeft(insertNode(root.getLeft(), case1)); //recursive call
        }
        else if(case1.getSeverityLevel() > root.getSeverityLevel()){ //if data is more than root's data value, go right
            root.setRight(insertNode(root.getRight(), case1)); //recursive call
        }
        //return the new data
        return root;
    }

    /**
     * Method getNextUrgentCase to get the next EmergencyCase in the EmergencyWaitlist
     * @return case is the next EmergencyCase in the EmergencyWaitlist
     */
    public EmergencyCase getNextUrgentCase() {
        while(root.getRight() != null){ //continue to search right subtree until right is null
            root = root.getRight(); //keep assigning the right data value until null, when max is found
        }
        return root; //return the maximum
    }

    /**
     * Method updateCaseSeverity to update a specific EmergencyCase's severity level
     * @param caseId case to find in the tree
     * @param levelUpdate update to the case's severityLevel
     */
    public void updateCaseSeverity(String caseId, int levelUpdate) {
        if (root == null) {
            throw new IllegalArgumentException("Emergency Waiting List is empty.");
        }

        if (caseId.compareTo(root.getCaseId()) < 0) {
            root.setLeft(updateCaseSeverityRec(root.getLeft(), caseId, levelUpdate));
        } else if (caseId.compareTo(root.getCaseId()) > 0) {
            root.setRight(updateCaseSeverityRec(root.getRight(), caseId, levelUpdate));
        } else {
            root.setSeverityLevel(levelUpdate);
        }
    }

    //helper method for updateCaseSeverity to relate data to Nodes with the EmergencyCase class
    private EmergencyCase updateCaseSeverityRec(EmergencyCase left, String caseId, int levelUpdate) {
        root = updateCaseSeverityRec(root, caseId, levelUpdate);
        return root;
    }
}
