package Dynamic_Programming;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest
 * square containing only 1's and return its area.
 * Example:
 *
 * Input:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        int answer = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    if (i > 0 && j > 0) {
                        dp[i][j] += Math.min(Math.min(dp[i-1][j], dp[i][j-1]),
                                dp[i-1][j-1]);
                    }
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        return answer * answer;
    }
}
