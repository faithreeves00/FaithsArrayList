// File/Class Name: FaithsArrayList.java
// Author: Faith Reeves
// Class Purpose: used with "MyArrayList.java" to create a data array that can
//                expanded, added to and removed from. Values can also be changed
//                to uppercase and have their index found

package myarraylist;

import java.util.Arrays;

public class FaithsArrayList<E> {

    // declare the initial default capacity
    private static final int INITIAL_CAPACITY = 10;

    // the underlying data array
    private E[] theData;

    // the current size
    private int size = 0;

    // the current capacity
    private int capacity = 0;

    // removes compiler warnings
    @SuppressWarnings("unchecked")

    // constructor for class FaithsArrayList
    public FaithsArrayList() {

        // set the capacity to the initial default value of 10
        capacity = INITIAL_CAPACITY;

        // allocate storage for data array
        theData = (E[]) new Object[capacity];
    }

    // method to append a new item to the array list
    public boolean add(E anEntry) {

        // if the size and capacity are equal, execute the if statement
        if (size == capacity) {

            // call the reallocate method
            reallocate();
        }

        // insert the new item at the position indicated by the value of size
        theData[size] = anEntry;

        // increment the size variable
        size++;

        // return true to show that the item was inserted successfully
        return true;
    }

    // method that creates a new array twice the size of the current array and
    // copies the old items into the new array
    private void reallocate() {

        // increase the capacity variable
        capacity = (int) (capacity + (capacity * 1.5));

        // copy the old array items into the new larger array
        theData = Arrays.copyOf(theData, capacity);
    }

    // method to remove elements from the array list
    public boolean remove(Comparable<E> word) {

        // find the index of the users word
        int index = indexOf(word);

        // if the index is -1, return false
        if (index == -1) {
            return false;
        }

        // iterate throught the loop for every element after the removed word
        for (int i = index + 1; i < size; i++) {

            // move elements that follow the removed word forward to close up the space
            theData[i - 1] = theData[i];
        }

        // decrement the size variable
        size--;

        return true;
    }

    // method used to set a word to upper-case
    public E set(int index, E newValue) {

        // replace the old word with the upper-case version
        theData[index] = newValue;

        // return the upper-case word
        return theData[index];
    }

    // override the toString() method
    @Override
    public String toString() {

        // create an empty string to store the results
        String results = "";

        // iterate through every element in theData
        for (E element : theData) {

            // if an element is null, execute the if statement
            if (element == null) {

                // break out of the loop
                break;
            }

            // add each element to the results string
            results += element;

            // add a space in between each word
            results += " ";
        }

        // return the results string
        return results;
    }

    // method to find the index of a word in the array list
    public int indexOf(Comparable<E> target) {

        // set the default index to -1
        int answer = -1;

        // loop through each element of the array list
        for (int i = 0; i < size; i++) {

            // if the word matches an array list element, execute the statement
            if (target.compareTo(theData[i]) == 0) {

                // set the answer variable to the current i counter
                answer = i;
            }
        }
        // return the index
        return answer;
    }
}
