package GraphFramework;

import PhoneNetworkApp.BluePrGraph;
import java.util.*;


/*
 *  @authors Kawka
 */
public abstract class MSTAlgorithm {

    LinkedList<Edge> ListMSTresult; //the result will keep here
    ArrayList<Edge>  MSTresultList  ;

     BluePrGraph graphObj; 

    public MSTAlgorithm() { //perform each algorithm
       ListMSTresult = new LinkedList<>();
       graphObj = graphObj;
    }
    
    // ----------------------------------------------------------------------
    
    //abstract from ptim and kruskal
    public abstract void displayResultingMST();

    public abstract void doMST(Graph graphObj); 


}
