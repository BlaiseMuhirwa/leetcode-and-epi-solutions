package Arrays_and_Strings;
import java.util.*;

/**
 * Given an array of integers and an integer k, you need to find the number of
 * unique k-diff pairs in the array. Here a k-diff pair is defined as an integer
 * pair (i, j), where i and j are both numbers in the array and their
 * absolute difference is k.
 */
public class KDiffPairs {
    /**
     * This algorithms runs in O(n*logn) time and its space complexity
     * is O(n) from the sorting part.
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        int j = 1;
        int counter = 0;
        Arrays.sort(nums);
        while (i < nums.length && j < nums.length) {
            int diff = Math.abs(nums[j] - nums[i]);
            if (i == j || nums[j] - nums[i] < k) {
                j++;
            }
            else if (nums[j] - nums[i] > k) {
                i++;
            }
            else {
                i++;
                counter++;
                while (i < nums.length && nums[i] == nums[i-1]) i++;
            }
        }
        return counter;
    }
}
