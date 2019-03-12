package ro.iim.ds.linkedlist;

public class ListIterator {
    private Node current;
    private Node previous;
    private LinkedList linkedList;

    public ListIterator(LinkedList linkedList) {
        this.linkedList = linkedList;
        reset();
    }

    public void reset() {
        current = linkedList.first;
        previous = null;
    }

    public Node getCurrent() {
        return this.current;
    }

    public boolean hasNext() {
        return (current.next != null);
    }

    public void nextLink() {
        previous = current;
        current = current.next;
    }

    public void insertAfter(String data) {
        if(linkedList.isEmpty()) {
            linkedList.insertFirst(data);
            return;
        }

        Node newNode =  new Node(data);
        newNode.next = current.next;
        current.next = newNode;
    }

    public void insertBefore(String data) {
        if(previous == null) {
            linkedList.insertFirst(data);
            return;
        }

        Node node =  new Node(data);

        node.next = current;
        previous.next = node;
    }

    public void deleteCurrent() {
        if(linkedList.isEmpty()) {
            return;
        }

        if(previous == null) {
            linkedList.removeFirst();
            reset();
            return;
        }

        previous.next = current.next;
        current = current.next;
    }
}
















