package Dynamic_Programming;


/*
Given a m x n grid filled with non-negative numbers, find a path from top
 left to bottom right which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
*/
public class MinimumPathSum {
    /* here we use bottom-up processsing with a dp two-dimensional array */
    /* dp(i, j) = grid(i, j) + min (dp(i+1, j), dp(i, j+1))
     * the algorithm runs in O(m*n) where m and n are the dimensions of the grid. 
     * its space complexity is O(m*n) as well 
     * */
    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        int len = grid.length;
        dp[len -1][grid[0].length - 1] = grid[len - 1][grid[0].length - 1];
        
        for (int i = len - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == len - 1 && j == grid[0].length - 1) {
                    continue;
                }
                else if (i == len - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                }
                else if (j == grid[0].length - 1) {
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                }
                else {
                    dp[i][j] = grid[i][j] + Math.min(
                    dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
       
    }
}