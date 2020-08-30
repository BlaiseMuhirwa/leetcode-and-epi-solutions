package Dynamic_Programming;
import java.util.*;

/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
*/

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
public class RangeSumQuery {
    /* array for caching sums from the input array provided 
        in the constructor */
    private int[] numArray;
    private int len; 
    public RangeSumQuery(int[] nums) {
        this.len = nums.length;
        if (len == 0) {
            return;
        }
        else {
            this.numArray = new int[len+1];
            numArray[0] = 0;
            numArray[1] = nums[0];
            int sum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum += nums[i];
                numArray[i+1] = sum;
            }
        }
    }
    
    public int sumRange(int i, int j) {
        return this.numArray[j+1] - this.numArray[i];
    }
}