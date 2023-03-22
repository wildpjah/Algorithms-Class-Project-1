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
    public double getRank(){
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
    public void setvertexID(int vertexID){
        this.vertexID = vertexID;
    }
    public void setpageRank(int pageRank){
        this.pageRank = pageRank;
    }
    public void setoutDegree(int outDegree){
        this.outDegree = outDegree;
    }
    public void setinDegree(int inDegree){
        this.inDegree = inDegree;
    }
    
}

