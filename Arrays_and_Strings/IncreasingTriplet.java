package arrays_and_strings;

/* 
    Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

    Formally the function should:
    Return true if there exists i, j, k such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
    Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

*/

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3 || nums == null) {
            return false;
        }
        int small = Integer.MAX_VALUE, large = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= large) {
                large = num;
            } else {
                return true;
            }
        }
        return false;
        
    }
}