package Arrays_and_Strings;
import java.util.*;
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

/**
 * Design a class to find the kth largest element in a stream. Note that
 * it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Your KthLargest class will have a constructor which accepts an integer k
 * and an integer array nums, which contains initial elements from the stream.
 * For each call to the method KthLargest.add, return the element representing
 * the kth largest element in the stream.
 */
public class KthLargestElementInAStream {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int k;
    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
