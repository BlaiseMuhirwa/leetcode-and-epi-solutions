package arrays_and_strings;

import java.util.*;
public class ContainsDuplicate {
    /* Runtime: O(n); space complexity: O(n) */
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.putIfAbsent(nums[i], 1) != null) {
                return true;
            }
        }
        return false;
    }

}