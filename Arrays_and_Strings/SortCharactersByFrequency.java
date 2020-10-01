package Arrays_and_Strings;
import java.util.*;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 */
public class SortCharactersByFrequency {
    /**
     * Time complexity: O(n logn): first for-loop takes O(n) time to insert in a
     * hashmap. The second for-loop takes O(n*logn) time to insert in a heap,
     * and the while loop in the end takes O(n) time to remove items in the
     * priority queue.
     * Space: O(n)
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return s;
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Pair<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char key : map.keySet()) {
            Pair<Character, Integer> pair = new Pair(key, map.get(key));
            if (pair != null) maxHeap.add(pair);
        }

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Pair<Character, Integer> pair = maxHeap.poll();
            char c = pair.getKey();
            int count = pair.getValue();
            while (count > 0) {
                sb.append(c);
                count--;
            }
        }
        return sb.toString();
    }
}
