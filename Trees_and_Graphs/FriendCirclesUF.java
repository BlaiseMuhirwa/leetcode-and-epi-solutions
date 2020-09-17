package Trees_and_Graphs;
import java.util.*;

/**
 * This is another implementions of the friends' circle problem using the union-find
 * data structure. We use path compression and union by rank to get an amortized time
 * of O(n^2) for the overall algorithm
 */
public class FriendCirclesUF {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int counter = 0, len = M.length;
        UnionFind uf = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (M[i][j] == 1 && i != j) {
                    uf.union(i, j);
                }
            }
        }
        for (int i = 0; i < uf.parent.length; i++) {
            if (uf.parent[i] == i) counter++;
        }
        return counter;
    }
}
class UnionFind {
    int[] parent;
    int[] rank;
    public UnionFind(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        Arrays.fill(rank, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY) return;
        if (rank[parentX] < rank[parentY]) {
            parent[parentX] = parentY;
            rank[parentY]++;
        } else {
            parent[parentY] = parentX;
            rank[parentX]++;
        }
    }
}