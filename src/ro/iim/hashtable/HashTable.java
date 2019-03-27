package ro.iim.hashtable;

public class HashTable {

    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem; //for deleted items

    public HashTable(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1); //deleted item key is -1
    }

    public void displayTable() {
        System.out.println("*** Table: ***");
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null)
                System.out.print(hashArray[i].getKey() + " ");
            else
                System.out.print(" null ");
        }
    }

    public void insert(DataItem item) {
        int hashVal = hashFunction(item.getKey());
        int stepSize = reHashFunction(item.getKey());

        while (hashArray[hashVal] != null &&
                hashArray[hashVal].getKey() != -1) {
            hashVal += stepSize;
            hashVal %= arraySize;
        }

        hashArray[hashVal] = item;
    }

    public boolean delete(int key) {
        int hashVal = hashFunction(key);
        int stepSize = reHashFunction(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                hashArray[hashVal] = nonItem;
                return true;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return false;
    }

    public DataItem find(int key) {
        int hashVal = hashFunction(key);
        int stepSize = reHashFunction(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];
            hashVal += stepSize;
            hashVal %= arraySize;
        }

        return null;
    }

    private int hashFunction(int key) {
        return key % arraySize;
    }

    //Second hash function to deal with collisions
    //Form of stepSize = constant - (key % constant)
    //constant is prime and < arraySize
    //must not return 0
    private int reHashFunction(int key) {
        return 5 - (key % 5);
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(13);
        hashTable.insert(new DataItem(1));
        hashTable.insert(new DataItem(2));
        hashTable.insert(new DataItem(3));
        hashTable.insert(new DataItem(4));
        hashTable.insert(new DataItem(5));
        hashTable.insert(new DataItem(2));
        hashTable.displayTable();
    }
}
