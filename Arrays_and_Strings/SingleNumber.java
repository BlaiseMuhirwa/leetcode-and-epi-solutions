package Arrays_and_Strings;
import java.util.*;
public class SingleNumber {
    /* the algorithm runs in O(nlogn) time with O(1) extra space 
        Notice that this algorithm can also run in O(n) with O(n) extra space */
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int value = 0;
        for (int i = 1; i < nums.length-1; i++) {
            /* check if the unique number if at the start */
            if (nums[i] != nums[0] && i == 1) {
                value = nums[0];
            }
            /* check if the unique number is in the middle */
            else if (nums[i] != nums[i+1] && nums[i] != nums[i-1]) {
                value = nums[i];
            }
            /* check if the unique number is at the end */
            else if (i+1 == nums.length-1 && nums[i+1] != nums[i]) {
                value = nums[i+1];
            }
           
        }
        return value;
    }
}