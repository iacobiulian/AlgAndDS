package ro.iim.algorithms;

import java.util.concurrent.TimeUnit;

public class QuickSort {

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int partition(int[] arr, int left, int right, int pivot) {
        int leftPtr = left - 1;
        int rightPtr = right - 1;

        while (true) {
            //move leftPtr to the right until you
            //find a value bigger than the pivot
            while (leftPtr < right && arr[++leftPtr] < pivot)
                ;

            //move rightPtr to the left until you
            //find a value lower than the pivot
            while (rightPtr > left && arr[--rightPtr] > pivot)
                ;

            //if leftPtr and rightPtr meet stop
            // the array is already partitioned
            if (leftPtr >= rightPtr)
                break;
            else
                swap(arr, leftPtr, rightPtr);
        }
        return leftPtr;
    }

    static int partition2(int[] arr, int left, int right, int pivot) {
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

    static void quickSort2(int[] arr, int left, int right) {
        if (right - left <= 0)
            return;
        else {
            int pivot = arr[right];
            int partition = partition2(arr, left, right, pivot);
            quickSort2(arr, left, partition - 1);
            quickSort2(arr, partition + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] a = TestUtils.getRandomArray(12, 50);
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++)
            b[i] = a[i];
//        TestUtils.displayIntArray(a);
//        TestUtils.displayStars();
//        partition(a, 0, a.length - 1, 250);
        TestUtils.displayIntArray(a);
        TestUtils.displayIntArray(b);

        long startTime = System.nanoTime();
        quickSort(a, 0, a.length - 1);
        long endTime = System.nanoTime();

        TestUtils.displayStars();
        TestUtils.displayIntArray(a);


        long duration = (endTime - startTime);
        TestUtils.displayStars();
        System.out.println("My alg duration: " + duration);
        TestUtils.displayStars();
        long startTime2 = System.nanoTime();
        quickSort2(b, 0, a.length - 1);
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2);
        System.out.println("Prof alg duration: " + duration2);

    }
}
