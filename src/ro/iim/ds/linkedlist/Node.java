package ro.iim.ds.linkedlist;

class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    public void display() {
        System.out.println(data);
    }
}