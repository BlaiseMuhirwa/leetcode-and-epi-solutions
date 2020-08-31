package Arrays_and_Strings;

/*
Given an array of n positive integers and a positive integer s, find the minimal
length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
*/
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0] >= s ? 1 : 0;
        
        int i = 0;
        int j = 0;
        int currentRunningSum = 0;
        int minSize = Integer.MAX_VALUE;
        while (j < nums.length) {
            currentRunningSum += nums[j];
            while (currentRunningSum >= s) {
                minSize = Math.min(minSize, j - i + 1);
                currentRunningSum -= nums[i];
                i++;
            }
            j++;
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}