package trees_and_graphs;
import java.util.Iterator;
import java.util.LinkedList;


public class DFSImplementation {
    private int V; /* the number of vertices */
    private LinkedList<Integer> adj[]; /* adjacency list representation of the graph */

    public DFSImplementation(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int a, int b) {
        adj[a].add(b);
    }

    public void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.println(v);
        Iterator<Integer> iter = adj[v].listIterator();

        while (iter.hasNext()) {
            int n = iter.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    public void DFS(int v) {
        boolean[] visited = new boolean[V];

        DFSUtil(v, visited);
        System.out.println("\n");
    }

    public static void main(String[] args) {
        DFSImplementation myGraph = new DFSImplementation(4);

        myGraph.addEdge(0, 1);
        myGraph.addEdge(0, 2);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(2, 0);
        myGraph.addEdge(2, 3);
        myGraph.addEdge(3, 3);

        myGraph.DFS(2);
    }
}