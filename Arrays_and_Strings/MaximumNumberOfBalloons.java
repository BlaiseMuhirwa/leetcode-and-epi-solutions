package Arrays_and_Strings;

/**
 * Given a string text, you want to use the characters of text to form
 * as many instances of the word "balloon" as possible.
 *
 * You can use each character in text at most once.
 * Return the maximum number of instances that can be formed.
 */
public class MaximumNumberOfBalloons {
    /**
     * This algorithm runs in O(n) time, where n is the length of the input string.
     * Its space complexity is O(1)
     * @param text
     * @return
     */
    public int maxNumberOfBalloons(String text) {
        if (text == null || text.length() == 0) return 0;

        int bCounter = 0, aCounter = 0, lCounter = 0;
        int oCounter = 0, nCounter = 0;

        for (char c : text.toCharArray()) {
            if (c == 'b') bCounter++;
            else if (c == 'a') aCounter++;
            else if (c == 'l') lCounter++;
            else if (c == 'o') oCounter++;
            else if (c == 'n') nCounter++;
        }
        return findMin(bCounter, aCounter, lCounter/2, oCounter/2, nCounter);
    }

    private int findMin(int a, int b, int c, int d, int e) {
        int minABC = Math.min(Math.min(a, b), c);
        return Math.min(minABC, Math.min(d, e));
    }
}
