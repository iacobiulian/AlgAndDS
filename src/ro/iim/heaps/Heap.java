package ro.iim.heaps;

public class Heap {
    //Representing a tree as an array
    //For a node at index x
    //Parent is (x-1)/2
    //Left child is 2*x+1
    //Right child is 2*x+2

    Node[] heapArray;
    int arraySize;
    int currentSize;

    public Heap(int arraySize) {
        this.arraySize = arraySize;
        this.heapArray = new Node[arraySize];
        this.currentSize = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    private void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];

        while (index > 0 &&
                heapArray[parent].getKey() < bottom.getKey()) {
            heapArray[index] = heapArray[parent]; //move node up
            index = parent; //move index up
            parent = (parent - 1) / 2; //parent <- its parent
        }

        heapArray[index] = bottom;
    }

    private void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];
        //while node has at least 1 child
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            //find larger child
            if (rightChild < currentSize && /*rightChild exists?*/
                    heapArray[leftChild].getKey() < heapArray[rightChild].getKey())
                largerChild = rightChild;
            else
                largerChild = leftChild;

            //top >= largerChild
            if (top.getKey() >= heapArray[largerChild].getKey())
                break;

            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top; //index <- root
    }


    public boolean insert(int key) {
        if (currentSize == arraySize)
            return false;

        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize);
        currentSize++;
        return true;
    }

    //delete item with max key
    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize]; //root <- last
        trickleDown(0);
        return root;
    }

    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize) {
            return false;
        }

        int oldValue = heapArray[index].getKey(); //remember old
        heapArray[index].setKey(newValue);

        if (oldValue < newValue)
            trickleUp(index);
        else
            trickleDown(index);

        return true;
    }

    public void displayHeap() {
        System.out.println("Heap array");
        for (int i = 0; i < arraySize; i++) {
            if (heapArray[i] != null)
                System.out.println(heapArray[i].getKey());
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(20);
        heap.insert(11);
        heap.insert(21);
        heap.insert(31);
        heap.insert(41);
        heap.insert(15);
        heap.insert(13);
        heap.displayHeap();
    }
}
