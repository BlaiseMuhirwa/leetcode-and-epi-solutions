package Arrays_and_Strings;
import java.util.*;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s
 * elements are subset of nums2. Find all the next greater numbers for nums1's
 * elements in the corresponding places of nums2.
 *
 * The Next Greater Number of a number x in nums1 is the first greater number to
 * its right in nums2. If it does not exist, output -1 for this number.
 */
public class NextGreaterElement {
    /**
     * Time complexity: O(m + n) where m is the size of nums1, and n is the size of
     * nums2
     * Space complexity: O(m + n) as well.
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        LinkedList<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] output = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            output[i] = map.get(nums1[i]);
        }
        return output;
    }
}
