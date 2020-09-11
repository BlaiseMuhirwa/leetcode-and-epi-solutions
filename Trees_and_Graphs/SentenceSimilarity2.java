package Trees_and_Graphs;
import java.util.*;
/**
 * Given two sentences words1, words2 (each represented as an array of strings),
 * and a list of similar word pairs pairs, determine if two sentences are similar.
 * For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"]
 * are similar, if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
 *
 * Note that the similarity relation is transitive. For example, if "great" and "good"
 * are similar, and "fine" and "good" are similar, then "great" and "fine" are similar.
 */
public class SentenceSimilarity2 {
    public boolean areSentencesSimilarTwo(
            String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;
        Map<String, List<String>> graph = new HashMap();
        for (List<String> pair: pairs) {
            for (String p: pair) if (!graph.containsKey(p)) {
                graph.put(p, new ArrayList());
            }
            graph.get(pair.get(0)).add(pair.get(1));
            graph.get(pair.get(1)).add(pair.get(0));
        }

        for (int i = 0; i < words1.length; ++i) {
            String w1 = words1[i], w2 = words2[i];
            Stack<String> stack = new Stack();
            Set<String> seen = new HashSet();
            stack.push(w1);
            seen.add(w1);
            search: {
                while (!stack.isEmpty()) {
                    String word = stack.pop();
                    if (word.equals(w2)) break search;
                    if (graph.containsKey(word)) {
                        for (String nei: graph.get(word)) {
                            if (!seen.contains(nei)) {
                                stack.push(nei);
                                seen.add(nei);
                            }
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }
}
