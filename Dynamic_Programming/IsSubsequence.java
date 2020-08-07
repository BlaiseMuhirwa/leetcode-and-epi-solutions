package dynamic_programming;

/*
Given a string s and a string t, check if s is subsequence of t.
A subsequence of a string is a new string which is formed from 
the original string by deleting some (can be none) of the characters 
without disturbing the relative positions of the remaining characters. 
(ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B,
 and you want to check one by one to see if T has its subsequence.
  In this scenario, how would you change your code?

*/
public class IsSubsequence {
    /* This algorithm runs in O(n) time with O(1) space */
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        if (s.equals("") && t != null) return true;
        
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(index)) {
                index++;
            }
            if (index >= s.length()) return true;
        }
        return false;
        
    }
}