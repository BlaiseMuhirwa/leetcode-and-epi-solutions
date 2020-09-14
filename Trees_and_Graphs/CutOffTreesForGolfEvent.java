package Trees_and_Graphs;
import java.util.*;


public class CutOffTreesForGolfEvent {
    private int rows, cols;
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) return 0;
        this.rows = forest.size();
        this.cols = forest.get(0).size();

        List<Integer> trees = new ArrayList<>();
        Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int height = forest.get(i).get(j);
                if(height > 1) {
                    trees.add(height);
                    map.put(height, new Pair(i, j));
                }
            }
        }
        int startX = 0;
        int startY = 0;
        int result = 0;
        Collections.sort(trees);
        for (int tree : trees) {
            int endX = map.get(tree).getKey();
            int endY = map.get(tree).getValue();
            int steps = bfs(forest, startX, startY, endX, endY);
            if (steps == -1) return -1;

            result += steps;
            startX = endX;
            startY = endY;
        }
        return result;
    }

    private int bfs(List<List<Integer>> forest, int startX, int startY,
                    int endX, int endY) {
        int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        int[][] visited = new int[this.rows][this.cols];

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(startX, startY));
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Pair<Integer, Integer> curr = queue.poll();
                int x = curr.getKey();
                int y = curr.getValue();
                if (x == endX && y == endY) {
                    return steps;
                }
                for (int[] direc : directions) {
                    int newX = x + direc[0];
                    int newY = y + direc[1];
                    if (newX < 0 || newX >= rows || newY < 0 || newY >= cols ||
                            forest.get(newX).get(newY) == 0 || visited[newX][newY] == 1) {
                        continue;
                    }
                    queue.add(new Pair(newX, newY));
                    visited[newX][newY] = 1;
                }
                size--;
            }
            steps++;
        }
        return -1;
    }
}
