package ro.iim.algorithms;

import ro.iim.ds.linkedlist.LinkedList;

public class TestDrive {

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
        System.out.println("**********");
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 7, 8, 3, 4, 2, 8, 1, 2, 4, 7};
        int[] sortedA = {4, 6, 8, 9, 11, 13, 14, 16, 18, 21};

        //ArrayAlgorithms.linearSearch(a,66);
        //System.out.println(ArrayAlgorithms.binarySearch(sortedA, 4));

        LinkedList linkedList = new LinkedList();
        linkedList.displayLinkedList();
        linkedList.insertFirst("Tim");
        linkedList.insertFirst("Billy");
        linkedList.insertFirst("Mandy");
        linkedList.insertFirst("Ursa");
        linkedList.insertFirst("Tony");
        linkedList.displayLinkedList();

        linkedList.removeLink("Mandy");
        linkedList.removeLink("Billie");
        displayStars();
        linkedList.displayLinkedList();

    }
}
