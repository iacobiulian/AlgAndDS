package ro.iim.algorithms;

public class ShellSort {
    static void shellSort(int[] arr) {
        int inner, outer;
        int temp;

        int h = 1; //find initial value of h
        while (h < arr.length) {
            h = h * 3 + 1;
        }

        while (h > 0) {

            //h-sort the array
            for (outer = h; outer < arr.length; outer++) {
                temp = arr[outer];
                inner = outer;


                //one subpass (e.g. 0,4,8)
                while (inner > h - 1 && arr[inner - h] >= temp) {
                    arr[inner] = arr[inner - h];
                    inner -= h;
                }
                arr[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }

    public static void main(String[] args) {
        int[] a = TestUtils.getRandomArray(7, 99);

        TestUtils.displayIntArray(a);

        shellSort(a);

        TestUtils.displayIntArray(a);
    }
}
