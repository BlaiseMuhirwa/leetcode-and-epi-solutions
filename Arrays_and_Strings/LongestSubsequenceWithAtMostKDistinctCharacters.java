package Arrays_and_Strings;
import java.util.*;

/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.
*/
public class LongestSubsequenceWithAtMostKDistinctCharacters {
    /* this algorithm uses the idea of the sliding window technique with an auxilary data structure 
        it runs in O(n) time*/
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, longestSubstringLength = Integer.MIN_VALUE;
        while(j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if (map.size() <= k) {
                longestSubstringLength = Math.max(
                longestSubstringLength, j - i + 1);
            } else {
                while (map.size() > k) {
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