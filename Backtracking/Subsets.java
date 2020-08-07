package backtracking;
import java.util.*;

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
public class Subsets {
    /* This algorithm runs in O(2^n), where n is the size of the original input array. 
        It's space complexity is O(n), which corresponds to the height of the recursion 
        tree 
    */
    public List<List<Integer>> subsets = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> subsets(int[] nums) {
        addSubsets(nums, 0, new ArrayList<Integer>());
        return subsets;
    }
    
    private void addSubsets(int[] nums, int start, ArrayList<Integer> current) {
        subsets.add(new ArrayList<>(current));
        
        for (int x = start; x < nums.length; x++) {
            current.add(nums[x]);
            addSubsets(nums, x+1, current);
            current.remove(current.size() - 1);
        }
        
    }
}