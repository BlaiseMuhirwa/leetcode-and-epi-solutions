package more_problems;
import java.util.*;
import java.io.*;

public class LargestConnectedComponent {
    private static int counter = 1;

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();
        input.add("11001");
        input.add("11100");
        input.add("01110");
        input.add("00011");
        input.add("10011");

        ArrayList<String> testInput2 = new ArrayList<>();
        testInput2.add("110");
        testInput2.add("110");
        testInput2.add("001");

        System.out.println("for first = " + findLargest(input));
        System.out.println("for second = " + findLargest(testInput2));
    }
    public static int findLargest(List<String> input) {
        if (input == null) return 0;
        LinkedList<Integer>[] adj = new LinkedList[input.size()];
        int size = input.size();
        //adj = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            adj[i] = new LinkedList<>();
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < input.get(i).length(); j++) {
                if (input.get(i).charAt(j) == '1') {
                    if (i != j) adj[i].add(j);
                }
            }
        }

        boolean[] visited = new boolean[size];
        int maxUsers = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                Set<Integer> set = new HashSet<>();
                dfs(adj, visited, set, i);
                maxUsers = Math.max(maxUsers, set.size());
            }
        }
        return maxUsers;
    }
    private static void dfs(LinkedList<Integer>[] adj, boolean[] visited,
     Set<Integer> set, int i) {
        if (visited[i])  {
            return;
        }
        visited[i] = true;
        set.add(i);
        Iterator<Integer> iter = adj[i].listIterator();
        while (iter.hasNext()) {
            int newVertex = iter.next();
            if (!visited[newVertex]) {
                dfs(adj, visited, set, newVertex);
            }
            
        }
        
    }

}