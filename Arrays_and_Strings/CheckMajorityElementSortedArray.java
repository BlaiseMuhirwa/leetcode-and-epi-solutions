package Arrays_and_Strings;

/* 
Given an array nums sorted in non-decreasing order, and a number target, return True
if and only if target is a majority element.
A majority element is an element that appears more than N/2 times in an array of length N.
*/
public class CheckMajorityElementSortedArray {
    public boolean isMajorityElement(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        
        int floor = nums.length / 2;
        int counter = 0;
        for (int num : nums) {
            if (target == num) counter++;
            if (counter > floor) return true;
        }
        return false;
    }
}