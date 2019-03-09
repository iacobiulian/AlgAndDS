package ro.iim.ds.linkedlist;

public class LinkedList {

    private Node first;

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

    public String removeFirst() {
        String data = this.first.data;
        this.first = this.first.next;
        return data;
    }

    public void removeLink(String data) {
        Node current = this.first;
        Node previousLink = this.first;

        while (current != null) {
            if (current.data == data) {
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
            if (current.data == data)
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

    public void displayNode(Node node) {
        if (node == null) {
            System.out.println("Node null");
            return;
        }

        System.out.println(node.data);
    }
}
