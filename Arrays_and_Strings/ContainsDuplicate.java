package Arrays_and_Strings;

import java.util.*;
public class ContainsDuplicate {
    /* Runtime: O(n); space complexity: O(n) */
    public static boolean containsDuplicate(int[] nums) {
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
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        System.out.println(containsDuplicate(input));
    }

}