package ro.iim.ds.linkedlist;

public class DNode {
    String data;
    DNode prev;
    DNode next;

    public DNode(String data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public void display() {
        System.out.println(this.data);
    }
}
