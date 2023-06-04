package PhoneNetworkApp;

import GraphFramework.Vertex;


/*
 *  @authors Kawka
 */
public class Office extends Vertex {
  
    // Default constructor
    public Office() {
        
    }
    
     //Constructor with specific parameter: label      
    public Office(String label) {
        super(label);
    }

    // ----------------------------------------------------------------------
    
     @Override
    public void setLabel(String label) {
        super.setLabel(label);
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
    } 
} 
