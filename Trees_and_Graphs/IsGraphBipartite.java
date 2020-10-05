package Trees_and_Graphs;
import java.util.*;

/**
 * Given an undirected graph, return true if and only if it is bipartite.
 *
 * Recall that a graph is bipartite if we can split it's set of nodes into
 * two independent subsets A and B such that every edge in the graph has
 * one node in A and another node in B.
 *
 * The graph is given in the following form: graph[i] is a list of indices
 * j for which the edge between nodes i and j exists.  Each node is an integer
 * between 0 and graph.length - 1.  There are no self edges or parallel edges:
 * graph[i] does not contain i, and it doesn't contain any element twice.
 */
public class IsGraphBipartite {
    /**
     * Time complexity: O(V+E)
     * Space complexity: O(V)
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] color = new int[len];
        Arrays.fill(color, -1);

        for (int start = 0; start < len; start++) {
            if (color[start] == -1) {
                Stack<Integer> stack = new Stack();
                stack.push(start);
                color[start] = 0;

                while (!stack.isEmpty()) {
                    int node = stack.pop();
                    for(int neighbor : graph[node]) {
                        if (color[neighbor] == color[node]) {
                            return false;
                        } else {
                            if (color[neighbor] == -1) {
                                color[neighbor] = color[node] ^ 1;
                                stack.push(neighbor);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
