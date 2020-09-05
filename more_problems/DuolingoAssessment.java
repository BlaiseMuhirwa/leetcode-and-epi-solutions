package more_problems;

public class DuolingoAssessment {
    public static void main(String[] args) {
        System.out.println(getSubsequenceCount("ABC", "ABCBAC"));
        System.out.println(getSubsequenceCount("aka", "jj"));
        System.out.println(getSubsequenceCount("aka", "adbkdkalakabbciekdlkdkkda"));
    }

    public static int getSubsequenceCount(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n > m) return 0;
        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i < m+1; i++) {
            dp[n][i] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i][j+1] + dp[i+1][j+1];
                }
                else {
                    dp[i][j] = dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
