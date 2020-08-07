package arrays_and_strings;
import java.util.*;
/* 
    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    Note: For the purpose of this problem, we define empty string as valid palindrome.
    Examples:
        Input: "A man, a plan, a canal: Panama"
        Output: true

        Input: "race a car"
        Output: false
*/


public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) return true;
        s = s.toLowerCase();
        ArrayList<Character> charList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < 'a' || s.charAt(i) > 'z') {
                if (isNumeric(s.charAt(i))) {
                    charList.add(s.charAt(i));
                } else {
                    continue;
                }
            } else {
                charList.add(s.charAt(i));
            }
        }
        char[] newCharArray = new char[charList.size()];
        for (int j = 0; j < charList.size(); j++) {
            newCharArray[j] = charList.get(j);
        }
        String newString = String.valueOf(newCharArray);
        int i = 0, j = newString.length() -1;
        while (i < j) {
            if (newString.charAt(i) != newString.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    private boolean isNumeric(char c) {
        if (c == '1' || c == '2' || c == '3' ||c == '4' ||c == '5'
            || c == '6' || c == '7' ||c == '8' || c == '9'|| c == '0') {
            return true;
        } else {
            return false;
        }
    }

    /* The following is an alternative solution, which is much cleaner 
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                builder.append(Character.toLowerCase(c));
            }
        }
        String original = builder.toString();
        String reversed = builder.reverse().toString();

        return original.equals(reversed);

    }
    */
}