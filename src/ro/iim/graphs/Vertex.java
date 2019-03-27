package ro.iim.graphs;

public class Vertex {
    public char label; //ex. A, B, C, etc..
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        wasVisited = false;
    }
}
