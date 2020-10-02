package Dynamic_Programming;

/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 */
public class EditDistance {
    /**
     * Time Complexity: O(m*n); notice that without memoization, we would
     * get a time complexity of O(3*n)
     * Space complexity: O(m*n)
     */
    int[][] memo;
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        this.memo = new int[m][n];
        for (int[] row : memo) {
            for (int i = 0; i < row.length; i++) row[i] = -1;
        }
        return findMinDistance(word1, word2, m, n);
    }

    public int findMinDistance(String first, String second, int m, int n) {
        if (m == 0) return n;
        if (n == 0) return m;

        if (memo[m-1][n-1] != -1) return memo[m-1][n-1];

        if (first.charAt(m - 1) == second.charAt(n -1)) {
            memo[m-1][n-1] = findMinDistance(first, second, m - 1, n - 1);
            return memo[m-1][n-1];
        }
        else {
            memo[m-1][n-1] = 1 + min(
                    findMinDistance(first, second, m - 1, n - 1),
                    findMinDistance(first, second, m - 1, n),
                    findMinDistance(first, second, m, n - 1));
            return memo[m-1][n-1];
        }
    }

    public int min (int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }
}
