package Dynamic_Programming;
import java.util.*;

/* 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * Example: 
 * Input: "12"
    Output: 2
    Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 **/
public class DecodeWays {
    Map<Integer, Integer> memo = new HashMap<>();
    public int numDecodings(String s) {
        if (s == null) return 0;
        if (s.length() == 0) return 0;
        return findWays(s, 0);
    }
    
    private int findWays(String s, int index) {
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (index == s.length()-1) {
            return 1;
        }
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        int ans = findWays(s, index+1);
        if (Integer.parseInt(s.substring(index, index+2)) <= 26) {
            ans += findWays(s, index+2);
        }
        memo.put(index, ans);
        return ans;
    }
}