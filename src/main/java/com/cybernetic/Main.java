//Work done by Student Name: Benjamin Gallegos
package com.cybernetic;

import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        //Random Object for inserting ints into array for analyzing
        Random random = new Random();

        //variable for choosing size indicator for array
        //changes per testing of algorithms
        int arraySize = 10;

        //Array used for analyzing six algorithms
        int[] array = new int[arraySize];

        //using a loop to fill in array based on size indicator
        for(int i = 0; i < array.length; i++)
        {
            array[i] = random.nextInt(10);
        }

        //outputting the array to be analyzed
        System.out.println("Array to be analyzed: ");
        for(int x : array)
        {
            System.out.print(x + " ");
        }
        System.out.println();

        //testing merge sort
        System.out.println("Merge Sort: ");
        Sorting.mergeSort(array);
        for(int x : array)
        {
            System.out.print(x + " ");
        }

    }
}