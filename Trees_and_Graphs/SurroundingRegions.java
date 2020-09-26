package Trees_and_Graphs;
import java.util.*;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * Output:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class SurroundingRegions {
    /**
     * This algorithm runs in O(n) time with O(n) space complexity
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;
        List<Pair<Integer, Integer>> borders = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            borders.add(new Pair(i, 0));
            borders.add(new Pair(i, cols - 1));
        }
        for (int j = 0; j < cols; j++) {
            borders.add(new Pair(0, j));
            borders.add(new Pair(rows - 1, j));
        }

        for (Pair<Integer, Integer> pair : borders) {
            dfs(board, pair.getKey(), pair.getValue());
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '*') board[i][j] = 'O';
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length ||
                j >= board[0].length || board[i][j] != 'O') return;

        board[i][j] = '*';
        dfs(board, i + 1, j);
        dfs(board, i, j + 1);
        dfs(board, i - 1, j);
        dfs(board, i, j - 1);


    }
}
