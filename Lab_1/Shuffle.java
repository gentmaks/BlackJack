
/**
* Author: Gent Maksutaj
* 
* Checks if two arrays are equal to each other after shuffling
*/

import java.util.ArrayList;
import java.util.Random;

public class Shuffle {

    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> arr0 = new ArrayList<Integer>();
        ArrayList<Integer> arr1 = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            int tmpRand = random.nextInt(99);
            arr0.add(tmpRand);
            arr1.add(tmpRand);
            System.out.println(tmpRand);

        }
        System.out
                .println(
                        "\n###########################################################################################\n");

        for (int j = 0; j < arr0.size(); j++) {
            int x = arr0.get(j);
            System.out.println(x);
        }

        ArrayList<Integer> arr2 = arr0;
        System.out.println(arr1);
        System.out.println(arr2);
        System.out.println("arr0 == arr1: " + (arr0 == arr1) + "\narr1 == arr2: " + (arr1 == arr2) + "\narr2 == arr0: "
                + (arr2 == arr0));
        System.out.println("arr0.equals(arr1): " + (arr0.equals(arr1)) + "\narr1.equals(arr2): " + (arr1.equals(arr2))
                + "\narr2.equals(arr0): " + (arr2.equals(arr0)));

    }

}