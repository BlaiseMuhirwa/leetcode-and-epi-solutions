package Dynamic_Programming;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length <= 2) return 0;
        int len = A.length;
        int result = 0;
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < len; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                dp[i] = dp[i-1] + 1;
            }
            result += dp[i];
        }
        return result;
    }
}

    private void dfs(int[][] grid, int i, int j) {
        if (i <= 0 || i >= grid.length - 1 || j <= 0 || j >= grid[0].length - 1 ||
                grid[i][j] == 0 || grid[i][j] == 2) {
            return;
        }

        if (grid[i - 1][j] == 1) grid[i - 1][j] = 2;
        if (grid[i + 1][j] == 1) grid[i + 1][j] = 2;
        if (grid[i][j - 1] == 1) grid[i][j - 1] = 2;
        if (grid[i][j + 1] == 1) grid[i][j + 1] = 2;

        this.minutes += 1;

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }