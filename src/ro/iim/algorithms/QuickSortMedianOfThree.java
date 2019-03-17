package ro.iim.algorithms;

import static ro.iim.algorithms.TestUtils.displayIntArray;
import static ro.iim.algorithms.TestUtils.displayStars;

public class QuickSortMedianOfThree {
    /*
    N^2 worst case
    N*logN average case
     */

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int medianOfThree(int[] arr, int left, int right) {
        int center = (left + right) / 2;

        if (arr[left] > arr[center])
            swap(arr, left, center);

        if (arr[left] > arr[right])
            swap(arr, left, right);

        if (arr[center] > arr[right])
            swap(arr, center, right);

        swap(arr, center, right - 1); //put pivot on right
        return arr[right - 1]; //return median
    }

    static int partition(int[] arr, int left, int right, int pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;

        while (true) {
            //move leftPtr to the right until you
            //find a value bigger than the pivot
            while (arr[++leftPtr] < pivot)
                ;

            //move rightPtr to the left until you
            //find a value lower than the pivot
            while (arr[--rightPtr] > pivot)
                ;

            //if leftPtr and rightPtr meet stop
            // the array is already partitioned
            if (leftPtr >= rightPtr)
                break;
            else
                swap(arr, leftPtr, rightPtr);
        }
        swap(arr, leftPtr, right - 1); //Put pivot in its rightful place
        return leftPtr;
    }

    static void quickSort(int[] arr, int left, int right) {
        if (right - left + 1 <= 3)
            manualSort(arr, left, right);
        else {
            int pivot = medianOfThree(arr, left, right);
            int partition = partition(arr, left, right, pivot);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
    }

    /*
    Median of 3 works on arrays with size 4 and above
    Instead of manual sorting we can use insertion sort on arrays < 10ish length
     */
    static void manualSort(int[] arr, int left, int right) {
        int size = right - left + 1;
        if (size <= 1) //no sort needed
            return;
        if (size == 2) { //2-sort the array
            if (arr[left] > arr[right])
                swap(arr, left, right);
            return;
        } else { //size is 3 so we 3-sort left right and center
            if (arr[left] > arr[right - 1])
                swap(arr, left, right - 1);
            if (arr[left] > arr[right])
                swap(arr, left, right);
            if (arr[right - 1] > arr[right])
                swap(arr, right - 1, right);
        }
    }

    static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] a = TestUtils.getRandomArray(12, 50);
        displayIntArray(a);
        displayStars();
        quickSort(a);
        displayIntArray(a);
        displayStars();
    }
}
