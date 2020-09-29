package Trees_and_Graphs;
import java.util.*;

/**
 * There are N cities numbered from 1 to N.
 *
 * You are given connections, where each connections[i] = [city1, city2, cost]
 * represents the cost to connect city1 and city2 together.  (A connection
 * is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)
 *
 * Return the minimum cost so that for every pair of cities, there exists a path
 * of connections (possibly of length 1) that connects those two cities together.
 * The cost is the sum of the connection costs used. If the task is impossible, return -1.
 */
public class ConnectingCitiesWithMinimumCost {
    /**
     * This algorithm runs in O(M * logN) where M is the number of edges
     * and N is the number of vertices in the input graph
     */
    int minCost = 0;
    public int minimumCost(int N, int[][] connections) {
        if (N == 0) return 0;
        if (isDisconnected(connections, N)) return -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[2] - b[2]);
        for (int[] edge : connections) {
            pq.add(edge);
        }

        UnionFind uf = new UnionFind(N);
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            if (!uf.union(edge[0], edge[1])) continue;
            else {
                minCost += edge[2];
            }
        }
        return minCost;

    }

    public boolean isDisconnected(int[][] connections, int N) {
        UnionFind uf = new UnionFind(N);
        for (int[] edge : connections) {
            uf.union(edge[0], edge[1]);
        }
        for (int i = 1; i < uf.parent.length - 1; i++) {
            if (uf.find(uf.parent[i]) != uf.find(uf.parent[i + 1])) {
                return true;
            }
        }
        return false;
    }

    class UnionFind {
        int[] parent;
        int[] rank;
        public UnionFind(int N) {
            this.parent = new int[N + 1];
            this.rank = new int[N + 1];
            for (int i = 1; i <= N; i++) parent[i] = i;
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
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
                rank[parentX] += rank[parentY];
                parent[parentY] = parentX;
            }
            return true;
        }
    }
}
