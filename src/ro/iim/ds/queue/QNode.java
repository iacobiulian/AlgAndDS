package ro.iim.ds.queue;

class QNode {
    String data;
    QNode next;

    public QNode(String data) {
        this.data = data;
        this.next = null;
    }
}
