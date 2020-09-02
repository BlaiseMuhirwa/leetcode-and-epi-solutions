package Arrays_and_Strings;
import java.util.*;
/*
Given an array of size n, find the majority element. The majority element is the
element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

*/
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int key : nums) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int floor = nums.length / 2;
        int majElement = -1;
        for (int key : map.keySet()) {
            if (map.get(key) > floor) {
                majElement = key;
            }
        }
        return majElement;
    }
}