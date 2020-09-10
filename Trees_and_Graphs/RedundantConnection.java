package Trees_and_Graphs;

/**
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 * The given input is a graph that started as a tree with N nodes
 * (with distinct values 1, 2, ..., N), with one additional edge added.
 * The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 *
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v]
 * with u < v, that represents an undirected edge connecting nodes u and v.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes.
 * If there are multiple answers, return the answer that occurs last in the given 2D-array.
 * The answer edge [u, v] should be in the same format, with u < v.
 */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return new int[0];
        }
        UnionFind uf = new UnionFind(edges.length + 1);
        for (int i = 0; i < edges.length; i++) {
            if (!uf.union(edges[i][0], edges[i][1])) {
                return edges[i];
            }
        }
        return null;
    }
}
class UnionFind{
    int[] parent;
    UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    int find (int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    boolean union(int x, int y) {
        int parentx = find(x);
        int parenty = find(y);
        if (parentx == parenty) return false;

        parent[parentx] = parenty;
        return true;
    }
}