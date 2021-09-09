package Dynamic_Programming;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 * You may assume that the maximum length of s is 1000.
 * Example:
 *  "bbbab" -> 4
 *  "cbbd" -> 2
 */
public class LongestPalindromicSubSequence {
    /**
     * In this solution we use the following recurrence relation:
     * LPS(i, j) = * 2 + LPS(i+1, j-1) if s.charAt(i) == s.charAt(j)
     *             * Math.max(LPS(i+1, j), LPS(i, j-1)) otherwise
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int currentLength = 2; currentLength <= len; currentLength++) {
            for (int i = 0; i < len - currentLength + 1; i++) {
                int j = i + currentLength - 1;
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }


        }
        return dp[0][len-1];

    }
}
