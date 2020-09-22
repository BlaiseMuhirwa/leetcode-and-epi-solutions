package Backtracking;
import java.util.List;

/**
 * Given an array of strings arr. String s is a concatenation of a sub-sequence
 * of arr which have unique characters.
 * Return the maximum possible length of s.
 *
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 *
 * Constraints:
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lower case English letters.
 */
public class MaximumLengthOfConcatenatedStringWithUniqueCharacters {
    int maxLength = 0;
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) return 0;

        findMaxLength(arr, 0, "");
        return maxLength;
    }

    public void findMaxLength(List<String> arr, int index, String current) {
        if (index == arr.size()) {
            if (countUnique(current) > maxLength) {
                maxLength = current.length();
            }
            return;
        }
        findMaxLength(arr, index + 1, current + arr.get(index));
        findMaxLength(arr, index + 1, current);
    }

    public int countUnique(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            if (arr[c - 'a'] > 0) {
                return -1;
            }
            arr[c - 'a']++;
        }
        return s.length();
    }
}
