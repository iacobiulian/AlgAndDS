package ro.iim.ds.linkedlist;

public class SortedLinkedList extends LinkedList {
    //easy to access min/max (depending how it's sorted)

    @Override
    public void insertFirst(String data) {
        Node newNode = new Node(data);
        Node prev = null;
        Node current = this.first;

        while (current!=null && current.data.compareTo(data) < 0) {
            prev = current;
            current = current.next;
        }

        if(prev==null) {
            this.first = newNode;
        } else {
            prev.next = newNode;
        }
        newNode.next = current;
    }
}
