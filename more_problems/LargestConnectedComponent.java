package more_problems;
import java.util.*;
import java.io.*;

public class LargestConnectedComponent {
    private static int maxUsers = Integer.MIN_VALUE;

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();
        input.add("11000");
        input.add("11100");
        input.add("01100");
        input.add("00011");
        input.add("00011");

        ArrayList<String> testInput2 = new ArrayList<>();
        testInput2.add("110");
        testInput2.add("110");
        testInput2.add("001");

        System.out.println(findLargest(input));
        //System.out.println(findLargest(testInput2));
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
                    adj[i].add(j);
                }
            }
        }
        for (int i = 0; i < size; i++) {
            Iterator<Integer> iter = adj[i].listIterator();
            while (iter.hasNext()) {
                System.out.print(iter.next());
                System.out.print(" ");
            }
            System.out.println("");
        }
        boolean[] visited = new boolean[size];
        //int maxUsers = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                int counter;
                counter = dfs(adj, visited, 0, i);
                maxUsers = Math.max(maxUsers, counter);
            }
        }
        return maxUsers;
    }
    private static int dfs(LinkedList<Integer>[] adj, boolean[] visited,
     int counter, int i) {
        if (visited[i])  {
            return counter;
        }
        visited[i] = true;
        counter += 1;
        Iterator<Integer> iter = adj[i].listIterator();
        while (iter.hasNext()) {
            int newVertex = iter.next();
            if (!visited[newVertex]) {
                return dfs(adj, visited, counter, newVertex);
            }
            
        }
        return counter;
    }

}