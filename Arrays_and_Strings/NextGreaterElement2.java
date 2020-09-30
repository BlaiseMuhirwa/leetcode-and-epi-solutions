package Arrays_and_Strings;
import java.util.*;

/**
 * Given a circular array (the next element of the last element is the first
 * element of the array), print the Next Greater Number for every element.
 * The Next Greater Number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, output -1 for this number.
 */
public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        LinkedList<Integer> stack = new LinkedList<>();
        int[] output = new int[nums.length];
        Arrays.fill(output, -1);
        for (int i = 0; i < len * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                output[stack.pop()] = nums[i % len];
            }
            if (i < len) stack.push(i);
        }

        return output;
    }
}
