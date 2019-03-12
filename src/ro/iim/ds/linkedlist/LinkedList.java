package ro.iim.ds.linkedlist;

import ro.iim.algorithms.TestUtils;

public class LinkedList {

    protected Node first;

    public LinkedList() {
        this.first = null;
    }

    public boolean isEmpty() {
        return (this.first == null);
    }

    public void insertFirst(String data) {
        Node newNode = new Node(data);
        newNode.next = this.first;
        this.first = newNode;
    }

    public void insertAfter(String data, String after) {
        Node newNode = new Node(data);
        Node insertAfter = findLink(after);
        if (insertAfter == null) {
            System.out.println(after + " No such link");
            return;
        }

        newNode.next = insertAfter.next;
        insertAfter.next = newNode;
    }

    public String removeFirst() {
        String data = this.first.data;
        this.first = this.first.next;
        return data;
    }

    public void removeLink(String data) {
        Node current = this.first;
        Node previousLink = this.first;

        while (current != null) {
            if (current.data.equals(data)) {
                previousLink.next = current.next;
                return;
            }
            previousLink = current;
            current = current.next;
        }

    }

    public Node findLink(String data) {
        Node current = this.first;
        while (current != null) {
            if (current.data.equals(data))
                return current;
            current = current.next;
        }

        return null;
    }

    public void displayLinkedList() {
        Node temp = this.first;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.displayLinkedList();
        linkedList.insertFirst("Tim");
        linkedList.insertFirst("Billy");
        linkedList.insertFirst("Mandy");
        linkedList.insertFirst("Ursa");
        linkedList.insertFirst("Tony");
        //linkedList.displayLinkedList();

        linkedList.insertAfter("Hector", "Ursa");
        //TestUtils.displayStars();
        linkedList.displayLinkedList();
        TestUtils.displayStars();

        ListIterator listIterator = new ListIterator(linkedList);
        while (listIterator.getCurrent() != null) {
            listIterator.getCurrent().display();
            listIterator.nextLink();
        }

        TestUtils.displayStars();

        listIterator.reset();
        listIterator.nextLink();
        listIterator.nextLink();
        listIterator.getCurrent().display();
        listIterator.insertBefore("Soprano");
        TestUtils.displayStars();
        listIterator.reset();
        while (listIterator.getCurrent() != null) {
            listIterator.getCurrent().display();
            listIterator.nextLink();
        }

        TestUtils.displayStars();

        linkedList.displayLinkedList();

    }
}
