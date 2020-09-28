package Trees_and_Graphs;
import java.util.*;

/**
 * Given a matrix of integers A with R rows and C columns, find the maximum score
 * of a path starting at [0,0] and ending at [R-1,C-1].
 *
 * The score of a path is the minimum value in that path.  For example, the value
 * of the path 8 →  4 →  5 →  9 is 4.
 *
 * A path moves some number of times from one visited cell to any neighbouring
 * unvisited cell in one of the 4 cardinal directions (north, east, west, south).
 */
public class PathWithMaximumMinimumValue {
    boolean[][] visited;
    public int maximumMinimumPath(int[][] A) {
        if (A == null || A.length == 0) return 0;

        int m = A.length, n = A[0].length;
        visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[2] - a[2]));
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        pq.add(new int[] {0, 0, A[0][0]});
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int row = pair[0];
            int col = pair[1];

            if (row == m - 1 && col == n - 1) {
                return pair[2];
            }
            for (int[] dir : directions) {
                if (row + dir[0] >= m || row + dir[0] < 0 ||
                        col + dir[1] >= n || col + dir[1] < 0) continue;
                int newX = row + dir[0];
                int newY = col + dir[1];
                if (visited[newX][newY]) continue;
                else {
                    visited[newX][newY] = true;
                    pq.add(new int[] {newX, newY, Math.min(pair[2], A[newX][newY])});
                }
            }
        }
        return -1;
    }
}
