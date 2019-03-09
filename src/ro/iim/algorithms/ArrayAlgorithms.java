package ro.iim.algorithms;

public class ArrayAlgorithms {

    public static int[] insertionSortCresc(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            //the element we try to put in its rightful place
            int key = arr[i];

            //Move elements of arr[0..i-1], that are
            //greater than key, one position to the right
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    //O(n)
    public static void linearSearch(int[] arr, int value) {
        String foundAtIndex = "Item found at indexes [ ";
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                found = true;
                foundAtIndex += i;
                foundAtIndex += ", ";
            }
        }

        if (found) {
            foundAtIndex += "]";
        } else {
            foundAtIndex = "Item not found";
        }
        System.out.println(foundAtIndex);
    }

    //O(logN)
    //only for sorted arrays
    //returns the index of the found item
    public static int binarySearch(int[] arr, int value) {
        int lowIndex = 0;
        int highIndex = arr.length - 1;

        while (lowIndex <= highIndex) {
            int middleIndex = lowIndex + (highIndex - lowIndex) / 2;

            if (arr[middleIndex] == value)
                return middleIndex;

            if (arr[middleIndex] < value)
                lowIndex = middleIndex + 1;
            else if (arr[middleIndex] > value)
                highIndex = middleIndex - 1;
        }

        return -1;
    }
}
