package Dynamic_Programming;
import java.util.*;

/* 
Given a non-empty string s and a dictionary wordDict containing a list of
 non-empty words, determine if s can be segmented into a space-separated
sequence of one or more dictionary words.

Note:
    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.
*/
public class WordBreak {
    /* top-down recursive approach with memoization */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }
        HashMap<String, Boolean> map = new HashMap<>();
        return dfs(s, set, map);
    }

    private boolean dfs(String s, Set<String> set, HashMap<String, Boolean> map) {
        if (s.isEmpty())
            return true;
        if (map.containsKey(s))
            return map.get(s);

        for (int i = 1; i <= s.length(); i++) {
            if (set.contains(s.substring(0, i)) && dfs(s.substring(i, s.length()), set, map)) {
                map.put(s.substring(0, i), true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }

    /* bottom-up dynamic programming approach */
    public boolean wordBreakBottomUp(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i < len; i++) {
                if (dp[i] && wordDict.contains(s.substring(i, len))) {
                    dp[len] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}