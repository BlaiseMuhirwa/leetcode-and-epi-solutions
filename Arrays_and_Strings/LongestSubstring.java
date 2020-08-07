package arrays_and_strings;
import java.util.*;

/* 
    Given a string, find the length of the longest substring without repeating characters.
    Input: "abcabcbb"
    Output: 3 
    Explanation: The answer is "abc", with the length of 3.

    Input: "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.
*/

public class LongestSubstring {
    /* This algorithm runs in O(n) time */
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        
        int longest = 0, i = 0, j = 0;
        int len = s.length();
        while (i < len && j < len) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                j++;
                longest = Math.max(longest, j-i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return longest;
    }
}