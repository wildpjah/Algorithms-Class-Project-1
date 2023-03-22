public class Edge {
    private int source;
    private int destination;
    private int index;

    public Edge(int source, int destination){
        this.source = source;
        this.destination = destination;
    }

    public Edge(int source, int destination, int index){
        this.source = source;
        this.destination = destination;
        this.index = index;
    }

    //getters and setters
    public int getSource(){
        return this.source;
    }
    public int getDestination(){
        return this.destination;
    }

    //other methods
    public boolean isEqual(Edge e){
        if(
            this.source == e.getSource() &&
            this.destination == e.getDestination()
        ) return true;
        return false;
    }
    
}
