package Arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        /* This algorithm uses the two-pointers method 
            It runs in O(n) time and O(1) space */
        if (nums.length == 0) {
            return 0;
        }
        else if (nums.length == 1) {
            return 1;
        }
        int newLength = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[newLength] != nums[i]) {
                newLength++;
                nums[newLength] = nums[i];
            }
        }
        
        return newLength+1;
    }
}