package Arrays_and_Strings;
import java.util.*;

/**
 * We can represent a sentence as an array of words, for example, the sentence "I am happy with leetcode"
 * can be represented as arr = ["I","am",happy","with","leetcode"].
 * Given two sentences sentence1 and sentence2 each represented as a string array and given an array
 * of string pairs similarPairs where similarPairs[i] = [xi, yi] indicates
 * that the two words xi and yi are similar.
 *
 * Return true if sentence1 and sentence2 are similar, or false if they are not similar.
 * Two sentences are similar if:
 * They have the same length (i.e. the same number of words)
 * sentence1[i] and sentence2[i] are similar.
 * Notice that a word is always similar to itself, also notice that the similarity
 * relation is not transitive. For example, if the words a and b are similar and
 * the words b and c are similar, a and c are not necessarily similar.
 *
 * Input: sentence1 = ["great","acting","skills"],
 *        sentence2 = ["fine","drama","talent"],
 *        similarPairs = [["great","fine"],["drama","acting"],["skills","talent"]]
 * Output: true
 * Explanation: The two sentences have the same length and each word i of sentence1
 * is also similar to the corresponding word in sentence2.
 */
public class SentenceSimilarity {
    /**
     * The time complexity of this algorithm is O(max(n, m)) where n is the length of
     * the input strings, and m is the length of the list of similar pairs.
     * The space complexity is O(m) since we need to store each element in the input
     * list of similar pairs.
     * @param sentence1 : first string
     * @param sentence2 : second string
     * @param similarPairs : list of similar pairs
     * @return : true if two sentences are similar, and false otherwise
     */
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;

        Map<String, Set<String>> pairs = new HashMap<>();
        for (List<String> pair : similarPairs) {
            Set<String> set1 = pairs.getOrDefault(pair.get(0), new HashSet<>());
            Set<String> set2 = pairs.getOrDefault(pair.get(1), new HashSet<>());

            set1.add(pair.get(1));
            set2.add(pair.get(0));
            pairs.put(pair.get(0), set1);
            pairs.put(pair.get(1), set2);
        }
        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) continue;

            if (!pairs.containsKey(sentence1[i])) return false;

            if (!pairs.get(sentence1[i]).contains(sentence2[i])) {
                return false;
            }
        }
        return true;

    }
}
