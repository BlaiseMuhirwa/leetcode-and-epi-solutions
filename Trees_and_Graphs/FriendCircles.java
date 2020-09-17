package Trees_and_Graphs;
import java.util.*;

/**
 * There are N students in a class. Some of them are friends, while some are not.
 * Their friendship is transitive in nature. For example, if A is a direct friend
 * of B, and B is a direct friend of C, then A is an indirect friend of C.
 * And we defined a friend circle is a group of students who are direct or indirect friends.
 *
 * Given a N*N matrix M representing the friend relationship between students
 * in the class. If M[i][j] = 1, then the ith and jth students are direct friends
 * with each other, otherwise not. And you have to output the total number of
 * friend circles among all the students.
 */
public class FriendCircles {
    /**
     * This algorithm runs in O(N*N) where N is the number of rows and the number of
     * columns. Or you can say, it runs in O(n) time where n is the number of items in
     * the input matrix
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;

        /* build adjacency list for the graph relationship */
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int len = M.length;
        int counter = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (M[i][j] == 1) {
                    List<Integer> firstPerson = graph.getOrDefault(
                            i, new ArrayList<>());
                    List<Integer> secondPerson = graph.getOrDefault(
                            j, new ArrayList<>());
                    firstPerson.add(j);
                    secondPerson.add(i);
                    graph.put(i, firstPerson);
                    graph.put(j, secondPerson);
                }
            }
        }
        boolean[] visited = new boolean[len];
        for (int key : graph.keySet()) {
            if (!visited[key]) {
                dfs(graph, key, visited);
                counter++;
            }
        }
        return counter;
    }

    public void dfs(Map<Integer, List<Integer>> graph, int key, boolean[] visited) {
        if (visited[key]) return;

        visited[key] = true;
        Iterator<Integer> iterator = graph.getOrDefault(key, new ArrayList<>()).listIterator();
        while (iterator.hasNext()) {
            int nextKey = iterator.next();
            if (!visited[nextKey]) {
                dfs(graph, nextKey, visited);
            }
        }
    }
}
