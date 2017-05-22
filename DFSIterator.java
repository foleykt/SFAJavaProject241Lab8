import java.util.*;

/**
 * Created by Kyle on 12/8/2015.
 */


//adapted from BFSIterator to use depth first sort instead of breadth first

class DFSIterator implements Iterator<Integer> {

    private Graph g;          // The graph to be iterated.
    private int numVertices;  // The number of vertices in the graph.
    private int count;        // Used to mark the order the
    // vertices are visited.
    private int[] mark;       // Keeps track of the order that
    // the vertices are visited.
    private int iter;         // Used for the iteration.

    public DFSIterator(Graph g) {
        // Creates an iterator for the graph g.
        // Precondition: The graph g is a non-empty graph.
        // Postcondition: Completes the Breadth-first search
        // of graph g, ready for iteration.
        this.g = g;
        numVertices = g.getNumVertices();
        mark = new int[numVertices];
        Arrays.fill(mark,0,numVertices,-1);

        count = 0;
        iter = -1;

        startSearch();
    } // end constructor

    public boolean hasNext() {
        // Determines if there is another vertex in the BFS
        // iteration of the graph.
        // Precondition: None.
        // Postcondition: Returns true if there are more vertices
        // in the BFS iteration, otherwise returns false.
        return (iter >=0) && (iter < numVertices);
    } // end hasNext

    public Integer next() throws NoSuchElementException {
        // Returns the next vertex in the BFS iteration
        // of the graph.
        // Precondition: The BFS iteration has more vertices.
        // Postcondition: Returns next element in the DFS
        // iteration, if none exists, throws an exception.
        if (hasNext()) {
            int i;
            for(i = 0; i < numVertices; i++){
                if(mark[i] == iter) break;
            }
            iter++;
            int vert = i;
            return vert;
        } else {
            throw new NoSuchElementException();
        }  // end if
    } // end next

    public void remove() {
        // Not implemented, vertices cannot be removed
        // from the graph using the iterator.
        throw new UnsupportedOperationException();
    } // end remove

    protected void startSearch() {
        // Searches each unvisited vertex.
        // Precondition: The vertex exists in the graph.
        // Postcondition: Completes a depth-first search
        // with each unvisited vertex.

        for (int v=0; v < numVertices; v++) {
            if (mark[v] == -1) {
                search(v);
            } // end if
        } // end for

        // Depth-first search completed, initialize
        // iterator.
        iter = 0;
    } // end startSearch

    protected void search(Integer vertex) {
        // Traverse the graph beginning at vertex v by using
        // a breadth-first search.
        // Precondition: The vertex v is in the graph.
        // Postcondition: Completes a breadth-first search
        // starting from vertex.
        Stack<Integer> stack = new Stack<Integer>();
        TreeMap<Integer, Integer> m;
        Set<Integer> connectedVertices;
        Integer v;

        // This gets it started at vertex v

        stack.push(vertex);

        while (!stack.isEmpty()) {
            v = stack.peek();
            if (mark[v] == -1) {
                mark[v] = count++;
            }// end for

            m = g.getAdjList(v);
            connectedVertices = m.keySet();
            boolean found = false;

            for (Integer w : connectedVertices) {
                if (mark[w] == -1) {
                    mark[w] = count++;
                    stack.push(w);
                    found = true;
                    break;
                } // end if
            } // end for

            if (!found && !stack.isEmpty()){
                stack.pop();
            }
            // } // end if

        } // end while
    } // end search

} // end DFS