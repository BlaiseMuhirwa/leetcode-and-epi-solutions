package dynamic_programming;

/*
    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
    The robot can only move either down or right at any point in time. The robot is trying to reach
    the bottom-right corner of the grid (marked 'Finish' in the diagram below).
    How many possible unique paths are there?

    Input: m = 3, n = 2
    Output: 3
    Explanation:
    From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
    1. Right -> Right -> Down
    2. Right -> Down -> Right
    3. Down -> Right -> Right
*/

public class UniquePaths {
    /* Time complexity: O(m*n), space complexity: O(m*n) */
    public int uniquePaths(int m, int n) {
        if (m == 0 ||n == 0) return 0;
        if (m == 1 || n == 1) return 1;
        
        int[][] grid = new int[m][n];
        grid[0][0] = 0;
        grid[0][1] = 1;
        grid[1][0] = 1;
        
        for (int k = 1; k < m; k++) {
            grid[k][0] = 1;
        }
        for (int l = 1; l < n; l++) {
            grid[0][l] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i][j-1] + grid[i-1][j];
            }
        }
        return grid[m-1][n-1];
        
    }
}