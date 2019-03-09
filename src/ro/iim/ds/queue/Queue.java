package ro.iim.ds.queue;

public class Queue {

    QNode front, rear;

    public Queue(int queueSize) {
        this.front = this.rear = null;
    }

    public void insert(String input) {

        QNode temp = new QNode(input);

        if (isEmpty()) {
            this.front = this.rear = temp;
        } else {
            this.rear.next = temp;
            this.rear = temp;
        }

        System.out.println("Item added to the queue");
    }

    public String remove() {
        if (isEmpty()) {
            System.out.println("Queue empty");
            return null;
        }

        String temp = this.front.data;
        this.front = this.front.next;

        if (this.front == null) {
            this.rear = null;
        }

        return temp;
    }

    public String peekFront() {
        return this.front.data;
    }

    public String peekRear() {
        return this.rear.data;
    }

    public boolean isEmpty() {
        return (this.front == null);
    }

    public void displayQueue() {
        QNode temp = this.front;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}
