package Dynamic_Programming;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid
 * (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 */
public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        boolean obstacle = false;
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) obstacle = true;
            if (!obstacle) dp[0][j] = 1;
            else dp[0][j] = 0;
        }

        obstacle = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) obstacle = true;
            if (!obstacle) dp[i][0] = 1;
            else dp[i][0] = 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
