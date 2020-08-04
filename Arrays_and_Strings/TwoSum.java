package Arrays_and_Strings;
import java.util.*;
/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
public class TwoSum {
    /* The run time of this algorithm is O(n), and it takes O(n) space in the worst case,
        since we would need to hash up to the last element */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 1) {
            return null;
        }
        /* we map every number with its index */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int index1 = i;
                int index2 = map.get(target - nums[i]);
                return new int[] {index1, index2};
            }
            map.put(nums[i], i);
        }
        return null;
        
    }
}