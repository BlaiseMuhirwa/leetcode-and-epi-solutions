package Arrays_and_Strings;
import java.util.*;

/* 
Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
*/
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 2) return s.length();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, longestSubstringLength = Integer.MIN_VALUE;
        
        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if (map.size() <= 2) {
                longestSubstringLength = Math.max(
                longestSubstringLength, j - i + 1);
            } else {
                while (map.size() > 2) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0) {
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
            }
            j++;
        }
        return longestSubstringLength;
    }
}