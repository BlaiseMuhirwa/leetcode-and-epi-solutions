package Backtracking;
import java.util.*;

/**
 * Find all valid combinations of k numbers that sum up to n such that the
 * following conditions are true:
 *
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination
 * twice, and the combinations may be returned in any order.
 */
public class CombinationSum3 {
    int k;
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> output = new ArrayList<>();
        if (k > n) return output;
        this.k = k;
        backtrack(output, new ArrayList<>(), n, k, 1);
        return output;
    }

    public void backtrack(List<List<Integer>> output, List<Integer> current,
                          int target, int numbers, int start) {
        if (numbers < 0 || target < 0) return;
        if (target == 0) {
            if (current.size() == k) output.add(new ArrayList(current));
            return;
        }
        for (int i = start; i <= 9; i++) {
            current.add(i);
            backtrack(output, current, target - i, numbers, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
