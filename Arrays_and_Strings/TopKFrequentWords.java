package Arrays_and_Strings;
import java.util.*;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest.
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Example:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> output = new ArrayList<>();
        if (words == null || words.length == 0) return output;

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>(
                (a, b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b));

        for (String key : map.keySet()) {
            heap.add(key);
            if (heap.size() > k) heap.poll();
        }
        while (heap.size() > 0) output.add(heap.poll());
        Collections.reverse(output);
        return output;
    }
}
