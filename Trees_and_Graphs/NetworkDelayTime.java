package Trees_and_Graphs;
import java.util.*;

/**
 * There are N network nodes, labelled 1 to N.
 * Given times, a list of travel times as directed edges times[i] = (u, v, w),
 * where u is the source node, v is the target node, and w is the time it takes
 * for a signal to travel from source to target.
 *
 * Now, we send a signal from a certain node K. How long will it take for all
 * nodes to receive the signal? If it is impossible, return -1.
 *
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * Output: 2
 */
public class NetworkDelayTime {
    /**
     * The algorithm below runs in O(m logm) where m is the number of vertices in the graph
     * @param times
     * @param N
     * @param K
     * @return
     */
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> adjGraph = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Compare());
        int maxTime = Integer.MIN_VALUE;
        HashSet<Integer> distances = new HashSet<>();

        for (int[] arr : times) {
            List<int[]> values = adjGraph.getOrDefault(
                    arr[0], new ArrayList<>());
            values.add(new int[]{arr[1], arr[2]});
            adjGraph.put(arr[0], values);
        }
        pq.add(new int[]{K, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int dist = current[1];

            if (distances.contains(node)) {continue;}
            distances.add(node);
            maxTime = Math.max(maxTime, dist);
            if (adjGraph.containsKey(node)) {
                Iterator<int[]> neighbors = adjGraph.get(node).listIterator();

                while (neighbors.hasNext()) {
                    int[] next = neighbors.next();
                    int newNode = next[0];
                    int newDistance = dist + next[1];

                    if (!distances.contains(newNode)) {
                        pq.add(new int[]{newNode, newDistance});
                    }
                }
            }
        }
        return distances.size() == N ? maxTime : -1;
    }
}

class Compare implements Comparator<int[]> {
    public int compare(int[] first, int[] second) {
        return first[1] - second[1];
    }
}
