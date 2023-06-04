package GraphFramework;

import PhoneNetworkApp.BluePrGraph;
import java.util.*;

public class KruskalAlg extends MSTAlgorithm {
    int theCost = 0;
    Map<String, List<String>> setOfvertix = new HashMap<>(); //create hashmap to create subsets of vertices 
    ArrayList<Edge> edgesArr = new ArrayList<>(); //create arraylist to store all edges in ascending order 

    public KruskalAlg(BluePrGraph graphObj) {
        ListMSTresult = new LinkedList<>(); // MST List to stor MST 
    }

    // ----------------------------------------------------------------------
    
    // make groups with one vertex.
    public void singleton(String info){ 
        List<String> subset = new ArrayList<>(); //create a new subset
        subset.add(info); //add the vertex to the subset
        setOfvertix.put(info, subset); //add the subset to the hashmap
    }

    public void addEdgeArr(Graph graphObj) {
        int size = graphObj.verticesNo - 1;
        for(int i = 0; i < size; i++){ //all vertices 
            for (Edge edgeObj : graphObj.vertices.get(i).getAdjList()) { //all vertex adjaceny list 
                edgesArr.add(edgeObj); 
            } //add each edge to the arraylist 
        }
    }

    public String findSet(String data){
        for (String key : setOfvertix.keySet()) { //iterate over all subsets
            List<String> subset = setOfvertix.get(key); //get the subset
            if (subset.contains(data)) { //check if the vertex is in the subset
                return key; //return the subset label
            }
        }
        return null; //return null if subset not found
    }

    public void union(String vertex1, String vertex2){
        List<String> subset1 = setOfvertix.get(vertex1); //get subset 1
        List<String> subset2 = setOfvertix.get(vertex2); //get subset 2
        subset1.addAll(subset2); //combine the subsets
        for (String vertex : subset2) { //iterate over vertices in subset 2
            setOfvertix.put(vertex, subset1); //update the subsets of each vertex
        }
    }

    // ----------------------------------------------------------------------
    
    // Find Minimum Spanning Tree using Kruskal's Algorithm.
    @Override
    public void doMST(Graph graph) {
        addEdgeArr(graph);  //add the edge in the  Array
        Collections.sort(edgesArr);//use Collections.sort to sort the edges

        for (Vertex vertex : graph.vertices) { //Create singletons of all vertices in my graph
            singleton(vertex.getLabel());
        }

        for (Edge edge : edgesArr) { //for all edges
            String root1 = findSet(edge.getSource().getLabel()); //find subset of vertex 1
            String root2 = findSet(edge.getDestination().getLabel()); //find subset of vertex 2
            if (root1.equals(root2)) { //If vertices are in the same subset then don't add edge
                 
            }
            else { // If vertices are in different subsets then add the edge to result and union these two subsets into one.
                ListMSTresult.add(edge); //add in MST
                theCost += edge.getWeight(); //add to total cost
                union(root1, root2); //create union between subsets
              
            }
        }
    }
    
    // ----------------------------------------------------------------------

    @Override
    public void displayResultingMST() {
        for (int i = 0; i < ListMSTresult.size(); i++) {
            ListMSTresult.get(i).displayInfo();
            System.out.println();
            
        }
        System.out.println();
        System.out.println("The cost of designed phone network: " + this.theCost); //total cost
    }
}
 