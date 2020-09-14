package Arrays_and_Strings;
import java.util.*;

/**
 * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d]
 * if and only if either (a==c and b==d), or (a==d and b==c) - that is,
 * one domino can be rotated to be equal to another domino.
 *
 * Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length,
 * and dominoes[i] is equivalent to dominoes[j].
 */
public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int counter = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] domino : dominoes) {
            int key = dominoRepresentation(domino);
            map.put(key, map.getOrDefault(key, -1) + 1);
            if (map.get(key) >= 1) {
                counter += map.get(key);
            }
        }
        return counter;
    }

    public int dominoRepresentation(int[] domino) {
        boolean firstSmaller = domino[0] < domino[1];
        return (firstSmaller) ? (domino[0] * 10) + domino[1] :
                (domino[1] * 10) + domino[0];
    }
}
