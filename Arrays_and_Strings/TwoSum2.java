package Arrays_and_Strings;

/*
Given an array of integers that is already sorted in ascending order, find
two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up
 to the target, where index1 must be less than index2.

Note:
    Your returned answers (both index1 and index2) are not zero-based.
    You may assume that each input would have exactly one solution and you may not use the same element twice.

*/
public class TwoSum2 {
    /* this solution uses two pointers technique to leverage the fact that we have a
        sorted array */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 1) return new int[0];
        
        int[] output = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                output[0] = i + 1;
                output[1] = j + 1;
                return output;
            }
            else if (sum > target){
                j--;
            }
            else if (sum < target) {
                i++;
            }
        }
        return output;
    }
}