package Arrays_and_Strings;

/**
 * Given a binary matrix A, we want to flip the image horizontally, then invert it,
 * and return the resulting image.
 * To flip an image horizontally means that each row of the image is reversed.
 * For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 *
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 * For example, inverting [0, 1, 1] results in [1, 0, 0].
 */
public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0) return A;

        for (int[] row : A) {
            reverseArray(row);
        }
        for(int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) A[i][j] = 0;
                else A[i][j] = 1;
            }
        }
        return A;
    }

    public void reverseArray(int[] A) {
        int i = 0, j = A.length - 1;
        while(i < j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }
}
