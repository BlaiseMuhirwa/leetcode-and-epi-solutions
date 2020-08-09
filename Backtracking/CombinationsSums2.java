package backtracking;
import java.util.*;
/*
Given a collection of candidate numbers (candidates) and a target number (target),
 find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/
public class CombinationsSums2 {
    /* The run-time for this algorithm is O(2^n) since we are generating all combinations. 
        the space complexity is O(n) since we grow the stack frame with every recursive call */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        findCombinations(combinations, candidates,target, 0, new ArrayList<>());
        return combinations;
    }
    
    private void findCombinations(List<List<Integer>> combinations, int[] candidates,
                                  int target, int start, ArrayList<Integer> current) {
        if (target == 0) {
            combinations.add(new ArrayList<>(current));
            return;
        }
        else if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            if (i == start || candidates[i] != candidates[i-1]) {
                current.add(candidates[i]);
                findCombinations(combinations, candidates, target - candidates[i], i+1, current);
                current.remove(current.size() - 1);
            }
        }
        
    }
    
}