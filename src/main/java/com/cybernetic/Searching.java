//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

/****************************************************
 * Searching Class
 * This class contains the searching algorithms
 * used to search the array of integers.
 ****************************************************/

public class Searching {

        /**
        * The sequentialSearch method searches the array using the linear search algorithm.
        *
        * @param array The array to search.
        * @param value The value to search for.
        * @return The subscript of the value if found in the array, otherwise -1.
        */
        public static int sequentialSearch(int[] array, int value) {
            int index = 0; // Used to search the array
            int position = -1; // To record the position of the value being searched
            boolean found = false; // Flag to indicate if the value was found

            while (!found && index < array.length) {
                if (array[index] == value) {
                    found = true;
                    position = index;
                }
                index++;
            }
            return position;
        }

        /**
        * The binarySearch method searches the array using the binary search algorithm.
        *
        * @param array The array to search.
        * @param value The value to search for.
        * @return The subscript of the value if found in the array, otherwise -1.
        */
        public static int binarySearch(int[] array, int value) {
            int first; // First array element
            int last; // Last array element
            int middle; // Mid-point of search
            int position; // Position of search value
            boolean found; // Flag

            // Set the initial values
            first = 0;
            last = array.length - 1;
            position = -1;
            found = false;

            // Search for the value
            while (!found && first <= last) {
                middle = (first + last) / 2;
                if (array[middle] == value) {
                    found = true;
                    position = middle;
                } else if (array[middle] > value) {
                    last = middle - 1;
                } else {
                    first = middle + 1;
                }
            }
            return position;
        }
}
