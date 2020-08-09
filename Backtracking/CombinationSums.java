package backtracking;
import java.util.*;

/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 find all unique combinations in candidates where the candidate numbers sums to target.
The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
*/
public class CombinationSums {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        
        findCombinationsSums(combinations, candidates, target, 0, new ArrayList<Integer>());
        return combinations;
    }
    
    private void findCombinationsSums(List<List<Integer>> combinations, int[] candidates,
                                     int target, int start, List<Integer> current) {
        if (target == 0) {
            combinations.add(new ArrayList<>(current));
            return;
        }
        else if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            findCombinationsSums(combinations, candidates, target - candidates[i], i, current);
            current.remove(current.size() - 1);
        }
    }
}