package GraphFramework;

import PhoneNetworkApp.BluePrGraph;
import java.util.*;

public class MHPrimAlg extends MSTAlgorithm {
    int theCost = 0;

    Map<String, Integer> vertexMap = new HashMap<>();
    Map<String, Edge> edgeMap = new HashMap<>();
    List<Edge> result;

    public MHPrimAlg(BluePrGraph graph) {
        ListMSTresult = new LinkedList<>();
    }
    
    // ----------------------------------------------------------------------

    public List<Edge> getEdges(Graph graph, String vertex) {
        List<Edge> edgeList = new LinkedList<>();
        Vertex vertexObj = graph.vertices.get(Integer.parseInt(vertex));
        return vertexObj.getAdjList();
    }

    // ----------------------------------------------------------------------
    
    @Override
    public void doMST(Graph graph) {
        String startVertex = "0";

        // Initialize vertexMap with infinity for all vertices
        for (Vertex vertex : graph.vertices) {
            vertexMap.put(vertex.getLabel(), Integer.MAX_VALUE);
        }
        vertexMap.put(startVertex, 0);

        // Initialize minHeap with start vertex
        MinHeap minHeap = new MinHeap(vertexMap);
        minHeap.updateWeight(startVertex, 0);

        // Process vertices until minHeap is empty
        while (!minHeap.Empty()) {
            String currentVertex = minHeap.deleteMin();
            Edge spanningTreeEdge = edgeMap.get(currentVertex);
            if (spanningTreeEdge != null) {
                theCost += spanningTreeEdge.getWeight();
                ListMSTresult.add(spanningTreeEdge);
            }

            // Process neighboring vertices
            for (Edge edge : getEdges(graph, currentVertex)) {
                Vertex adjacentVertex = edge.getDestination();
                String adjacentVertexLabel = adjacentVertex.getLabel();
                int weight = edge.getWeight();
                if (minHeap.containsVertex(adjacentVertexLabel) && minHeap.getWeight(adjacentVertexLabel) > weight) {
                    minHeap.updateWeight(adjacentVertexLabel, weight);
                    edgeMap.put(adjacentVertexLabel, edge);
                }
            }
        }
    }
    
    // ----------------------------------------------------------------------

    @Override
    public void displayResultingMST() {
        for (Edge edge : ListMSTresult) {
            edge.displayInfo();
            System.out.println();
        }
        System.out.println();
        System.out.println("The cost of designed phone network: " + this.theCost);
    }
}
 