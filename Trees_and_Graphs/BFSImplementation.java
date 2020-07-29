package Trees_and_Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSImplementation{
    private int V; /* the number of edges in the graph */
    private LinkedList<Integer> adj[]; /* adjacency list representation of the graph */

    public BFSImplementation(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i< v; i++) {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int a, int b) {
        adj[a].add(b);
    }

    public void BFS(int s) {
        boolean visited[] = new boolean[V]; /* create an array of boolean values to mark visited nodes */
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> iter = adj[s].listIterator();

            while (iter.hasNext()) {
                int n = iter.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        System.out.print("\n");

    }

    public static void main(String[] args) {
        BFSImplementation myGraph = new BFSImplementation(4);

        myGraph.addEdge(0, 1);
        myGraph.addEdge(0, 2);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(2, 0);
        myGraph.addEdge(2, 3);
        myGraph.addEdge(3, 3);

        myGraph.BFS(2);
    }

}