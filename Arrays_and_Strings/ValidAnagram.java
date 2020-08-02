package Arrays_and_Strings;
import java.util.*;

/* 
    Given two strings s and t , write a function to determine if t is an anagram of s.
    Input: s = "anagram", t = "nagaram"
    Output: true

    Input: s = "rat", t = "car"
    Output: false
*/
public class ValidAnagram {
    /* This algorithm runs in O(n) time and O(n) space. Notice that this
     can be done with constant space */ 
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        for (int j = 0; j < t.length(); j++) {
            if (!map.containsKey(t.charAt(j))) {
                return false;
            } else if (!(map.get(t.charAt(j)) > 0)){
                return false;
            } else {
                map.put(t.charAt(j), map.get(t.charAt(j)) - 1);
            }
        }
        return true;
}