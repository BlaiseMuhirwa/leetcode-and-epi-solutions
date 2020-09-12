package implementations;
import java.util.*;

public class MinimumCostSpanningTree {
    public static void main(String[] args) {

    }
}

class Graph{
    int V, E;
    Edge[] edges;
    class Edge implements Comparable<Edge> {
        int src, dest, weight;
        public int compareTo(Edge currentEdge) {
            return this.weight - currentEdge.weight;
        }
    }

    class Subset {
        int parent, rank;
    }
    public Graph(int V, int E) {
        this.V = V;
        this.E = E;
        this.edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            edges[i] = new Edge();
        }
    }

    int find(Subset[] subsets, int x) {
        if (x != subsets[x].parent) {
            subsets[x].parent = find(subsets, subsets[x].parent);
        }
        return subsets[x].parent;
    }
    void union(Subset[] subsets, int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);
        if (xRoot == yRoot) return;

        if (subsets[xRoot].rank < subsets[yRoot].rank) {
            subsets[xRoot].parent = yRoot;
        } else if (subsets[xRoot].rank > subsets[yRoot].rank) {
            subsets[yRoot].parent = xRoot;
        } else {
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }

    }
    void KruskalMST() {
        Edge[] output = new Edge[this.V];
        int e = 0, i = 0; /* indices for output and sorted edges */

        for (int j = 0; j < this.V; j++) {
            output[j] = new Edge();
        }
        Arrays.sort(this.edges);
        //allocate memory for V subsets
        Subset[] subsets = new Subset[this.V];
        for (int j = 0; j < this.V; j++) {
            subsets[j] = new Subset();
        }


    }
}
