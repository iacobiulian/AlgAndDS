package ro.iim.algorithms;

public class MergeSort {

    public static void mergeTwoArrays(int[] arrC, int[] arrA, int[] arrB) {
        int aCounter = 0;
        int bCounter = 0;
        int cCounter = 0;

        //copy each element in order
        while (aCounter < arrA.length && bCounter < arrB.length) {
            if (arrA[aCounter] < arrB[bCounter]) {
                arrC[cCounter++] = arrA[aCounter++];
            } else {
                arrC[cCounter++] = arrB[bCounter++];
            }
        }

        //B empty. A not empty
        while (aCounter < arrA.length) {
            arrC[cCounter++] = arrA[aCounter++];
        }

        //A empty. B not empty
        while (bCounter < arrB.length) {
            arrC[cCounter++] = arrB[bCounter++];
        }
    }

    public static void mergeSort(int[] arr, int arrLength) {
        if (arrLength < 2) {
            return;
        }
        int mid = arrLength / 2;
        int[] l = new int[mid];
        int[] r = new int[arrLength - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int i = mid; i < arrLength; i++) {
            r[i - mid] = arr[i];
        }
        mergeSort(l, mid);
        mergeSort(r, arrLength - mid);

        mergeTwoArrays(arr, l, r);
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 7, 8, 3, 4, 2, 8, 1, 2, 4, 7};
        int[] sortedA = {4, 6, 8, 9, 11, 13, 14, 16, 18, 2};


        int[] actual = {5, 1, 22, -11, 6, 2, 45, 3, 4, 0};
        int[] expected = {-11, 0, 1, 2, 3, 4, 5, 6, 22, 45};
        MergeSort.mergeSort(actual, actual.length);

        TestUtils.displayIntArray(actual);
        TestUtils.displayStars();
        TestUtils.displayIntArray(expected);
    }
}
