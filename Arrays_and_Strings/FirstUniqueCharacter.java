package arrays_and_strings;
import java.util.*;
/*
    Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
    s = "leetcode"
    return 0.

    s = "loveleetcode"
    return 2.
    Note: You may assume the string contains only lowercase English letters.
*/
public class FirstUniqueCharacter {
    /* This implementation takes O(n) time and O(1) space since the alpabet has a constant number of characters */
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) 
                return i;
        }
        return -1;
    }
}