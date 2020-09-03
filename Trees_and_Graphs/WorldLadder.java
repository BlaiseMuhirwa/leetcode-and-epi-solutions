package Trees_and_Graphs;
import java.util.*;
import javafx.util.Pair;

public class WorldLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        Map<String, List<String>> adjacentNodes = new HashMap<>();
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();

        wordList.forEach(word -> {
            for (int i = 0; i < len; i++) {
                String key = word.substring(0, i) + '*' + word.substring(i+1, len);
                List<String> values = adjacentNodes.getOrDefault(key,new ArrayList<String>());
                values.add(word);
                adjacentNodes.put(key, values);
            }
        });

        queue.add(new Pair(beginWord, 1));
        visited.put(beginWord, true);
        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();
            int level = pair.getValue();

            //get intermediate words for current word
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i+1, len);

                Iterator<String> iter = adjacentNodes.
                        getOrDefault(newWord, new ArrayList<>()).listIterator();
                while (iter.hasNext()) {
                    String adjacentWord = iter.next();
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        queue.add(new Pair(adjacentWord, level + 1));
                    }
                }

            }
        }
        return 0;
    }
}
