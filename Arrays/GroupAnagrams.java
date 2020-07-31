package Arrays;
import java.util.*;

/* 
    Given an array of strings, group anagrams together.
    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Output:
    [
        ["ate","eat","tea"],
        ["nat","tan"],
        ["bat"]
]
*/
public class GroupAnagrams {
    /* The following algorithm runs in O(N * KlogK), where N is the length of strs, and K is the 
        length of the longest string. Its space complexity is O(NK) */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return new ArrayList();
        }
        Map<String, List> map = new HashMap<String, List>();
        
        for (String str : strs) {
            char[] cArr = str.toCharArray();
            Arrays.sort(cArr);
            String key = String.valueOf(cArr);
            
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        
        return new ArrayList(map.values());      
    }
}