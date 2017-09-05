package main;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * Sorts a list of values by ascii value, descending order
 * @author Jack L. Clements
 */
public class ValuesSort {

    public static void main(String[] args) {
        //String comparator
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String t1, String t2) {
                int valuea = 0;
                int valueb = 0;
                for (char c : t1.toCharArray()) {
                    valuea += (int) c;
                }

                for (char c : t2.toCharArray()) {
                    valueb += (int) c;
                }

                if (valuea < valueb) { //if A is less than B, return true, this allows for a reverse/decreasing sort
                    return 1;
                } else if (valuea == valueb) {
                    return 0;
                } else {
                    return -1;
                }
            }
        };

        //Strings to sort
        String[] strings = {"Relentless Commitment to Impact", "Robust as Fudge", "Be Surprisingly Bold", "Get Back Up", "Make it Happen", "Don't be a Jerk", "Confront the Grey", "Laugh Together, Grow Together"};
        //quicksort(strings, 0, strings.length - 1, comp);
        Arrays.sort(strings, comp); //have written own method below, but this works faster
        //print
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }

    }
   
    /**
     * Entry point for recursive quicksort
     * @param array array to sort
     * @param left left pointer
     * @param right right pointer
     * @param comp comprator obj
     * @return 
     */
    public static String[] quicksort(String[] array, int left, int right, Comparator<String> comp) {
        int p = partition(array, left, right, comp);
        if (left < p - 1) {
            quicksort(array, left, p - 1, comp);
        }
        if (p < right) {
            quicksort(array, p, right, comp);
        }
        return array;
    }

    /**
     * In-place partitioning, swaps values when higher/lower than pivot val
     *
     * @param array whole array object memory loc
     * @param start start point
     * @param end end point
     * @param comp comparator
     * @return left pointer
     */
    public static int partition(String[] array, int start, int end, Comparator<String> comp) {
        int left = start, right = end;
        String pivot = array[(start + end)/2]; //choose middle pivot
        while (left <= right) {
            while (comp.compare(array[left], pivot) == -1) {
                left++;
            }
            while (comp.compare(array[right], pivot) == 1) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }

        return left;
    }
    /**
     * Swaps two values in array memory
     * @param array array memory loc.
     * @param e1 value 1 location in array
     * @param e2 value 2 location in array
     */
    public static void swap(String[] array, int e1, int e2) {
        String temp = array[e1];
        array[e1] = array[e2];
        array[e2] = temp;
    }

}
