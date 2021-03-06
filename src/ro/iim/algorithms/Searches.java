package ro.iim.algorithms;

public class Searches {

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
    public static int binarySearchIterative(int[] arr, int value) {
        int lowIndex = 0;
        int highIndex = arr.length - 1;

        while (lowIndex <= highIndex) {
            //int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
            int middleIndex = (lowIndex + highIndex) / 2;

            if (arr[middleIndex] == value)
                return middleIndex;

            if (arr[middleIndex] < value)
                lowIndex = middleIndex + 1;
            else if (arr[middleIndex] > value)
                highIndex = middleIndex - 1;
        }

        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int value) {
        return bsrImplementation(arr, value, 0, arr.length - 1);
    }

    private static int bsrImplementation(int[] arr, int value, int lowIndex, int highIndex) {
        if (lowIndex > highIndex)
            return -1;

        int middleIndex = (lowIndex + highIndex) / 2;
        if (value == arr[middleIndex]) {
            return middleIndex;
        }

        if (value > arr[middleIndex]) {
            return bsrImplementation(arr, value, middleIndex + 1, highIndex);
        } else {
            return bsrImplementation(arr, value, lowIndex, middleIndex - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 7, 8, 3, 4, 2, 8, 1, 2, 4, 7};
        int[] sortedA = {4, 6, 8, 9, 11, 13, 14, 16, 18, 2};

        Searches.linearSearch(a, 66);
        System.out.println(Searches.binarySearchRecursive(sortedA, 11));

        TestUtils.displayStars();
    }
}
