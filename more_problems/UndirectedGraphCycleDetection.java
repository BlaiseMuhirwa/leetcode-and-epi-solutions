package more_problems;

public class UndirectedGraphCycleDetection {
    public static void main(String[] args) {
        int V = 3, E = 3;
        Graph graph = new Graph(V, E);
        /* add edges */
        graph.edge[0].source = 0;
        graph.edge[0].dest = 1;

        graph.edge[1].source = 1;
        graph.edge[1].dest = 2;

        graph.edge[2].source = 0;
        graph.edge[2].dest = 0;

        if (graph.containsCycle()) {
            System.out.println("Input graph contains a cycle");
        }
        else System.out.println("No cycle detected in the input graph");
    }
}

class Graph {
    int V, E; //vertices and edges
    Edge[] edge;

    class Edge {
        int source, dest;
    }

    Graph(int v, int e) {
        this.E = e;
        this.V = v;
        edge = new Edge[e];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }
    int find(int[] parent, int i) {
        if (i == -1) return i;
        return find(parent, parent[i]);
    }
    void union(int[] parent, int i, int j) {
        int set_i = find(parent, i);
        int set_j = find(parent, j);

        parent[i] = j;
    }

    boolean containsCycle () {
        int[] parent = new int[this.V];//start with V subsets

        for (int i = 0; i < this.V; i++) {
            parent[i] = -1;//initially make each vertex the root of its own set
        }
        /* iterate through all edges of the graph. If two vertices connected by the
            same edge are in the same set, then the graph has a cycle
         */
        for (int i = 0; i < this.E; i++) {
            int x = find(parent, this.edge[i].source);
            int y = find(parent, this.edge[i].dest);

            if (x == y) return true;
            union(parent, x, y);
        }
        return false;
    }
}
