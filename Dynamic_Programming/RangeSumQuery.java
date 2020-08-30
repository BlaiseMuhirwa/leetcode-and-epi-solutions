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
    /* this is a very slow brute-force approach that takes O(n) time */
    private int[] numArray;
    public RangeSumQuery(int[] nums) {
        this.numArray = new int[nums.length];
        numArray = nums;
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        for (int start = i; start <= j; start++) {
            sum += this.numArray[start];
        }
        return sum;
    }
}