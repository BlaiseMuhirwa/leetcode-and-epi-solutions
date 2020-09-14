package Dynamic_Programming;

/**
 * Given a list of non-negative numbers and a target integer k,
 * write a function to check if the array has a continuous subarray
 * of size at least 2 that sums up to a multiple of k, that is,
 * sums up to n*k where n is also an integer.
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        if (k == 0) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] + nums[i+1] == 0) return true;
            }
            return false;
        }
        int i = 0, len = nums.length;
        while (i < len) {
            int j = i + 1;
            int sum = nums[i];
            while (j < len) {
                sum += nums[j];
                if (sum % k == 0) return true;
                j++;
            }
            i++;
        }
        return false;

    }
}
