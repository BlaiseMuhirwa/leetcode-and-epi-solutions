package Arrays_and_Strings;

/* 
    Given a string s, find the longest palindromic substring in s. You may assume that
    the maximum length of s is 1000.
    Example 1: 
        Input: "babad"
        Output: "bab"
        Note: "aba" is also a valid answer.
    Example 2: 
        Input: "cbbd"
        Output: "bb"
*/
public class LongestPalindromeSubstring {
    /* the following algorithm runs in O(n^2) time - there is an O(n) algorithm for this
        problem although I will not show it here. You can look up Manacher's algorithm */
    int startingPoint = 0;
    int resLength = 0;
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        for (int i = 0; i < len-1; i++) {
            expandRange(s, i, i);
            expandRange(s, i, i+1);
        }
        return s.substring(startingPoint, startingPoint+resLength);
    }
    
    private void expandRange(String s, int start, int end) {
        while (start >= 0 && end < s.length() &&
               s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (resLength < end - start - 1) {
            resLength = end - start - 1;
            startingPoint = start + 1;
        }
    }
}