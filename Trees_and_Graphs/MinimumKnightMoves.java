package Trees_and_Graphs;
import java.util.Map;
import java.util.HashMap;

/**
 * In an infinite chess board with coordinates from -infinity to +infinity,
 * you have a knight at square [0, 0].
 * A knight has 8 possible moves it can make, as illustrated below.
 * Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
 *
 * Return the minimum number of steps needed to move the knight to the square [x, y].
 * It is guaranteed the answer exists.
 */
public class MinimumKnightMoves {
    private Map<String, Integer> map = new HashMap<>();
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        if (x + y == 0) return 0;
        if (x + y == 2) return 2;

        String key = x + "*" + y;
        if (map.containsKey(key)) return map.get(key);
        int count = Math.min(minKnightMoves(x-2, y-1), minKnightMoves(x-1, y-2)) + 1;
        map.put(key, count);
        return count;

    }
}
