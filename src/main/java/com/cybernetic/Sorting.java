//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

/****************************************************
 * Sorting Class
 * This class contains the sorting algorithms
 * used to sort the array of integers.
 ****************************************************/

public class Sorting {

    /**
     * The bubbleSort method sorts the array using the bubble sort algorithm.
     *
     * @param array The array to sort.
     */
    public static void bubbleSort(int[] array) {
        int temp; // Temporary variable to hold the value being swapped
        boolean swap; // Flag to indicate a swap occurred

        do {
            swap = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swap = true;
                }
            }
        } while (swap);
    }

    /**
     * The selectionSort method sorts the array using the selection sort algorithm.
     *
     * @param array The array to sort.
     */
    public static void selectionSort(int[] array) {
        int startScan; // Starting position of the scan
        int index; // To hold a subscript value
        int minIndex; // Element with the smallest value in the scan
        int minValue; // The smallest value found in the scan

        for (startScan = 0; startScan < array.length - 1; startScan++) {
            minIndex = startScan; // Assume the first element is the smallest
            minValue = array[startScan]; // Assume the first element is the smallest
            for (index = startScan + 1; index < array.length; index++) {
                if (array[index] < minValue) {
                    minValue = array[index];
                    minIndex = index;
                }
            }
            // Swap the element with the smallest value with the first element in the scan
            array[minIndex] = array[startScan];
            array[startScan] = minValue;
        }
    }

    /**
     * The insertionSort method sorts the array using the insertion sort algorithm.
     *
     * @param array The array to sort.
     */
    public static void insertionSort(int[] array) {
        int unsortedValue; // The first unsorted value
        int scan; // Used to scan the array

        // The outer loop steps the index variable through each subscript in the array, starting at 1.
        for(int index = 1; index < array.length; index++){
            // The first element outside the sorted subset of the array is array[index].
            // Store the value of this element in unsortedValue.
            unsortedValue = array[index];

            // Start the scan variable at the subscript of the first element outside the sorted subset.
            scan = index;

            // Move the first element outside the sorted subset into its proper position within the sorted subset.
            while (scan > 0 && array[scan - 1] > unsortedValue) {
                array[scan] = array[scan - 1];
                scan--;
            }

            // When the loop is finished, scan is the subscript where unsortedValue should be inserted.
            array[scan] = unsortedValue;
        }
    }

    /**
     * The mergeSort method sorts the array using the merge sort algorithm.
     *
     * @param array The array to sort.
     */
    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;

            // Split the array into two halves
            int[] left = new int[mid];
            int[] right = new int[array.length - mid];

            System.arraycopy(array, 0, left, 0, mid);
            System.arraycopy(array, mid, right, 0, array.length - mid);

            // Recursively sort each half
            mergeSort(left);
            mergeSort(right);

            // Merge the sorted halves
            merge(array, left, right);
        }
    }

    /**
     * The merge method merges two sorted arrays into one sorted array.
     *
     * @param array The array to merge into.
     * @param left The left array to merge.
     * @param right The right array to merge.
     */
    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge the left and right arrays
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy any remaining elements of left array
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy any remaining elements of right array
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}