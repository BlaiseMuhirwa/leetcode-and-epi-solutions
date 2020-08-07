package backtracking;
import java.util.*;

/*
Given a collection of distinct integers, return all possible permutations.
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
Can you implement this iteratively?
*/
public class Permutations {
    public List<List<Integer>> permutations = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> permute(int[] nums) {
        addPermutations(nums, nums.length, 0);
        return permutations;
    }
    
    private void addPermutations(int[] nums, int length, int start) {
        if (start == length) {
            ArrayList<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            permutations.add(permutation);
            return;
        } else {
            for (int x = start; x < length; x++) {//make a choice about which number to pick first
                swap(nums, start, x);
                addPermutations(nums, length, start+1);
                swap(nums, start, x); //backtrack
            }
        }
    }
    
    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}