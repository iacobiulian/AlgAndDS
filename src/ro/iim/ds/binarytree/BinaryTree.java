package ro.iim.ds.binarytree;

import ro.iim.algorithms.TestUtils;

import java.nio.file.Paths;

import static ro.iim.algorithms.TestUtils.displayStars;

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

    public void delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        //Find the node and its parent
        while (current.data != key) {
            parent = current;
            if (key < current.data) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                System.out.println("Node not found");
                return;
            }
        }

        //1. It is a leaf
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
            //2. Only 1 child
        } else if (current.rightChild == null) { //No right child
            if (current == root) //Root special case
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        } else if (current.leftChild == null) { //No left child
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
            //3. Has both children
        } else {
            Node successor = getSuccessor(current);

            //Connect parent of current to successor instead
            if(current == root)
                root = successor;
            else if(isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;

            //Connect successor to current's left child
            //Remember successor has no left child to begin with
            successor.leftChild = current.leftChild;
        }
    }

    //https://i.imgur.com/q8YNdSY.png
    private Node getSuccessor(Node deletedNode) {
        Node successorparent = deletedNode;
        Node successor = deletedNode;
        Node current = deletedNode.rightChild;

        while (current.leftChild != null) {
            successorparent = successor;
            successor = current;
            current = current.leftChild;
        }

        //Remember successor has NO leftChild
        //https://i.imgur.com/rzWDgOx.png
        if(successor != deletedNode.rightChild) {
            successorparent.leftChild = successor.rightChild;
            successor.rightChild = deletedNode.rightChild;
        }

        return successor;
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

    public Node minimum() {
        Node current = root;

        while (current.leftChild != null) {
            current = current.leftChild;
        }

        return current;
    }

    public Node maximum() {
        Node current = root;

        while (current.rightChild != null) {
            current = current.rightChild;
        }

        return current;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(50);
        binaryTree.insert(25);
        binaryTree.insert(75);
        binaryTree.insert(55);
        binaryTree.insert(11);
        binaryTree.insert(73);
        binaryTree.insert(52);
        binaryTree.insert(20);
        binaryTree.insert(70);

        Node found = binaryTree.find(25);
        if (found != null)
            found.displayNode();
        else
            System.out.println("Can not find node");

        binaryTree.traversalInOrder();

        displayStars();

        binaryTree.minimum().displayNode();

        displayStars();

        binaryTree.maximum().displayNode();
    }
}
