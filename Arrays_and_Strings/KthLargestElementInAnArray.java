package Arrays_and_Strings;
import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 */
public class KthLargestElementInAnArray {
    /**
     * This algorithm runs in O(n * logn). Nonetheless, we can slightly optimize
     * to get O(n * log K)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) pq.add(-num);

        int index = 1;
        int output = 0;
        while (true) {
            output = pq.poll();
            if (index == k) {
                break;
            }
            index++;
        }
        return -output;
    }
}
