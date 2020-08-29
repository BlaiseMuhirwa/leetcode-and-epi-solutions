package Backtracking;
import java.util.*;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.

Example:
Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

*/
public class PalindromePartitioning {
    /* this algorithm runs in (n * 2^n), where n is the length of the input string */
    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<List<String>>();
        if (s == null || s.length() == 0)
            return output;

        ArrayList<String> palindromes = new ArrayList<>();
        helper(output, palindromes, s, 0);
        return output;
    }

    private void helper(List<List<String>> output, List<String> current, String s, int startIndex) {
        if (startIndex == s.length()) {
            output.add(new ArrayList<>(current));
            return;
        }
        int len = s.length();
        for (int i = startIndex; i < len; i++) {
            if (isPalindrome(s, startIndex, i)) {
                current.add(s.substring(startIndex, i + 1)); // choose
                helper(output, current, s, i + 1); // explore
                current.remove(current.size() - 1); // un-choose
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}