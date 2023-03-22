import java.util.*;
public class Graph {
    private Map<Integer, List<Node>> ReverseAdjList=new HashMap<Integer, List<Node>>();
    private Map<Integer, List<Node>> AdjList=new HashMap<Integer,List<Node>>(); //The Map has keys which are the index of a node and the value is a list of nodes that the vertex points to
    private Map<Integer, Node> NodeArray=new HashMap<Integer,Node>();//This map uses the index as a key, with the value being each node.
    private Map<Integer, Integer> NameToIndex= new HashMap<Integer,Integer>(); //Uses vertexID as key and index as value
    private Map<Integer, Edge> EdgeArray=new HashMap<Integer,Edge>(); //Uses index for edges as a key and the Edge object as a value

    // standard constructors
    // standard addition of nodes:
    // check if already in node array if not add give it new index //number, create and add to node array
    private void addNode(int vertexID, int index){
        NodeArray.put(index, new Node(vertexID, index));
        this.AdjList.put(index, new ArrayList<Node>());//adds entries in AdjList and ReverseAdjList for the Node index with an empty list to be filled with adjacent Nodes.
        this.ReverseAdjList.put(index, new ArrayList<Node>());
    }
    // standard addition of edges:
    // create a new edge give it a new index number and add to //map entry in AdjList for source node and a new map entry
    // for target in ReverseAdjList
    public void addEdge(int source, int destination){
        int edgeIndex = this.EdgeArray.size();
        this.EdgeArray.put(edgeIndex, new Edge(source, destination, edgeIndex));
        int sourceIndex = this.NameToIndex.size();
        if(!this.NameToIndex.containsKey(source)){//check if source Node has been added yet. If not, add it
            NameToIndex.put(source, sourceIndex);
            this.addNode(source, sourceIndex);
        }else{
            sourceIndex = this.NameToIndex.get(source);//uses the correct index of the node if it is already in the list
        }
        Node sourceNode = this.NodeArray.get(sourceIndex);
        int dIndex = this.NameToIndex.size();
        if(!this.NameToIndex.containsKey(destination)){//same as above for destination Node
            NameToIndex.put(destination, dIndex);
            this.addNode(destination, dIndex);
        }else{
            dIndex = this.NameToIndex.get(destination);
        }
        Node dNode = this.NodeArray.get(dIndex);

        
        this.AdjList.get(sourceIndex).add(this.NodeArray.get(dIndex));//adds Nodes to adjacency lists
        this.ReverseAdjList.get(dIndex).add(this.NodeArray.get(sourceIndex));

        this.UpdateDegrees(sourceNode);
        this.UpdateDegrees(dNode);
        this.UpdatePageRank(sourceNode);
        this.UpdatePageRank(dNode);
    }

    private void UpdateDegrees(Node n){
        int index = n.getIndex();
        n.setOutDegree(this.AdjList.get(index).size());
        n.setInDegree(this.ReverseAdjList.get(index).size());
    }

    private void UpdatePageRank(Node n){
        //TODO FOR A LATER PART OF THE PROJECT
        //-1 is a placeholder
        int rank = -1;
        n.setPageRank(rank);
    }


    public String toString(){
        String finalString = "";
        for(int i : this.NameToIndex.keySet()){
            int currIndex = this.NameToIndex.get(i);
            if(this.AdjList.get(currIndex) != null){
                Node currentNode = this.NodeArray.get(currIndex);
                finalString += currentNode.toString();
                finalString += "\nEdges from " + currentNode.getVertexID() + " to: ";
                for(int j = 0; j < this.AdjList.get(currIndex).size(); j++){
                    Node n = this.AdjList.get(currIndex).get(j);
                    finalString += n.getVertexID();
                    if (j != this.AdjList.get(currIndex).size() - 1){
                        finalString += ", ";
                    }
                }
                finalString += "\n\n";
            }
        }
        return finalString;
    }
}

