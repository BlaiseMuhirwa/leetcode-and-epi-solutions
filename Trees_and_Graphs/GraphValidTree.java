package Trees_and_Graphs;

/**
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 */
public class GraphValidTree {
    /**
     * This algorithm runs in O(E * IAF(E)) where IAF refers to the inverse ackerman function
     * and E is the number of edges in the graph.
     */
    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (x != parent[x]) parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX == parentY) return false;

            if (rank[parentX] < rank[parentY]) {
                parent[parentX] = parentY;
            } else if (rank[parentX] > rank[parentY]) {
                parent[parentY] = parentX;
            } else {
                parent[parentY] = parentX;
                rank[parentX] += rank[parentY];
            }
            return true;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) return false;
        }
        for (int i = 1; i < uf.parent.length; i++) {
            if (uf.find(uf.parent[i]) != uf.find(uf.parent[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
