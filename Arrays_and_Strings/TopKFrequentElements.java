package Arrays_and_Strings;
import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * Example:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 * You can return the answer in any order.
 */
public class TopKFrequentElements {
    /**
     * Time complexity: O(N * logK)
     * Space complexity: O(N)
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] output = new int[k];
        if (nums == null || nums.length == 0) return output;

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (a, b) -> counts.get(a) - counts.get(b));

        for (int key : counts.keySet()) {
            heap.add(key);
            if (heap.size() > k) heap.poll();
        }
        int index = 0;
        while (heap.size() > 0) {
            output[index] = heap.poll();
            index++;
        }
        return output;
    }
}
