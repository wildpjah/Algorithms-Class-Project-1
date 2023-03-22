/*Phillip Waul
    3/16/23
    Goal of the project is to take a text file input that encodes a directed graph using edge list format
    Then output information about the input directed graph on the screen
    I chose to do it this way because it is the way I am most comfortable coding. I am used to using dictionaries in Python and maps are very similar.
    Using maps is nice because the key value pairs allow me to use an index or vertex ID for a key and then an Object as a value.
    In this case, the object will be a list of nodes the vertex is adjacent to or that are adjacent to the vertex.**/

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class part1 {
    
    public static void main(String[] args) {
        
        Graph myGraph = new Graph();
        try {
            File myFile = new File("input.txt");
            Scanner fReader = new Scanner(myFile);

            while (fReader.hasNextLine()) {
              String edge = fReader.nextLine();
              Scanner lReader = new Scanner (edge);
              if(lReader.hasNextInt()){
                int source = lReader.nextInt();
                int destination = lReader.nextInt();
                myGraph.addEdge(source, destination);
              }
              lReader.close();
            }
            fReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        
          //printing the output
          System.out.println(myGraph.toString());

    }
}