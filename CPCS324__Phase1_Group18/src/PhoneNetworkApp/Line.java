package PhoneNetworkApp;

import GraphFramework.*;

/*
 *  @authors Kawka
 */
public class Line extends Edge {

    private int Ilength;
   
        // Default constructor
    public Line() {
        
    }
    
    //Constructor with specific parameter: source, destination, weight, parent
  public Line(Vertex source, Vertex destination, int weight ) {
    
         super(source, destination, weight);
        this.Ilength = weight * 5;
    }
  
  // ----------------------------------------------------------------------
  //-----------------------the get and set

      public int getIlength() {
        return Ilength;
    }
     public void setlLength(int ILength) {
        this.Ilength = ILength;
    }   

     // ----------------------------------------------------------------------
     
    @Override
    public void displayInfo() {

        String srcLabel =  super.getSource().getLabel();        
        String destinationLabel =  super.getDestination().getLabel();
        
                super.getSource().setLabel("O"+srcLabel);
                super.getDestination().setLabel("O"+destinationLabel);

        System.out.print("Office No." + srcLabel +"-Office No." + destinationLabel  +" : line length: " + getIlength());
                        
        super.getSource().setLabel(srcLabel);
      super.getDestination().setLabel(destinationLabel);
        
        
     }  
} 
