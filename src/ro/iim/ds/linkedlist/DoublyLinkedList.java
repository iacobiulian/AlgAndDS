package ro.iim.ds.linkedlist;

import ro.iim.algorithms.TestUtils;

public class DoublyLinkedList {
    DNode first;
    DNode last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (this.first == null);
    }

    public void insertFirst(String data) {
        DNode newNode = new DNode(data);
        if (isEmpty()) {
            this.first = this.last = newNode;
            return;
        }

        this.first.prev = newNode;
        newNode.next = this.first;
        this.first = newNode;
    }

    public void insertLast(String data) {
        DNode newNode = new DNode(data);
        if (isEmpty()) {
            this.first = this.last = newNode;
            return;
        }

        this.last.next = newNode;
        newNode.prev = this.last;
        this.last = newNode;
    }

    public void insertAfter(String data, String after) {
        DNode newNode = new DNode(data);
        DNode insertAfter = findLink(after);

        if (insertAfter == null) {
            System.out.println(after + " No such node");
            return;
        }

        if (insertAfter == this.last) {
            insertLast(data);
            return;
        }

        newNode.next = insertAfter.next;
        newNode.prev = insertAfter;
        insertAfter.next.prev = newNode;
        insertAfter.next = newNode;
    }

    public void removeFirst() {
        if (isEmpty())
            return;

        if (first == last) {
            first = last = null;
            return;
        }

        this.first.next.prev = null;
        this.first = this.first.next;
    }

    public void removeLast() {
        if (isEmpty())
            return;

        if (first == last) {
            first = last = null;
            return;
        }

        this.last.prev.next = null;
        this.last = this.last.prev;
    }

    public void removeNode(String data) {
        DNode removedNode = findLink(data);
        if (removedNode == null) {
            System.out.println(data + " No such node");
            return;
        }
        removedNode.prev.next = removedNode.next;
        removedNode.next.prev = removedNode.prev;
    }

    public DNode findLink(String data) {
        DNode current = this.first;
        while (current != null) {
            if (current.data.equals(data))
                return current;

            current = current.next;
        }

        return null;
    }

    public void displayList() {
        DNode current = this.first;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }

    public void displayListReverse() {
        DNode current = this.last;
        while (current != null) {
            current.display();
            current = current.prev;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.displayList();
        linkedList.insertFirst("Marcus");
        linkedList.insertFirst("Dominic");
        linkedList.insertLast("Skinner");
        linkedList.insertFirst("Elsa");
        linkedList.insertFirst("Jack");
        linkedList.displayList();

        linkedList.removeNode("Dominic");
        linkedList.insertAfter("Hector", "Skinner");
        linkedList.removeFirst();
        linkedList.removeLast();
        TestUtils.displayStars();
        linkedList.displayList();
        TestUtils.displayStars();
    }
}
