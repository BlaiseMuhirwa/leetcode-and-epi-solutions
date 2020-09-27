package Trees_and_Graphs;
import java.util.*;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 */
public class Matrix01 {
    int[][] output;
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;
        int rows = matrix.length;
        int cols = matrix[0].length;
        output = new int[rows][cols];


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) output[i][j] = 0;
                else {
                    bfs(matrix, i, j);
                }
            }
        }
        return output;
    }

    public void bfs(int[][] matrix, int i, int j) {
        LinkedList<Pair<int[], Integer>> queue = new LinkedList<>();
        queue.add(new Pair(new int[]{i, j}, 0));

        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            Pair<int[], Integer> pair = queue.poll();
            int row = pair.getKey()[0];
            int col = pair.getKey()[1];
            int dist = pair.getValue();

            if (matrix[row][col] == 0) {
                output[i][j] = dist;
                return;
            }
            for (int[] direct : directions) {
                int newX = row + direct[0];
                int newY = col + direct[1];
                if (newX < 0 || newX >= matrix.length ||
                        newY < 0 || newY >= matrix[0].length) continue;
                queue.add(new Pair(new int[]{newX, newY}, dist + 1));
            }

        }

    }
}
