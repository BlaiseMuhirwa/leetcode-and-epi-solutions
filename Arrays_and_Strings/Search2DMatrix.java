package Arrays_and_Strings;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */
public class Search2DMatrix {
    /**
     * Time complexity: O(log(m * n)), where m * n is the size of the input array
     * space complexity: O(1)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int pivot = (left + right) / 2;
            int row = pivot / n;
            int col = pivot % n;
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return false;
    }
}
