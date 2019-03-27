package ro.iim.graphs;

import sun.misc.Queue;

import java.util.Stack;

public class Graph {
    private final int MAX_VERTEXES = 20;
    private Vertex[] vertexList;
    private int[][] adjMatrix;
    private int nVertexes;

    public Graph() {
        vertexList = new Vertex[MAX_VERTEXES];
        adjMatrix = new int[MAX_VERTEXES][MAX_VERTEXES];
        nVertexes = 0;
        //set matrix to 0
        for (int i = 0; i < MAX_VERTEXES; i++)
            for (int j = 0; j < MAX_VERTEXES; j++)
                adjMatrix[i][j] = 0;
    }

    public void addVertex(char label) {
        vertexList[nVertexes++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }

    private int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVertexes; i++) {
            if (adjMatrix[v][i] == 1 && !vertexList[i].wasVisited)
                return i;
        }

        return -1;
    }

    //you go as far away from the start as you can
    public void dfs() {
        //visit starting point
        Stack<Integer> theStack = new Stack<>();
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()) {
            //get unvisited vertex adjacent to stack top
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) //if no such vertex
                theStack.pop();
            else {
                vertexList[v].wasVisited = true; //mark it
                displayVertex(v); //display it
                theStack.push(v); //push it
            }
        }

        //stack is empty so were done
        //reset flags
        for (Vertex v : vertexList)
            v.wasVisited = false;
    }

    //stay as close to the start as you can
    public void bfs() throws InterruptedException {
        Queue<Integer> theQueue = new Queue<>();
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.enqueue(0);
        int v2;

        while (!theQueue.isEmpty()) { //until queue is empty
            int v1 = theQueue.dequeue(); //remove vertex at head
            //until it has no unvisited neighbours
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) { //get one
                vertexList[v2].wasVisited = true; //mark it
                displayVertex(v2); //display it
                theQueue.enqueue(v2); //insert it
            }
        }

        //reset flags
        for (Vertex v : vertexList)
            v.wasVisited = false;
    }

    //Minimum spanning tree
    public void mst() {

    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex('A');
    }
}
