package dynamic_programming;
import java.utils.*;

public class PerfectSquares {
    /* This solution runs in (n * sqrt(n)) time with O(n) space complexity. 
        We rely on the following recurrence relation to solve smaller subproblems:
            numSquares(n) = min(numSquares(n-k) + 1) for all k  - where k is a perfect square
            smaller than or equal to n 
    */
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int maxSquares = (int) Math.sqrt(n) + 1;
        int[] squares = new int[maxSquares];
        for (int i =1; i < maxSquares; i++) {
            squares[i] = i * i;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int square = 1; square < maxSquares; square++) {
                if (i < squares[square]) {
                    break;
                } 
                dp[i] = Math.min(dp[i], dp[i - squares[square]] + 1);
            }
        }

        return dp[n];
    }
}