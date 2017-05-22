/**
 * Created by Kyle on 12/8/2015.
 */

import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;

public class Lab8 {


    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("lab8.dat");
        Scanner in = new Scanner(file);

        int size = in.nextInt();
        Graph graph = new Graph(size);
        in.nextLine();

        int index = 0;

        while (in.hasNext()){

            /*String input;
            input = in.next();
            int val = parseInt(input.substring(1));
            int[] line = new int[size];

            if (val == 0){

            }
            else{

            }//end if
            */

            int weight = 1;
            String line = in.nextLine();
            String[] inputs = line.split("  ");

            //debug:
            //System.out.println("line is: " + line);

            int first = parseInt(inputs[0].substring(1));
            int second;

            //debug:
            //System.out.println("first is: " + first);

            //debug:
            for (int i = 0; i < inputs.length; i++){
                System.out.print("inputs " + i + ": " + inputs[i] + " ");
            }//end for
            System.out.println();

            // System.out.println("Printing inputs: ");
            if (inputs.length > 2) {
                for (int i = 1; i < inputs.length - 1; i++) {
                    //debug:
                    //System.out.print(inputs[i]);
                    //System.out.println("I is: " + i);
                    //System.out.println("I is: " + inputs[2]);

                    second = parseInt(inputs[i].substring(1));

                    //debug:
                    //System.out.println("second is: " + second);

                    graph.addEdge(first-1, second-1, weight);

                }//end for
                //System.out.println();
            }//end if

        }//end while

        //debug
        System.out.println("Edges: " + graph.getNumEdges());

        printBFS(graph);
        printDFS(graph);


    }//end main

    public static void printDFS (Graph g){
        DFSIterator dfs = new DFSIterator(g);

        System.out.println("Printing DFS Order: ");
        while(dfs.hasNext()){
            System.out.println((dfs.next() + 1));
        }//end while
    }//end printDFS

    public static void printBFS(Graph g){
        BFSIterator bfs = new BFSIterator(g);

        System.out.println("Printing BFS Order: ");
        while(bfs.hasNext()){
            System.out.println((bfs.next() + 1));
        }//end while

    }//end bfs

}//end Lab8
