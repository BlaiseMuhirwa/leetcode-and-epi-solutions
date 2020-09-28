package Trees_and_Graphs;
import java.util.Set;
import java.util.HashSet;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of
 * 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 *
 * Count the number of distinct islands. An island is considered to be the
 * same as another if and only if one island can be translated (and not
 * rotated or reflected) to equal the other.
 */
public class NumberOfDistinctIslands {
    /**
     * Time complexity: O(m*n) where m and n are the dimensions of the grid
     * Space complexity: O(m*n) due to the recursion stack
     * @param grid
     * @return
     */
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        Set<String> islands = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j]) {
                    if (grid[i][j] == 1) {
                        islands.add(dfs(visited, grid, i, j, "X"));
                    }
                }
            }
        }
        return islands.size();
    }

    public String dfs(boolean[][] visited, int[][] grid, int i, int j,
                      String direction) {
        if (i < 0 || i >= grid.length || j < 0 ||
                j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return "O";
        }
        visited[i][j] = true;
        grid[i][j] = 0;
        String left = dfs(visited, grid, i, j - 1, "L");
        String right = dfs(visited, grid, i, j + 1, "R");
        String up = dfs(visited, grid, i - 1, j, "U");
        String down = dfs(visited, grid, i + 1, j, "D");

        return direction + left + right + up + down;
    }
}
