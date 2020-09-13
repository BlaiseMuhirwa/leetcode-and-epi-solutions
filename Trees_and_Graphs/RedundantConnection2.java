package Trees_and_Graphs;
import java.util.*;

public class RedundantConnection2 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        if (edges == null || edges.length == 0) return new int[0];

        int len = edges.length;
        int[] inDegree = new int[len + 1];
        int hasTwoInDegrees = -1;
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
            if (inDegree[edge[1]] == 2) {
                hasTwoInDegrees = edge[1];
                break;
            }
        }
        if (hasTwoInDegrees == -1) return detectCycle(len, edges, null);
        for (int i = len - 1; i >= 0; i--) {
            if (edges[i][1] == hasTwoInDegrees) {
                if (detectCycle(len, edges, edges[i]) == null) {
                    return edges[i];
                }
            }
        }
        return null;
    }

    public int[] detectCycle(int length, int[][] edges, int[] skipEdge) {
        UnionFind uf = new UnionFind(length);
        for (int[] edge : edges) {
            if (Arrays.equals(edge, skipEdge)) continue;
            if (!uf.union(edge[0], edge[1])) return edge;
        }
        return null;
    }

    class UnionFind{
        int[] rank;
        int[] parent;
        public UnionFind(int n) {
            this.rank = new int[n+1];
            this.parent = new int[n+1];
            Arrays.fill(rank, 1);
            for (int i = 0; i <= n; i++) {
                this.parent[i] = i;
            }
        }
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false;
            else if (rank[rootX] < rank[rootY]) {
                rank[rootY] += rank[rootX];
                parent[rootX] = rootY;
            } else {
                rank[rootX] += rank[rootY];
                parent[rootY] = rootX;
            }
            return true;
        }
    }
}
