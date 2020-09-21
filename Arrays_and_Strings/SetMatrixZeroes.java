package Arrays_and_Strings;
import java.util.*;

/**
 * Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
 */
public class SetMatrixZeroes {
    /**
     * Time complexity: O(m*n)
     * Space complexity: O(m+n)
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
