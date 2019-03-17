package ro.iim.ds.binarytree;

import java.nio.file.Paths;

public class BinaryTree {
    private Node root;

    public Node find(int key) {
        Node current = root;
        while (current.data != key) {
            if (key < current.data)
                current = current.leftChild;
            else
                current = current.rightChild;

            if (current == null)
                return null;
        }

        return current;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (data < current.data) { //go left
                    current = current.leftChild;
                    if (current == null) { //end of the line
                        parent.leftChild = newNode;
                        return;
                    }
                } else { //go right
                    current = current.rightChild;
                    if (current == null) { //end of the line
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void delete(int id) {

    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.leftChild);

            root.displayNode();

            inOrder(root.rightChild);
        }
    }

    public void traversalInOrder() {
        inOrder(this.root);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(50);
        binaryTree.insert(25);
        binaryTree.insert(75);

        Node found = binaryTree.find(25);
        if (found != null)
            found.displayNode();
        else
            System.out.println("Can not find node");
    }
}
