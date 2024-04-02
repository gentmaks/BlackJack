/*
file name:      ShuffleTests.java
Authors:        Ike Lage & Max Bender & Allen Harper
last modified:  02/26/2024

Futher modified by Gent Maksutaj by implementing shuffling tests.

How to run:     java -ea ShuffleTests
*/

import java.util.ArrayList;
import java.util.Random;
import java.util.random.*;

public class ShuffleTests {

    public static void shuffleTestsLab() {
        // case 1: testing that the arrays before and after shuffle are not equal
        {
            // set up
            // Make an array of integers from 0 to 10
            ArrayList<Integer> arr0 = new ArrayList<Integer>();
            for (int i = 0; i < 10; i++) {
                arr0.add(i);
            }

            // Shuffle it and save the output as a new array
            DumbShuffle shuffle = new DumbShuffle();
            // ArrayList<Integer> newArr = shuffle.dumbShuffle(arr0);
            ArrayList<Integer> newArr = shuffle.dumbShuffle(arr0);

            // verify
            // Print the original and the shuffled arrays
            System.out.println("Original array is: " + arr0);
            System.out.println("The new array after shuffling is:" + newArr);

            // test
            // Assert that the original and new arrays aren't equal
            System.out.println("Original array is equal to the new array?  " + (arr0.equals(newArr)));
        }

        // Print that your tests have all passed!

    }

    public static void shuffleTestsReflection() {

        // creating the arrays
        Random generator = new Random();
        boolean equalReverse = true;

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arr.add(generator.nextInt(20));
        }
        DumbShuffle shuffle = new DumbShuffle();
        ArrayList<Integer> newArr = shuffle.smartShuffle(arr);

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != newArr.get(arr.size() - i - 1)) {
                equalReverse = false;
                break;
            }

        }

        if (equalReverse) {
            System.out.println("Your shuffling method has failed the test");
        } else {
            System.out.println("Your shuffling method has passed the test");
        }

        // This is where you will write your code for reflection question 1
    }

    public static void main(String[] args) {
        shuffleTestsReflection();
    }
}