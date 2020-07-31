package Arrays_and_Strings;

public class RotateArray {
    /* The following algorithm runs in O(n) time with O(1) extra space */
    /* First, we reverse the entire array inplace. Then, we reverse the first k elements 
        in the array. Finally, we reverse the remaining n-k elements */
         
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 1) {
            return;
        }
        k %= nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k-1);
        rotate(nums, k, nums.length - 1);
        
    }
    private void rotate(int[]nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}