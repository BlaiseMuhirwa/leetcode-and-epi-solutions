package Dynamic_Programming;
import java.util.*;


public class NumberOfDiceRollsWithTargetSum {
    final int MOD = 1000000007;
    Map<String, Integer> map = new HashMap<>();
    public int numRollsToTarget(int d, int f, int target) {
        if (target < d || target > d * f) return 0;
        if (d == 1) return (target <= f) ? 1 : 0;

        String key = "" + d + f + target;
        if (!map.containsKey(key)) {
            int sum = 0;
            for (int i = 1; i <= f; i++) {
                sum += numRollsToTarget(d-1, f, target - i);
                sum %= MOD;
            }
            map.put(key, sum);
        }
        return map.get(key);

    }
}
