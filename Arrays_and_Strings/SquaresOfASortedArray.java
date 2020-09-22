package Arrays_and_Strings;
import java.util.*;

/**
 * Given an array of integers A sorted in non-decreasing order, return an array
 * of the squares of each number, also in sorted non-decreasing order.
 *
 *
 */
public class SquaresOfASortedArray {
    /**
     * this algorithm runs in O(n * logn) time. We can improve this by using two pointers
     * to achieve a O(n) runtime with O(n) space
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) return A;
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
