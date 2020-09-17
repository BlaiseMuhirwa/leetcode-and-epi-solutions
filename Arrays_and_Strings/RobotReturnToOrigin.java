package Arrays_and_Strings;
import java.util.*;

/**
 * There is a robot starting at position (0, 0), the origin, on a 2D plane.
 * Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
 *
 * The move sequence is represented by a string, and the character moves[i]
 * represents its ith move. Valid moves are R (right), L (left), U (up), and D (down).
 * If the robot returns to the origin after it finishes all of its moves, return true.
 * Otherwise, return false.
 *
 * Note: The way that the robot is "facing" is irrelevant.
 * "R" will always make the robot move to the right once, "L" will always make
 * it move left, etc. Also, assume that the magnitude of the robot's movement
 * is the same for each move.
 */
public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) return true;

        Pair<Integer, Integer> start = new Pair(0, 0);

        for (char c : moves.toCharArray()) {
            int x = start.getKey();
            int y = start.getValue();
            if (c == 'R') {
                start = new Pair(x, y + 1);
            } else if (c == 'L') {
                start = new Pair(x, y - 1);
            } else if (c == 'U') {
                start = new Pair(x - 1, y);
            } else {
                start = new Pair(x + 1, y);
            }
        }
        return (start.getKey() == 0) && (start.getValue() == 0);
    }
}
