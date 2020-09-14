package Arrays_and_Strings;
import java.util.*;

/**
 * Given a paragraph and a list of banned words, return the most frequent word
 * that is not in the list of banned words.  It is guaranteed there is at least
 * one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.
 * Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 * Example:
 * Input:
 *       paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 *       banned = ["hit"]
 * Output: "ball"
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        String str = "";
        String[] words = paragraph.replaceAll(
                "[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
        Set<String> set = new HashSet<>();
        for (String s : banned) {
            set.add(s);
        }
        Map<String, Integer> frequency = new HashMap<>();
        int maxValue = Integer.MIN_VALUE;
        for (String word : words) {
            if (!set.contains(word)) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
                maxValue = Math.max(maxValue, frequency.get(word));
            }
        }

        for (String key : frequency.keySet()) {
            if (frequency.get(key) == maxValue) return key;
        }
        return null;
    }
}
