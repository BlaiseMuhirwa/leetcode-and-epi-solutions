package Arrays_and_Strings;
import java.util.*;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 * Hint: the key to solving this problem is to realize that if a string can form
 * a palindrome then at most one character can have an odd count of occurences if
 * the length of the string is odd.
 * If the length of the string is even, then no character can have an odd count of
 * occurences.
 */
public class PalindromePermutation {
    /**
     * this algorithm runs in O(n) time where n is the length of the input string
     * its space complexity is also O(n) since asymptotically we have to store
     * every character in the hashmap
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        if (s.length() % 2 == 0) {
            for (char c : map.keySet()) {
                if (map.get(c) % 2 != 0) return false;
            }
            return true;
        }
        int countOdd = 0;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 1) {
                if (countOdd >= 1) return false;
                countOdd++;
            }
        }
        return true;
    }
}
