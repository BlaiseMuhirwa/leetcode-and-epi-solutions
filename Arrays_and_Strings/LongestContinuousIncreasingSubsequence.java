package Arrays_and_Strings;

/* 
    Given an unsorted array of integers, find the length of longest continuous
    increasing subsequence (subarray).
    Input: [1,3,5,4,7]
    Output: 3
    Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 
                Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous
                one where 5 and 7 are separated by 4. 

*/
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) {
            return nums.length;
        }
        int i = 0, j = 1, len = nums.length;
        int count = 1;
        while (i < len && j < len) {
            if (nums[j] > nums[j-1]) {
                count = Math.max(count, j - i + 1);
                j++;
            } else {
                while (i < j) {
                    i++;
                }
                j++;
            }
        }
        return count;
    }
}