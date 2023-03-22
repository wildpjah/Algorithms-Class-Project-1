import java.text.DecimalFormat;
public class Node {
    private int vertexID = -1;
    private double pageRank = 0.0;
    private int outDegree = -1;
    private int inDegree = -1;
    private int index = -1;

    public Node(int vertexID, int index) {
        this.vertexID = vertexID;
        this.index = index;
    }
    //getters
    public int getIndex(){
        return this.index;
    }
    public double getPageRank(){
        return this.pageRank;
    }
    public int getVertexID(){
        return this.vertexID;
    }
    public int getOutDegree(){
        return this.outDegree;
    }
    
    //setters
    public void setIndex(int index){
        this.index = index;
    }
    public void setVertexID(int vertexID){
        this.vertexID = vertexID;
    }
    public void setPageRank(int pageRank){
        this.pageRank = pageRank;
    }
    public void setOutDegree(int outDegree){
        this.outDegree = outDegree;
    }
    public void setInDegree(int inDegree){
        this.inDegree = inDegree;
    }

    //other methods
    public String toString(){
        String finalString = "";
        DecimalFormat format = new DecimalFormat("0.#");
        String pageRank = format.format(this.pageRank);

        finalString += "Vertex " + this.getVertexID() + 
                ": rank = " + pageRank + 
                ", out-degree = " + this.getOutDegree();
        return finalString;
    }
    
}

