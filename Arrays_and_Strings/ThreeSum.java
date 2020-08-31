package Arrays_and_Strings;
import java.util.*;

/* 
Given an array nums of n integers, are there elements a, b, c in nums such
 that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
    The solution set must not contain duplicate triplets.
Example:
Given array nums = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if (nums == null || nums.length <= 2) return output;
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                twoSum(nums, i, -nums[i], output, nums[i]);
            }
        }
        return output;
    }
    
    private void twoSum(int[] nums, int i, int target,
                       List<List<Integer>> output, int first) {
        int start = i+1;
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                output.add(Arrays.asList(nums[start], nums[end], first));
                start++;
                end--;
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
            }
            else if (sum > target) {
                end--;
            }
            else if (sum < target) {
                start++;
            }
        }
        return;
    }
}