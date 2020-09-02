package Arrays_and_Strings;
import java.util.*;

/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
Note: The algorithm should run in linear time and in O(1) space.

*/

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> output = new ArrayList<>();
        if (nums == null || nums.length == 0) return output;
        
        // first pass 
        int count1 = 0, count2 = 0;
        Integer candidate1 = null;
        Integer candidate2 = null;
        for (int num : nums) {
            if (candidate1 != null && candidate1 == num) {
                count1++;
            } else if (candidate2 != null && candidate2 == num) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        //second pass
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (candidate1 != null && candidate1 == num) count1++;
            if (candidate2 != null && candidate2 == num) count2++;
        }
        int floor = nums.length / 3;
        if (count1 > floor) output.add(candidate1);
        if (count2 > floor) output.add(candidate2);
        
        return output;
    }
}