//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        //Array used for analyzing six algorithms
        //Calling on method to create array each iteration
        int[] array = getArray();

        //Analyzing bubbleSort algorithm
        analyzeBubbleSort(array);

        //Analyzing insertionSort algorithm
        analyzeInsertionSort(array);

        //Analyzing selectionSort algorithm
        analyzeSelectionSort(array);

        //Analyzing mergeSort algorithm
        analyzeMergeSort(array);

        //Analyzing linearSearch algorithm
        analyzeSequentialSearch(array);

        //Analyzing binarySearch algorithm
        analyzeBinarySearch(array);
    }


    //Method getArray for creating array for analyzing algorithms
    private static int[] getArray() {
        //Random Object for inserting int numbers into array for analyzing
        Random random = new Random();

        //variable for choosing size indicator for array
        //changes per testing of algorithms
        int arraySize = 100;

        //Array used for analyzing six algorithms
        int[] array = new int[arraySize];

        //using a loop to fill in array based on size indicator
        for(int i = 0; i < array.length; i++)
        {
            array[i] = random.nextInt(10);
        }
        return array;
    }

    //Method for analyzing the bubble sort algorithm
    public static void analyzeBubbleSort(int[] array)
    {
        //Starting time for bubble sort
        long bubbleStart = System.nanoTime();
        Sorting.bubbleSort(array);  //Bubble sort method
        //Ending time for bubble sort
        long bubbleEnd = System.nanoTime();
        //Time taken for bubble sort
        long bubbleTime = bubbleEnd - bubbleStart;
        System.out.println("Bubble Sort Time: " + bubbleTime + " nanoseconds");
    }


    //Method for analyzing the insertion sort algorithm
    public static void analyzeInsertionSort(int[] array)
    {
        //Starting time for insertion sort
        long insertionStart = System.nanoTime();
        Sorting.insertionSort(array);  //Insertion sort method
        //Ending time for insertion sort
        long insertionEnd = System.nanoTime();
        //Time taken for insertion sort
        long insertionTime = insertionEnd - insertionStart;
        System.out.println("Insertion Sort Time: " + insertionTime + " nanoseconds");
    }

    //Method for analyzing the selection sort algorithm
    public static void analyzeSelectionSort(int[] array)
    {
        //Starting time for selection sort
        long selectionStart = System.nanoTime();
        Sorting.selectionSort(array);  //Selection sort method
        //Ending time for selection sort
        long selectionEnd = System.nanoTime();
        //Time taken for selection sort
        long selectionTime = selectionEnd - selectionStart;
        System.out.println("Selection Sort Time: " + selectionTime + " nanoseconds");
    }

    //Method for analyzing the merge sort algorithm
    public static void analyzeMergeSort(int[] array)
    {
        //Starting time for merge sort
        long mergeStart = System.nanoTime();
        Sorting.mergeSort(array);  //Merge sort method
        //Ending time for merge sort
        long mergeEnd = System.nanoTime();
        //Time taken for merge sort
        long mergeTime = mergeEnd - mergeStart;
        System.out.println("Merge Sort Time: " + mergeTime + " nanoseconds");
    }

    //Method for analyzing the sequential search algorithm
    public static void analyzeSequentialSearch(int[] array)
    {
        //Starting time for sequential search
        long sequentialStart = System.nanoTime();
        Searching.sequentialSearch(array, 11);  //Sequential search method
        //Ending time for sequential search
        long sequentialEnd = System.nanoTime();
        //Time taken for sequential search
        long sequentialTime = sequentialEnd - sequentialStart;
        System.out.println("Sequential Search Time: " + sequentialTime + " nanoseconds");
    }

    //Method for analyzing the binary search algorithm
    public static void analyzeBinarySearch(int[] array)
    {
        //Starting time for binary search
        long binaryStart = System.nanoTime();
        Searching.binarySearch(array, 11);  //Binary search method
        //Ending time for binary search
        long binaryEnd = System.nanoTime();
        //Time taken for binary search
        long binaryTime = binaryEnd - binaryStart;
        System.out.println("Binary Search Time: " + binaryTime + " nanoseconds");
    }

}