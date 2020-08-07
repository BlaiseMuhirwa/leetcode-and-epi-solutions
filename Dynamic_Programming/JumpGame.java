package dynamic_programming;

/* 
    Given an array of non-negative integers, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Determine if you are able to reach the last index.

    Input: nums = [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

    Input: nums = [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0,
     which makes it impossible to reach the last index.

*/


public class JumpGame {
    /* This algorithm runs in O(n) time. We can also solve this problem using dynamic 
    programming, although that approach takes O(n^2) time with O(n) space */
    public boolean canJump(int[] nums) {
        if (nums == null) return true;
        if (nums.length == 1) return true;
        int reachable = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (reachable < i) return false;
            reachable = Math.max(reachable, i+nums[i]);
        }
        return true;
    }
}