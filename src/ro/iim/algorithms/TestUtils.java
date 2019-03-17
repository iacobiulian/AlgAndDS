package ro.iim.algorithms;

import ro.iim.ds.linkedlist.LinkedList;
import ro.iim.ds.linkedlist.SortedLinkedList;

import java.util.Random;

public class TestUtils {

    public static int[] getRandomArray(int size, int maxValue) {
        Random random = new Random();

        int[] theArray = new int[size];

        for (int i = 0; i < size; i++) {
            theArray[i] = random.nextInt(maxValue);
        }

        return theArray;
    }

    public static void displayIntArray(int[] arr) {
        System.out.print("[ ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.print("]");
    }

    public static void displayStringArray(String[] arr) {
        for (String item : arr) {
            System.out.println(item);
        }
    }

    public static void displayStars() {
        System.out.println();
        System.out.println("**********");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 7, 8, 3, 4, 2, 8, 1, 2, 4, 7};
        int[] sortedA = {4, 6, 8, 9, 11, 13, 14, 16, 18, 21};

        //Searches.linearSearch(a,66);
        //System.out.println(Searches.binarySearchIterative(sortedA, 4));
    }
}
