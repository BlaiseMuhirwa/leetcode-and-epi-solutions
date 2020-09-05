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
