package ro.iim.algorithms;

import java.util.concurrent.TimeUnit;

import static ro.iim.algorithms.TestUtils.displayIntArray;
import static ro.iim.algorithms.TestUtils.displayStars;

public class QuickSort {
    /*
    N^2 worst case
    N*logN average case
     */

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int partition(int[] arr, int left, int right, int pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;

        while (true) {
            //move leftPtr to the right until you
            //find a value bigger than the pivot
            while (arr[++leftPtr] < pivot)
                ;

            //move rightPtr to the left until you
            //find a value lower than the pivot
            while (rightPtr > 0 && arr[--rightPtr] > pivot)
                ;

            //if leftPtr and rightPtr meet stop
            // the array is already partitioned
            if (leftPtr >= rightPtr)
                break;
            else
                swap(arr, leftPtr, rightPtr);
        }
        /*
        Because the pivot is arr[last element index] we have to put the pivot
        in its correct place after we are done partitioning
        More here /watch?v=Hoixgm4-P4M
         */
        swap(arr, leftPtr, right);
        return leftPtr;
    }

    static void quickSort(int[] arr, int left, int right) {
        if (right - left <= 0)
            return;
        else {
            int pivot = arr[right];
            int partition = partition(arr, left, right, pivot);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
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
