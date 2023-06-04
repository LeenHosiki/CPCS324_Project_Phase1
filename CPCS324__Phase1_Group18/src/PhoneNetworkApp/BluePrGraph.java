package PhoneNetworkApp;

import GraphFramework.Edge;
import GraphFramework.Graph;
import GraphFramework.Vertex;
import java.io.File;
import java.io.FileNotFoundException;

/*
 *  @authors Kawka
 */
public class BluePrGraph extends Graph {

        
   public BluePrGraph() {
        
    }
   

//Constructor with specific parameter: verticesNo, edgesNo, isDirect
 
   public BluePrGraph(int verticesNo, int edgesNo, boolean isDirect) {
        super(verticesNo, edgesNo, isDirect);
    }
    
   

   public BluePrGraph(File FileOfgraph) throws FileNotFoundException {
        super(FileOfgraph);
    }
   
   // ----------------------------------------------------------------------

    @Override
    public Vertex createVertex(String label) {
      Vertex ver= new Office(label);//make obj with parametar
       return ver; 
    }

     @Override
    public Edge createEdge(Vertex source, Vertex destination, int weight) {
      Edge edg= new Line(source, destination, weight);//make obj with parametar
         return edg; 
    }
    
    // ----------------------------------------------------------------------
    
    public void displayInfo(){
    displayInfo();
    }

}
