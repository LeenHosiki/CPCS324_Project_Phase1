 package GraphFramework;

import java.util.*;

// A class representing a minimum heap data structure.
 class MinHeap {

    private final Map<String, Integer> WeightOfvertex;
    private String[] vertexKeys;

    // Constructs a new MinHeap with the given vertex weights.
    public MinHeap(Map<String, Integer> vertexWeights) {
        this.WeightOfvertex = vertexWeights;
        this.vertexKeys = vertexWeights.keySet().toArray(new String[0]);
        makeHeap();
    }

    // ----------------------------------------------------------------------
    
    // Returns the weight of the given vertex.
    public int getWeight(String vertex) {
        return WeightOfvertex.get(vertex);
    }
    
       //Returns true if the min heap is empty.
    public boolean Empty() {
        return vertexKeys.length == 0;
    }
    
    // ----------------------------------------------------------------------
    
    private void heapify(int root, int length) {
        int min = root;
        int leftSide = 2 * root + 1;// the left side
        int rightSide = 2 * root + 2;

        if (rightSide < length && WeightOfvertex.get(vertexKeys[rightSide]) < WeightOfvertex.get(vertexKeys[min])) {
            min = rightSide;
        }   if (leftSide < length && WeightOfvertex.get(vertexKeys[leftSide]) < WeightOfvertex.get(vertexKeys[min])) {
            min = leftSide;
        }

        if (min != root) {
            swap(root, min);
            heapify(min, length);
        }
    }

    public void makeHeap() {
        int length = vertexKeys.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(i, length);
        }
    }

    //Updates the weight of a vertex and re-heapifies the min heap.
    public void updateWeight(String vertex, int weight) {
        WeightOfvertex.put(vertex, weight);
        makeHeap();
    }

    //Removes and returns the vertex with the smallest weight from the min heap.
     public String deleteMin() {
        String min = vertexKeys[0];//take the vertix in the root
        int length = vertexKeys.length;
        vertexKeys[0] = vertexKeys[length - 1];
        vertexKeys = Arrays.copyOf(vertexKeys, length - 1);
        heapify(0, length - 1);
        WeightOfvertex.remove(min);//delete the root
        return min;
    }
    
    // Returns true if the given vertex is in the min heap.
     public boolean containsVertex(String vertex) {
        return WeightOfvertex.containsKey(vertex);
    }
    
    //Swaps the positions of two vertices in the vertexKeys array.
    private void swap(int i, int j) {
        String temp = vertexKeys[i];
        vertexKeys[i] = vertexKeys[j];
        vertexKeys[j] = temp;
    }
}

 