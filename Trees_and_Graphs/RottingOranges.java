package Trees_and_Graphs;
import java.util.*;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int rows = grid.length;
        int columns = grid[0].length;
        int freshOranges = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) freshOranges++;
                else if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }
        // indicate the ticker of timestamp
        queue.add(new Pair(-1, -1));

        //start the rotting process
        int minutesElapsed = -1;
        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int row = pair.getKey();
            int col = pair.getValue();

            if (row == -1) {
                //we finish one round of processing
                minutesElapsed++;
                //to avoid endless loop
                if (!queue.isEmpty()) {
                    queue.add(new Pair(-1, -1));
                }
            }
            else {
                for (int[] direction : directions) {
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];

                    if (nextRow >= 0 && nextRow < rows &&
                            nextCol >= 0 && nextCol < columns) {
                        if (grid[nextRow][nextCol] == 1) {
                            freshOranges--;
                            grid[nextRow][nextCol] = 2;
                            queue.add(new Pair(nextRow, nextCol));
                        }
                    }
                }
            }
        }
        return freshOranges == 0 ? minutesElapsed : -1;
    }
}
