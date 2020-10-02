package Dynamic_Programming;

/**
 * Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.
 *
 * A string s is said to be one distance apart from a string t if you can:
 *
 * Insert exactly one character into s to get t.
 * Delete exactly one character from s to get t.
 * Replace exactly one character of s with a different character to get t.
 */
public class OneEditDistance {
    /**
     * Time complexity: O(m*n) -> there is an O(n) time algorithm, but
     * I'm not going to show it here
     * space complexity: O(m*n) as well
     */
    int[][] memo;
    public boolean isOneEditDistance(String s, String t) {
        if (s == null && t == null) return false;
        if (s.length() == 0 && t.length() == 0) return false;

        if (Math.abs(s.length() - t.length()) > 1) return false;
        int m = s.length();
        int n = t.length();
        this.memo = new int[m][n];
        for(int[] row : memo) {
            for(int j = 0; j < row.length; j++) row[j] = -1;
        }

        if (findEditDistance(s, t, m, n) != 1) return false;
        return true;
    }

    public int findEditDistance(String s, String t, int m, int n) {
        if (m == 0) return n;
        if (n == 0) return m;

        if (memo[m-1][n-1] != -1) return memo[m-1][n-1];

        if (s.charAt(m-1) == t.charAt(n-1)) {
            memo[m-1][n-1] = findEditDistance(s, t, m-1,n-1);
            return memo[m-1][n-1];
        }
        else {
            memo[m-1][n-1] = 1 + min(
                    findEditDistance(s, t, m-1, n-1),
                    findEditDistance(s, t, m, n-1),
                    findEditDistance(s, t, m-1, n));

            return memo[m-1][n-1];
        }
    }

    public int min(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }
}
