 
package GraphFramework;

/**
 *
 * @author Kawka
 */
public class NodeOfvertex {
    
//------------------------------------------------------------------------------------


    private String data; //vertex label 
    private int rank; //rank of every vertex starts with 0, and increases if vertex is the 'leader'
    private NodeOfvertex representative; //node parent (who is its representative?)

    // Getters and setters
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public NodeOfvertex getRepresentative() {
        return representative;
    }

    public void setRepresentative(NodeOfvertex representative) {
        this.representative = representative;
    }
    
}

