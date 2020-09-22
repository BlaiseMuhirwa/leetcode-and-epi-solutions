package Arrays_and_Strings;

/**
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 *
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 */
public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] output = new int[nums.length];
        if (nums == null || nums.length == 0) return output;

        int first = 0, index = 0;
        while (n < nums.length) {
            output[index++] = nums[first];
            output[index++] = nums[n];
            first++;
            n++;
        }
        return output;
    }
}
