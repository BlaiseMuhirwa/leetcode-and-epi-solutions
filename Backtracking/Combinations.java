package Backtracking;
import java.util.List;
import java.util.ArrayList;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * You may return the answer in any order.
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combinations {
    /**
     * Time complexity: O(k * (n choose k)) wher (n choose k) or nCk is the
     * total number of combinations.
     * space complexity: O(nCk)
     */
    int numbers;
    int n;
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k > n) return output;
        this.numbers = k;
        this.n = n;
        recursivelyCombine(new ArrayList<>(), 1);
        return output;
    }

    public void recursivelyCombine(ArrayList<Integer> current, int start) {
        if (current.size() == this.numbers) {
            this.output.add(new ArrayList(current));
            return;
        }
        for (int j = start; j <= this.n; j++) {
            current.add(j);
            recursivelyCombine(current, j + 1);
            current.remove(current.size() - 1);
        }

    }
}
