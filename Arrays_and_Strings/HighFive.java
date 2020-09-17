package Arrays_and_Strings;
import java.util.*;

/**
 * Given a list of scores of different students, return the average score of
 * each student's top five scores in the order of each student's id.
 *
 * Each entry items[i] has items[i][0] the student's id, and items[i][1]
 * the student's score.  The average score is calculated using integer division.
 */
public class HighFive {
    public int[][] highFive(int[][] items) {
        Set<Integer> ids = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] item : items) {
            ids.add(item[0]);
            List<Integer> values = map.getOrDefault(item[0], new ArrayList<>());
            values.add(-1 * item[1]);
            map.put(item[0], values);
        }
        List<Integer> sortedIDs = new ArrayList<>();
        for (int id : ids) sortedIDs.add(id);

        Collections.sort(sortedIDs);
        int index = 0;
        int[][] output = new int[sortedIDs.size()][2];
        for (int id : sortedIDs) {
            int[] current = new int[2];
            current[0] = id;
            List<Integer> scores = map.get(id);
            Collections.sort(scores);
            int sum = 0, counter = 0;
            for (int score : scores) {
                int curr = -1 * score;
                if (counter == 5) {
                    current[1] = sum / 5;
                    break;
                } else {
                    sum += curr;
                    counter++;
                }
            }
            current[1] = sum / 5;
            output[index] = current;
            index++;
        }
        return output;
    }
}
