package Dynamic_Programming;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * A subsequence of a string is a new string generated from the original string with some
 * characters(can be none) deleted without changing the relative order of the remaining
 * characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not).
 * A common subsequence of two strings is a subsequence that is common to both strings.
 */
public class LongestCommonSubsequence {
    /**
     * The running time of this algorithm is O(M*N) and its space complexity
     * is also O(M*N)
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        if (text1.length() == 0 || text2.length() == 0) return 0;

        int M = text1.length();
        int N = text2.length();

        int[][] dp = new int[M+1][N+1];
        for (int j = 0; j < N; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i < M; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else if (dp[i][j-1] >= dp[i-1][j]){
                    dp[i][j] = dp[i][j-1];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[M][N];
    }
}
