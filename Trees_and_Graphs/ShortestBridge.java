package Trees_and_Graphs;

import java.util.ArrayList;
import java.util.List;
/**
 * In a given 2D binary array A, there are two islands.  (An island is a 4-directionally
 * connected group of 1s not connected to any other 1s.)
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 *
 * Return the smallest number of 0s that must be flipped.
 * (It is guaranteed that the answer is at least 1.)
 */
public class ShortestBridge {
    public int getShortestBridge(int[][] A) {
        if (A == null || A.length == 0) return 0;

        List<int[]> firstIsland = new ArrayList<>();
        List<int[]> secondIsland = new ArrayList<>();

        findIsland(firstIsland, A);
        findIsland(secondIsland, A);

        int minDistance = Integer.MAX_VALUE;
        for (int[] first : firstIsland) {
            int local = Integer.MAX_VALUE;
            for (int[] second : secondIsland) {
                local = Math.min(local, Math.abs(first[0] - second[0]) +
                        Math.abs(first[1] - second[1]) - 1);
            }
            minDistance = Math.min(local, minDistance);
        }
        return minDistance;
    }

    private void findIsland(List<int[]> island, int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(island, i, j, grid);
                    return;
                }
            }
        }
    }

    private void dfs(List<int[]> island, int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
                grid[i][j] == 0) {
            return;
        }
        island.add(new int[] {i, j});
        grid[i][j] = 0;
        dfs(island, i + 1, j, grid);
        dfs(island, i - 1, j, grid);
        dfs(island, i, j + 1, grid);
        dfs(island, i, j - 1, grid);
    }
}
