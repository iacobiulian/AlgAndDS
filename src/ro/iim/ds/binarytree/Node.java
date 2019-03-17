package ro.iim.ds.binarytree;

public class Node {
    int data;
    Node leftChild;
    Node rightChild;

    public Node(int data) {
        this.data = data;
    }

    public void displayNode() {
        System.out.println(data);
    }
}
