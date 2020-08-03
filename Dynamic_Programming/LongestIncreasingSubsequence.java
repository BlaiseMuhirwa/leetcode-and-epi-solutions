package Dynamic_Programming;

/*
Given an unsorted array of integers, find the length of longest increasing subsequence.
Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
*/
public class LongestIncreasingSubsequence {
    /* This algorithm runs in O(n^2) time with O(n) space */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        int len = nums.length;
        int[] dp = new int[len];
        
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < len; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            result = Math.max(result, dp[i]);
        }
        return result;     
    }
}