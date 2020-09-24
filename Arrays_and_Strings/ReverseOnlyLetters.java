package Arrays_and_Strings;
import java.util.LinkedList;

/**
 * Given a string S, return the "reversed" string where all characters
 * that are not a letter stay in the same place, and all letters reverse their positions.
 *
 * Example:
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 */
public class ReverseOnlyLetters {
    /**
     * The idea here is to notice that a stack will be very helpful in getting items
     * from the back of the string
     * @param S
     * @return
     */
    public String reverseOnlyLetters(String S) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : S.toCharArray()) {
            if (Character.isAlphabetic(c)) stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (!Character.isAlphabetic(c)) sb.append(c);
            else sb.append(stack.pop());
        }
        return sb.toString();
    }
}
