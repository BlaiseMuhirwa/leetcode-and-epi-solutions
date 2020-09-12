package Dynamic_Programming;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int counter = 0;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            counter++;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                final boolean b = s.charAt(i) == s.charAt(j);
                if (j == i - 1 && b) {
                    dp[i][j] = 1;
                    counter++;
                }
                else if (dp[i-1][j+1] == 1 && b) {
                    dp[i][j] = 1;
                    counter++;
                }
            }
        }
        return counter;
    }
}
