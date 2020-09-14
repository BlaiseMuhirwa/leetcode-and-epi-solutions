package Arrays_and_Strings;
import java.util.*;

/**
 * You are given an array of strings words and a string chars.
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 *
 * Return the sum of lengths of all good strings in words.
 */
public class WordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        if (chars == null || chars.length() == 0) return 0;
        if (words == null || words.length == 0) return 0;

        int output = 0;
        Map<Character, Integer> map = getMap(chars);

        for (String str : words) {
            if (str.length() > chars.length()) continue;
            if (str.length() > 100) continue;

            int counter = 0;
            for (char c : str.toCharArray()) {
                if (map.containsKey(c) && map.get(c) > 0) {
                    counter += 1;
                    map.put(c, map.get(c) - 1);
                } else {
                    counter = 0;
                    break;
                }
            }
            output += counter;
            map = getMap(chars);
        }
        return output;
    }

    public Map<Character, Integer> getMap(String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
