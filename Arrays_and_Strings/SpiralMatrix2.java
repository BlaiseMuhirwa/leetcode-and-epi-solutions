package Arrays_and_Strings;

/**
 * Given a positive integer n, generate a square matrix filled with elements
 * from 1 to n2 in spiral order.
 * Example:
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrix2 {
    /**
     * time complexity: O(n * n)
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] output = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int counter = 1;
        int squared = n * n;
        while (counter <= squared) {
            for (int i = left; i <= right && counter <= squared; i++) {
                output[top][i] = counter++;
            }
            top++;
            for (int i = top; i <= bottom && counter <= squared; i++) {
                output[i][right] = counter++;
            }
            right--;
            for (int i = right; i >= left && counter <= squared; i--) {
                output[bottom][i] = counter++;
            }
            bottom--;
            for (int i = bottom; i >= top && counter <= squared; i --) {
                output[i][left] = counter++;
            }
            left++;
        }
        return output;

    }
}
