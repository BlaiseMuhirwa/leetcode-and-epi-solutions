package trees_and_graphs;
import java.util.*;
/*
    Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
    write a function to find the number of connected components in an undirected graph.
    Example 1:
        Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]

        0          3
        |          |
        1 --- 2    4 
        Output: 2
*/

public class NumberOfConnectedComponents {
    /* This implementation uses breadth-first search */
    LinkedList<Integer> q = new LinkedList<>();
    public int countComponents(int n, int[][] edges) {
        if (n == 0 || n == 1) {
            return n;
        }
        boolean[] visited = new boolean[n];
        LinkedList<Integer> adjList[] = new LinkedList[n];
        
        for (int i = 0; i < n; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        int count = 0;
        //int start = adjList[0].get(0);
        for (int j = 0; j < n; j++) {
            try {
                if(!visited[adjList[j].get(0)]) {
                    count++;
                    q.add(adjList[j].get(0));
                    bfs(visited, adjList[j].get(0) ,adjList);
                }
            }
            catch(IndexOutOfBoundsException exception) {
                count++;
            }
            
        }
        return count;
    }
    
    private void bfs(boolean[] visited, int vertex, LinkedList<Integer>[] adjList) {
        visited[vertex] = true;
        while (!q.isEmpty()) {
            int head = q.poll();
            Iterator<Integer> iter = adjList[head].listIterator();
            while (iter.hasNext()) {
                int n = iter.next();
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
    }


}