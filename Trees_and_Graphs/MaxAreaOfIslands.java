package Trees_and_Graphs;

/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
(representing land) connected 4-directionally (horizontal or vertical.)
You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array.
(If there is no island, the maximum area is 0.)
*/
public class MaxAreaOfIslands {
    private int len = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) return 0;
        if (grid.length == 0) return 0;
        
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    maxArea = Math.max(maxArea, len);
                }
                this.len = 0;
            }
        }
        return maxArea;
    }
    
    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 ||
           j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        this.len += 1;
        grid[i][j] = 0;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}