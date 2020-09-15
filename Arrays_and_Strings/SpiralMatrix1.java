package Arrays_and_Strings;
import java.util.List;
import java.util.ArrayList;

/**
 * Given a matrix of m x n elements (m rows, n columns),
 * return all elements of the matrix in spiral order.
 */
public class SpiralMatrix1 {
    List<Integer> output = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return output;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length -1;
        int size = matrix.length * matrix[0].length;

        while (output.size() < size) {
            for (int i = left; i <= right && output.size() < size; i++) {
                output.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom && output.size() < size; i++) {
                output.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && output.size() < size; i--) {
                output.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top && output.size() < size; i--) {
                output.add(matrix[i][left]);
            }
            left++;

        }
        return output;
    }
}
