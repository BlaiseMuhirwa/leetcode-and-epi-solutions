package Backtracking;
import java.util.*;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * Example:
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class Permutations2 {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return output;

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        findUniquePermutations(nums, new ArrayList<>(), visited);
        return output;
    }

    public void findUniquePermutations(int[] nums, List<Integer> current,
                                       boolean[] visited) {
        if (nums.length == current.size()) {
            output.add(new ArrayList(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            current.add(nums[i]);
            visited[i] = true;
            findUniquePermutations(nums, current, visited);
            current.remove(current.size() - 1);
            visited[i] = false;
            while (i + 1 < nums.length && nums[i] == nums[i+1]) {
                i++;
            }
        }
    }
}
