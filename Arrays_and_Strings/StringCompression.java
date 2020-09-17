package Arrays_and_Strings;

/**
 * Given an array of characters chars, compress it using the following algorithm:
 *
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 *
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead
 * be stored in the input character array chars. Note that group lengths that
 * are 10 or longer will be split into multiple characters in chars.
 *
 * After you are done modifying the input array, return the new length of the array.
 */
public class StringCompression {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            int counter = 1;
            while (i + 1 < chars.length && chars[i] == chars[i+1]) {
                i++;
                counter++;
            }
            if (counter == 1) {
                output.append(current);
            } else {
                output.append(current);
                output.append(counter);
            }
        }
        String newString = output.toString();
        for (int i = 0; i < newString.length(); i++) {
            chars[i] = newString.charAt(i);
        }
        return newString.length();
    }
}
